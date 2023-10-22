package me.jinthium.clientbase

import com.google.common.eventbus.EventBus
import me.jinthium.clientbase.module.manager.ModuleManager
import me.jinthium.logger.GlobalLogger
import me.jinthium.logger.LogType
import net.minecraft.client.Minecraft
import org.lwjgl.opengl.Display
import java.lang.ProcessHandle.Info

val mc = Minecraft.getMinecraft()!!
val player = Minecraft.getMinecraft().thePlayer!!
val world = Minecraft.getMinecraft().theWorld!!
val networkManager = Minecraft.getMinecraft().netHandler.networkManager!!

object ClientInstance {
    val clientInfo = ClientInfo("Name", "Version", "Latest Date for update (mm/dd/yy, ex: 10222023)")
    val moduleManager = ModuleManager()
    val eventBus = EventBus()

    fun initClient() {
        Display.setTitle(clientInfo.title)
        GlobalLogger.appendLog("Setting game title to \"${clientInfo.title}\"", LogType.INFO)
        moduleManager.initModuleManager()

        GlobalLogger.printStart()
    }
}

data class ClientInfo(val name: String, val version: String, val updateDate: String) {
    val title: String = "$name $version"
}