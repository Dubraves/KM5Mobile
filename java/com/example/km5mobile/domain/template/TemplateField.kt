package com.example.km5mobile.domain.template

enum class TemplateField(val title: String) {
    DATE("Дата"),
    Q("Q (тепло)"),
    M1("M1 / V1 (вход)"),
    M2("M2 / V2 (выход)"),
    MIX("Подмес"),
    LEAK("Утечка"),
    T1("T1 (подача)"),
    T2("T2 (обратка)"),
    DT("ΔT"),
    P("P1 / P2"),
    TIME("Время"),
    ERR("Ошибки");

    companion object {
        val default = values().associateWith { true }    // всё включено
    }
}
