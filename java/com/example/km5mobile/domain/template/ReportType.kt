package com.example.km5mobile.domain.template

enum class ReportType(val title: String) {
    DAILY("Посуточная"),
    HOURLY("Почасовая");

    companion object {
        fun titles() = values().map { it.title }
    }
}
