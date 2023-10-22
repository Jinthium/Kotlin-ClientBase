package me.jinthium.clientbase.utils.player

import me.jinthium.clientbase.utils.math.Rotation
import net.minecraft.client.entity.EntityPlayerSP

val EntityPlayerSP.moving get() = moveForward != 0.0f || moveStrafing != 0.0f
val EntityPlayerSP.rotation get() = Rotation(rotationYaw, rotationPitch)