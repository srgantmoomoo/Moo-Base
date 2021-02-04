package me.srgantmoomoo.moobase.impl.module.modules.player;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.moobase.api.event.events.EventPacket;
import me.srgantmoomoo.moobase.impl.Main;
import me.srgantmoomoo.moobase.impl.module.Category;
import me.srgantmoomoo.moobase.impl.module.Module;
import me.srgantmoomoo.moobase.impl.setting.settings.NumberSetting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;

public class ExampleVelocity extends Module {
	public NumberSetting percent = new NumberSetting("percent", this, 0, 0, 100, 10);
	
	public ExampleVelocity() {
		super("Velocity", "stops you from taking knockback", Keyboard.KEY_NONE, Category.PLAYER);
	}
	
	public void onEnable() {
		Main.EVENT_BUS.subscribe(this);
	}

	public void onDisable() {
		Main.EVENT_BUS.unsubscribe(this);
	}
	
	@EventHandler
	private final Listener<EventPacket.Receive> receiveListener = new Listener<>(event -> {
		if (event.getPacket() instanceof SPacketEntityVelocity){
			if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId()) {
				event.cancel();
			}
		}
		if (event.getPacket() instanceof SPacketExplosion){
			event.cancel();
		}
	});
}
