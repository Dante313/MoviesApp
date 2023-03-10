package com.example.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.launch

private const val BufferSize = 64

internal interface StateReducerFlow<S : State, A : Action> : StateFlow<S>, Dispatcher<A>

internal fun <S : State, A : Action> stateReducerFlow(
    initialState: S,
    scope: CoroutineScope,
    reducer: Reducer<S, A>,
    middlewares: List<Middleware<S, A>> = emptyList()
): StateReducerFlow<S, A> = StateReducerFlowImpl(
    initialState,
    reducer,
    middlewares,
    scope
)

private class StateReducerFlowImpl<S : State, A : Action>(
    initialState: S,
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<S, A>>,
    private val scope: CoroutineScope
) : StateReducerFlow<S, A> {

    private val actions = MutableSharedFlow<A>(extraBufferCapacity = BufferSize)

    private val stateFlow: StateFlow<S> = actions
        .runningFold(initialState, ::reduce)
        .stateIn(
            scope = scope,
            started = Eagerly,
            initialValue = initialState
        )

    override val replayCache
        get() = stateFlow.replayCache

    override suspend fun collect(collector: FlowCollector<S>): Nothing {
        stateFlow.collect(collector)
    }

    override val value
        get() = stateFlow.value

    override fun dispatch(action: A) {
        scope.launch { actions.emit(action) }
    }

    private fun reduce(state: S, action: A): S {
        middlewares.forEach { middleware -> middleware.process(state, action) }
        return reducer.reduce(state, action)
    }
}