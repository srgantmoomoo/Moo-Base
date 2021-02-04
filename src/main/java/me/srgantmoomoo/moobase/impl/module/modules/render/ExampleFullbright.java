package me.srgantmoomoo.moobase.impl.module.modules.render;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.moobase.api.event.events.EventPlayerUpdate;
import me.srgantmoomoo.moobase.impl.Main;
import me.srgantmoomoo.moobase.impl.module.Category;
import me.srgantmoomoo.moobase.impl.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.init.MobEffects;

public class ExampleFullbright extends Module {
	
	public ExampleFullbright() {
		super("ExampleFullBright", "makes ur game fully bright", Keyboard.KEY_U, Category.RENDER);
	}
	private float lastGamma;

	 @Override
	 public void onEnable() {
	     super.onEnable();
	     Main.EVENT_BUS.subscribe(this);
	        
	     lastGamma = mc.gameSettings.gammaSetting;
	 }

	 @Override
	 public void onDisable() {
	     super.onDisable();
	     Main.EVENT_BUS.unsubscribe(this);
	           
	     mc.gameSettings.gammaSetting = this.lastGamma;
	 }

	 @EventHandler
	 private Listener<EventPlayerUpdate> OnPlayerUpdate = new Listener<>(p_Event -> {
	     mc.gameSettings.gammaSetting = 1000;
        mc.player.removePotionEffect(MobEffects.NIGHT_VISION);
	 });

}
