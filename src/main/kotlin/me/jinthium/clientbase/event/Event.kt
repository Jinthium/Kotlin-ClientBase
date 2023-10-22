package me.jinthium.clientbase.event


open class Event {
    var cancelled = false

    fun cancel() {
        cancelled = true
    }
}