package com.mindseye.runtime

object DataSplitter {

    fun split(data: ByteArray, parts: Int): List<ByteArray> {
        val size = data.size / parts
        return (0 until parts).map { idx ->
            data.copyOfRange(idx * size, (idx + 1) * size)
        }
    }
}
