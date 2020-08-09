package com.shnupbups.straightenup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Formatting;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@ModifyArg(method = "renderHeldItemTooltip(Lnet/minecraft/client/util/math/MatrixStack;)V", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;"))
	public Formatting straightenUpActionBar(Formatting formatting) {
		return Formatting.RESET;
	}
}
