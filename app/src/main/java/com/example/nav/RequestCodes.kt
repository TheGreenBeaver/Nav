package com.example.nav

enum class RequestCodes() {
    THIRD_TO_FIRST {
        override fun getValue(): Int = 95
    };

    abstract fun getValue(): Int
}