package me.srgantmoomoo.moobase.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.srgantmoomoo.moobase.api.proxy.CommonProxy;
import me.srgantmoomoo.moobase.impl.module.ModuleManager;
import me.srgantmoomoo.moobase.impl.setting.SettingManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.modid, name = Main.name, version = Main.version)
public class Main {
	public static final String modid = "moobase";
	public static final String name = "Moo Base";
	public static final String version = "0.1";
	public static final String acceptedVersions = "[1.12.2]";
	public static final String clientProxyClass = "me.srgantmoomoo.moobase.api.proxy.ClientProxy";
	public static final String commonProxyClass = "me.srgantmoomoo.moobase.api.proxy.CommonProxy";

	public static final Logger log = LogManager.getLogger("Moo Base");
	public static final EventBus EVENT_BUS = new EventManager();
	
	public static ModuleManager moduleManager;
	public static SettingManager settingManager;
	
	@Instance 
	public static Main instance;
	
	public Main() {
		instance = this;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	@SidedProxy(clientSide = clientProxyClass, serverSide = commonProxyClass)
	public static CommonProxy proxy;

	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void Init (FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		
		settingManager = new SettingManager();
		log.info("Setting Manager Initialized!");
		
		moduleManager = new ModuleManager();
		log.info("Module Manager Initialized!");
		
		log.info("Moo Base Finished Initialization");
		
	}
	
	@EventHandler
	public void PostInit (FMLPostInitializationEvent event) {
		
	}
}
