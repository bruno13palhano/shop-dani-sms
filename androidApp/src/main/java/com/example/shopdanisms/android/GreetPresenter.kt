package com.example.shopdanisms.android

import com.example.shopdanisms.Greeting

class GreetPresenter(val greet: Greeting) {
    fun print() = greet.greet()
}