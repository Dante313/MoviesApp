package com.example.coroutines

import kotlinx.coroutines.CoroutineScope
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

class CloseableCoroutineScope : Closeable, CoroutineScope {

    override fun close() {
        TODO("Not yet implemented")
    }

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")
}