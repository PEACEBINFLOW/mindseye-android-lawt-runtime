package com.mindseye.runtime

object EventMapper {

    fun basic(type: String, payload: Map<String, Any>): Map<String, Any> {
        val base = mapOf(
            "event_type" to type,
            "timestamp" to System.currentTimeMillis()
        ) + payload

        val lawt = LAWTRuntime.labelEvent(base)
        return NetworkIntent.attachNetworkMetadata(lawt)
    }
}
