package com.dodevjutsu.kata.ohce.unit;

import com.dodevjutsu.kata.ohce.Console;
import com.dodevjutsu.kata.ohce.Greeter;
import com.dodevjutsu.kata.ohce.Ohce;
import com.dodevjutsu.kata.ohce.UserInput;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class OhceShould {

	Mockery context = new Mockery();

	@Test
	public void ask_the_greeter_about_the_greeting_to_use() {

		final Console console = context.mock(Console.class);
		final UserInput userInput = context.mock(UserInput.class);
		final Greeter greeter = context.mock(Greeter.class);
		context.checking(new Expectations() {{

			oneOf(greeter).greeting(); will(returnValue("Buenos días"));

			oneOf(userInput).read(); will(onConsecutiveCalls(
					returnValue("Stop!")));

			oneOf(console).print("¡Buenos días Pedro!");
			ignoring(console);
		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, greeter);

		ohce.run();

		context.assertIsSatisfied();

	}

	@Test
	public void reverses_the_users_message() {

		final Console console = context.mock(Console.class);
		final UserInput userInput = context.mock(UserInput.class);
		final Greeter greeter = context.mock(Greeter.class);
		context.checking(new Expectations() {{

			ignoring(greeter);
			atLeast(1).of(userInput).read(); will(onConsecutiveCalls(
					returnValue("hola"),
					returnValue("Stop!")));

			oneOf(console).print("aloh");
			ignoring(console);
		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, greeter);

		ohce.run();

		context.assertIsSatisfied();

	}

	@Test
	public void reacts_to_a_palindrome_word() {

		final Console console = context.mock(Console.class);
		final UserInput userInput = context.mock(UserInput.class);
		final Greeter greeter = context.mock(Greeter.class);
		context.checking(new Expectations() {{

			ignoring(greeter);
			atLeast(1).of(userInput).read(); will(onConsecutiveCalls(
					returnValue("oto"),
					returnValue("Stop!")));

			oneOf(console).print("oto");
			oneOf(console).print("¡Bonita palabra!");
			ignoring(console);
		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, greeter);

		ohce.run();

		context.assertIsSatisfied();
	}

	@Test
	public void prints_several_inputs_from_the_user_until_the_keyword () {

		final Console console = context.mock(Console.class);
		final UserInput userInput = context.mock(UserInput.class);
		final Greeter greeter = context.mock(Greeter.class);
		context.checking(new Expectations() {{

			ignoring(greeter);
			atLeast(1).of(userInput).read();
			will(onConsecutiveCalls(
					returnValue("oto"),
					returnValue("adios"),
					returnValue("Stop!")));

			oneOf(console).print("oto");
			oneOf(console).print("soida");
			ignoring(console);
		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, greeter);

		ohce.run();

		context.assertIsSatisfied();
	}


	@Test
	public void stops_the_execution_using_a_keyword() {

		final Console console = context.mock(Console.class);
		final UserInput userInput = context.mock(UserInput.class);
		final Greeter greeter = context.mock(Greeter.class);
		context.checking(new Expectations() {{

			ignoring(greeter);
			atLeast(1).of(userInput).read(); will(returnValue("Stop!"));

			oneOf(console).print("Adios Pedro");
			ignoring(console);
		}});

		final Ohce ohce = new Ohce("Pedro", console, userInput, greeter);

		ohce.run();

		context.assertIsSatisfied();
	}


}
