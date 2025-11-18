package com.mindseye.runtime

import android.bluetooth.BluetoothAdapter
import android.content.Context

object DuoBluetoothManager {

    private val btAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    fun init(ctx: Context) {
        println("Duo Bluetooth initialized")
    }

    fun buildEvent(name: String, mac: String): Map<String, Any> {

        val baseEvent = mapOf(
            "type" to "bluetooth_device_detected",
            "name" to name,
            "mac" to mac,
            "timestamp" to System.currentTimeMillis()
        )

        val fp = DeviceFingerprint.fromBluetooth(name, mac)
        val lawt = LAWTRuntime.labelEvent(baseEvent)
        return NetworkIntent.attachNetworkMetadata(lawt + fp)
    }
}
