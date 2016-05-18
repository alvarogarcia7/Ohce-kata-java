package com.dodevjutsu.kata.ohce;

public class Greeter {
	private final Clock clock;

	public Greeter (final Clock clock) {
		this.clock = clock;
	}

	public String greeting () {
		final DayPeriod dayPeriod = DayPeriod.at(clock.hour());
		if(dayPeriod.isMorning()){
			return "Buenos días";
		} else if(dayPeriod.isAfternoon()){
			return "Buenas tardes";
		} else {
			return "Buenas noches";
		}
	}
}
