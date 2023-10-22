package me.jinthium.clientbase.module.manager

import com.google.common.eventbus.Subscribe
import me.jinthium.clientbase.ClientInstance
import me.jinthium.clientbase.event.impl.KeyPressEvent
import me.jinthium.clientbase.mc
import me.jinthium.clientbase.module.Module
import me.jinthium.clientbase.module.implementations.movement.SprintModule
import me.jinthium.logger.GlobalLogger
import me.jinthium.logger.LogType

class ModuleManager : LinkedHashMap<Class<out Module>, Module>() {

    fun initModuleManager() {
        add(
                SprintModule
        )
        ClientInstance.eventBus.register(this)
    }

    @Subscribe
    fun onKeyPressEvent(event: KeyPressEvent) {
        if(mc.currentScreen != null)
            return

        for(module in this){
            if(module.value.key == event.key) {
                module.value.toggle()
            }
        }
    }

    fun add(vararg modules: Module) {
        for(module in modules) {
            this[module.javaClass] = module
            GlobalLogger.appendLog("Added ${module.name} to the module list.", LogType.INFO)
        }
    }
}