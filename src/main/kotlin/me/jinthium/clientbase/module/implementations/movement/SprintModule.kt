package me.jinthium.clientbase.module.implementations.movement

import com.google.common.eventbus.Subscribe
import me.jinthium.clientbase.event.impl.PlayerUpdateEvent
import me.jinthium.clientbase.module.Category
import me.jinthium.clientbase.module.Module
import me.jinthium.clientbase.player
import me.jinthium.clientbase.utils.player.moving
import org.lwjgl.input.Keyboard

object SprintModule : Module("Sprint", "Sprints for u", Keyboard.KEY_V, Category.MOVEMENT) {

    @Subscribe
    fun onPlayerUpdateEvent(event: PlayerUpdateEvent) {
        if(event.isPre() && !player.isSprinting && player.moving){
            player.isSprinting = true
        }
    }
}