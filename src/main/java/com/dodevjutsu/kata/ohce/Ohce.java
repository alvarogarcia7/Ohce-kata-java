package com.dodevjutsu.kata.ohce;

public class Ohce {
	private final String userName;
	private final Console console;
	private final UserInput userInput;
	private final Greeter greeter;

	public Ohce (final String userName, final Console console,
	             final UserInput userInput, final Clock clock) {
		this(userName, console, userInput, new DayTimeGreeter(clock));
	}

	public Ohce (final String userName, final Console console,
	             final UserInput userInput, final Greeter greeter) {
		this.userName = userName;
		this.console = console;
		this.userInput = userInput;
		this.greeter = greeter;
	}

	public void run () {
		console.print(String.format("¡%s %s!", greeter.greeting(), userName));
		while (true) {
			String input = userInput.read();
			if (shouldStop(input)) {
				console.print(String.format("%s %s", "Adios", userName));
				return;
			}
			final String reversed = reverse(input);
			console.print(reversed);
			if (reversed.equals(input)) {
				console.print("¡Bonita palabra!");
			}
		}

	}

	private boolean shouldStop (final String input) {
		return "Stop!".equals(input);
	}

	private String reverse (final String message) {
		return new StringBuilder(message).reverse().toString();
	}
}
