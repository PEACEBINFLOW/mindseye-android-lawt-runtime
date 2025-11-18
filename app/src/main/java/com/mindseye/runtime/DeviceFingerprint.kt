package com.mindseye.runtime

import java.security.MessageDigest

object DeviceFingerprint {

    fun fingerprint(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun fromBluetooth(name: String, mac: String): Map<String, Any> {
        val id = fingerprint(name + mac)

        return mapOf(
            "device_name" to name,
            "device_mac" to mac,
            "fingerprint" to id
        )
    }
}
