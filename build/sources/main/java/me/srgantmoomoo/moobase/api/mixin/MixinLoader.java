package me.srgantmoomoo.moobase.api.mixin;

import java.util.Map;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class MixinLoader implements IFMLLoadingPlugin {
	
	public MixinLoader() {
		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.moobase.json");
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> arg0) {
		
	}
	

}
