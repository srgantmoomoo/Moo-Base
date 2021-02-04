package me.srgantmoomoo.moobase.impl.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.srgantmoomoo.moobase.impl.module.Category;
import me.srgantmoomoo.moobase.impl.module.Module;

public class ExampleSprint extends Module {

	public ExampleSprint() {
		super("Sprint", "automatically sprints when u move forward.", Keyboard.KEY_R, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(mc.player.movementInput.moveForward > 0 && !mc.player.isSneaking() && !mc.player.collidedHorizontally) {
			mc.player.setSprinting(true);
		}
	}
}