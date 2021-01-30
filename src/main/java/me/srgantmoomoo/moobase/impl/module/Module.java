package me.srgantmoomoo.moobase.impl.module;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import me.srgantmoomoo.moobase.impl.Main;
import me.srgantmoomoo.moobase.impl.setting.Setting;
import me.srgantmoomoo.moobase.impl.setting.settings.KeybindSetting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import scala.actors.threadpool.Arrays;

public class Module {
	
	protected static final Minecraft mc = Minecraft.getMinecraft();
	public static ArrayList<Module> modules;
	
	public String name, description;
	// setting system -- public KeybindSetting keyCode = new KeybindSetting(0);
	public Category category;
	public KeybindSetting keyCode = new KeybindSetting(0);
	public boolean toggled;
	public int index;
	public List<Setting> settings = new ArrayList<Setting>();
	
	public Module(String name, String description, int key, Category category) {
		super();
		this.name = name;
		this.description = description;
		keyCode.code = key;
		this.addSetting(keyCode);
		this.category = category;
		this.toggled = false;
	}
	
	protected void enable() {}
	protected void disable() {}
	
	public void addSetting(Setting... settings) {
		this.settings.addAll(Arrays.asList(settings));
		this.settings.sort(Comparator.comparingInt(s->s==keyCode?1:0));
	}
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	protected void onEnable() {
		MinecraftForge.EVENT_BUS.register(this);
		Main.EVENT_BUS.subscribe(this);
		enable();
	}

	protected void onDisable() {
		MinecraftForge.EVENT_BUS.register(this);
		Main.EVENT_BUS.subscribe(this);
		disable();
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
		
		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
		
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}
	
	public int getKey() {
		return keyCode.code;
	}
	
	public void setKey(int key) {
		this.keyCode.code = key;
		
		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}
}
