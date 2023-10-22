package me.jinthium.clientbase.module

import me.jinthium.clientbase.ClientInfo
import me.jinthium.clientbase.ClientInstance

open class Module(val name: String, val description: String, val key: Int, val category: Category) {
    var enabled = false

    constructor(name: String, description: String, category: Category) : this(name, description, 0, category)

    fun onEnable() {
        ClientInstance.eventBus.register(this)
        println("Enabled: $name")
    }

    fun onDisable() {
        ClientInstance.eventBus.unregister(this)
        println("Disabled: $name")
    }

    fun toggle() {
        toggle(!enabled)
    }

    fun toggle(enabled: Boolean) {
        if(this.enabled == enabled)
            return

        this.enabled = enabled
        if(this.enabled)
            onEnable()
        else
            onDisable()
    }
}

enum class Category(val categoryName: String) {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    MISC("Misc"),
    EXPLOIT("Misc")
}