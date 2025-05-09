package com.example.km5mobile.domain.template

enum class DeviceType(val title: String) {
    KM5_1("КМ‑5‑1"),
    KM5_2("КМ‑5‑2"),
    KM5_4("КМ‑5‑4");

    companion object {
        fun titles() = values().map { it.title }
    }
}
