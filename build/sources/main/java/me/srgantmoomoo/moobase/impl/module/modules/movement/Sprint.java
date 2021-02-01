package me.srgantmoomoo.moobase.impl.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.moobase.impl.module.Category;
import me.srgantmoomoo.moobase.impl.module.Module;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", "description", Keyboard.KEY_R, Category.MOVEMENT);
	}
	
	public void onEnable() {
		super.onEnable();
		mc.player.setSprinting(true);
	}

}
