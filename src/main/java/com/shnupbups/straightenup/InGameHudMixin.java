package com.shnupbups.straightenup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@Redirect(method = "renderHeldItemTooltip(Lnet/minecraft/client/gui/DrawContext;)V", at =
	@At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;hasCustomName()Z"))
	public boolean straightenUpActionBar(ItemStack stack) {
		return false;
	}
}
