package me.srgantmoomoo.moobase.api.event.events;

import me.srgantmoomoo.moobase.api.event.Event;

public class EventPlayerJoin extends Event {

	private final String name;

	public EventPlayerJoin(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}