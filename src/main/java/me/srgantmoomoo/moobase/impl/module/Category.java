package me.srgantmoomoo.moobase.impl.module;

public enum Category {
	PLAYER("Player"), RENDER("Render"), COMBAT("Combat"), EXPLOITS("Exploits"), MOVEMENT("Movement"), CLIENT("Client");
	
	public String name;
	public int moduleIndex;
	
	Category(String name) {
		this.name = name;
	}

}

