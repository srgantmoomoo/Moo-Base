package me.srgantmoomoo.moobase.impl.setting.settings;

import me.srgantmoomoo.moobase.impl.Main;
import me.srgantmoomoo.moobase.impl.module.Module;
import me.srgantmoomoo.moobase.impl.setting.Setting;

public class BooleanSetting extends Setting {
	public boolean enabled;
	
	public BooleanSetting(String name, Module parent, boolean enabled) {
		this.name = name;
		this.parent = parent;
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;

		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}
	
	public void toggled() {
		this.enabled = !this.enabled;

		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}

}
