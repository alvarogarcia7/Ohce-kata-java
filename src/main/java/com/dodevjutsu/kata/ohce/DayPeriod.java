package com.dodevjutsu.kata.ohce;

public class DayPeriod {
	final int hour;

	private DayPeriod (final int hour) {
		this.hour = hour;
	}

	public static DayPeriod at (final int hour) {
		return new DayPeriod(hour);
	}

	public boolean isMorning () {
		return hour >= 6 && hour < 12;
	}

	public boolean isAfternoon () {
		return (hour >= 12 && hour < 20);
	}
}
