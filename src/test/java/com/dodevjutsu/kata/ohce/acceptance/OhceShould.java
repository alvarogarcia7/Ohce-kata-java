package com.dodevjutsu.kata.ohce.acceptance;

import com.dodevjutsu.kata.ohce.Clock;
import com.dodevjutsu.kata.ohce.Console;
import com.dodevjutsu.kata.ohce.Ohce;
import com.dodevjutsu.kata.ohce.UserInput;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;


public class OhceShould {

	Mockery context = new Mockery();

	@Test
	public void using_ohce_during_the_night () {

		Console console = context.mock(Console.class);
		UserInput userInput = context.mock(UserInput.class);
		final Clock clock = context.mock(Clock.class);

		context.checking(new Expectations() {{
			oneOf(clock).hour(); will(returnValue(20));
			oneOf(console).print("¡Buenas noches Pedro!");
			atLeast(1).of(userInput).read();
			will(onConsecutiveCalls(
					returnValue("hola"),
					returnValue("oto"),
					returnValue("stop"),
					returnValue("Stop!")
			));
			oneOf(console).print("aloh");

			oneOf(console).print("oto");
			oneOf(console).print("¡Bonita palabra!");

			oneOf(console).print("pots");

			oneOf(console).print("Adios Pedro");

		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, clock);

		ohce.run();

		context.assertIsSatisfied();
	}

	@Test
	public void using_ohce_during_the_morning () {

		Console console = context.mock(Console.class);
		UserInput userInput = context.mock(UserInput.class);
		Clock clock = context.mock(Clock.class);
		context.checking(new Expectations() {{

			oneOf(clock).hour(); will(returnValue(6));
			oneOf(console).print("¡Buenos días Pedro!");
			atLeast(1).of(userInput).read();
			will(onConsecutiveCalls(
					returnValue("ligaresseragil"),
					returnValue("Stop!")
			));

			oneOf(console).print("ligaresseragil");
			oneOf(console).print("¡Bonita palabra!");

			oneOf(console).print("Adios Pedro");

		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, clock);

		ohce.run();

		context.assertIsSatisfied();
	}

	@Test
	public void using_ohce_during_the_afternoon() {

		Console console = context.mock(Console.class);
		UserInput userInput = context.mock(UserInput.class);
		Clock clock = context.mock(Clock.class);
		context.checking(new Expectations() {{

			oneOf(clock).hour(); will(returnValue(13));
			oneOf(console).print("¡Buenas tardes Pedro!");
			atLeast(1).of(userInput).read();
			will(onConsecutiveCalls(
					returnValue("hola amigo"),
					returnValue("Stop!")
			));
			oneOf(console).print("ogima aloh");

			oneOf(console).print("Adios Pedro");

		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, clock);

		ohce.run();

		context.assertIsSatisfied();
	}

}
