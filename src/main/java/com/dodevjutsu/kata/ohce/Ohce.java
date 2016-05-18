package com.dodevjutsu.kata.ohce;


public class Ohce {
	private final String userName;
	private final Console console;
	private final UserInput userInput;
	private final Clock clock;
	private Greeter greeter;

	public Ohce (final String userName, final Console console, final UserInput userInput, final Clock clock) {
		this.userName = userName;
		this.console = console;
		this.userInput = userInput;
		this.clock = clock;
		greeter = new Greeter(clock);
	}

	public void run () {
		greet();

		while (true) {
			String input = userInput.read();
			if (shouldStop(input)) {
				break;
			}

			final String reverse = reverse(input);
			echo(reverse);

			if (isPalindrome(input, reverse)) {
				sayPalindromeRocks();
			}
		}

		sayGoodbye();
	}

	private void echo (final String reverse) {
		console.print(reverse);
	}

	private void greet () {
		String greeting = greeter.greeting();
		console.print(String.format("¡%s %s!", greeting, userName));
	}

	private void sayGoodbye () {
		console.print(String.format("Adios %s", userName));
	}

	private void sayPalindromeRocks () {
		console.print("¡Bonita palabra!");
	}

	private boolean shouldStop (final String input) {
		return "Stop!".equals(input);
	}

	private boolean isPalindrome (final String input, final String reverse) {
		return reverse.equals(input);
	}


	private String reverse (final String message) {
		return new StringBuilder(message).reverse().toString();
	}
}
