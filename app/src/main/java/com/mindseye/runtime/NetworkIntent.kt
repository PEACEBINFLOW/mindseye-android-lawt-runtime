package com.mindseye.runtime

object NetworkIntent {

    fun attachNetworkMetadata(event: Map<String, Any>): Map<String, Any> {

        val meta = mapOf(
            "channel" to "device",
            "priority" to "normal",
            "reliability" to "must_deliver",
            "source" to "android"
        )

        return event + meta
    }
}
