package com.shnupbups.straightenup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;

@Mixin(ItemStack.class)
public class ItemStackMixin {
	@Environment(EnvType.CLIENT)
	@Redirect(method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;hasCustomName()Z"))
	private boolean straightenUpTooltip(ItemStack stack) {
		return false;
	}
	
	@Redirect(method = "toHoverableText()Lnet/minecraft/text/Text;", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;hasCustomName()Z"))
	private boolean straightenUpHoverText(ItemStack stack) {
		return false;
	}
}
