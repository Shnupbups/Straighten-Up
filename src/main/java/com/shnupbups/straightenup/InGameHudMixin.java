package com.shnupbups.straightenup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Formatting;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@ModifyArg(method = "renderHeldItemTooltip()V", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/text/Text;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/Text;"))
	public Formatting straightenUpActionBar(Formatting formatting) {
		return Formatting.RESET;
	}
}
