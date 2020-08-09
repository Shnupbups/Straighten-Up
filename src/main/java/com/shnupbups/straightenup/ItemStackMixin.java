package com.shnupbups.straightenup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;

@Mixin(ItemStack.class)
public class ItemStackMixin {
	@Environment(EnvType.CLIENT)
	@ModifyArg(method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;"))
	private Formatting straightenUpTooltip(Formatting formatting) {
		return Formatting.RESET;
	}
	
	@ModifyArg(method = "toHoverableText()Lnet/minecraft/text/Text;", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;"))
	private Formatting straightenUpHoverText(Formatting formatting) {
		return Formatting.RESET;
	}
}
