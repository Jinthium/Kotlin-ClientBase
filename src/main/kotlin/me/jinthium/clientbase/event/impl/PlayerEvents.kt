package me.jinthium.clientbase.event.impl

import me.jinthium.clientbase.event.Event
import me.jinthium.clientbase.utils.math.Position
import me.jinthium.clientbase.utils.math.Rotation

class PlayerUpdateEvent(var eventState: EventState, var position: Position, var rotation: Rotation, var prevRotation: Rotation, var onGround: Boolean): Event() {
    enum class EventState {
        PRE,
        POST
    }

    fun isPre(): Boolean {
        return eventState == EventState.PRE
    }

    fun isPost(): Boolean {
        return  eventState == EventState.POST
    }
}