package me.srgantmoomoo.moobase.api.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

@Mixin({GuiMainMenu.class})
public class MixinGuiMainMenu extends GuiScreen {
	@Inject(method = {"drawScreen"}, at = {@At("TAIL")}, cancellable = true)
	public void drawText(CallbackInfo ci) {
		mc.fontRenderer.drawStringWithShadow(TextFormatting.GRAY + "made by " + TextFormatting.LIGHT_PURPLE + "SrgantMooMoo!", 1, 1, 0xffffff);
	}
	
}
