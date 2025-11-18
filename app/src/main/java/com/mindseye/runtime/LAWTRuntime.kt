package com.mindseye.runtime

import java.text.SimpleDateFormat
import java.util.*

object LAWTRuntime {

    fun init() {
        println("LAW-T Runtime initialized")
    }

    fun labelEvent(event: Map<String, Any>): Map<String, Any> {
        val now = Date()
        val blockId = SimpleDateFormat("yyyy-MM-dd").format(now)
        val segmentId = SimpleDateFormat("yyyy-MM-dd'T'HH").format(now)

        val lawt = mapOf(
            "blockId" to "daily_$blockId",
            "segmentId" to segmentId
        )

        return event + lawt
    }
}
