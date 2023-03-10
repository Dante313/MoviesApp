package com.example.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

/** Предоставляет [CoroutineDispatcher]'ы для использования в приложении */
interface DispatcherProvider {

    /** [CoroutineDispatcher] для вычисляемых на CPU задач. */
    val default: CoroutineContext

    /** [CoroutineDispatcher] для IO задач. */
    val io: CoroutineContext

    /** [CoroutineDispatcher] для UI задач. */
    val main: CoroutineContext

    /** [CoroutineDispatcher] для CPU зависимых задач, выполняемых сразу. */
    val mainImmediate: CoroutineContext

    /** [CoroutineDispatcher] не привязанный к какому-либо конкретному потоку. */
    val unconfined: CoroutineContext
}