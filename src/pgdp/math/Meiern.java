package pgdp.math;

import static pgdp.MiniJava.*;

public class Meiern {
	public static void main(String[] args) {

		int running = 1;
		int player = 1;
		int lastThrow = 1;

		while (running == 1) {
			int firstRoll = dice();
			int secondRoll = dice();
			int totalRoll;

			if (firstRoll > secondRoll) {
				totalRoll = firstRoll * 10 + secondRoll;
			} else {
				totalRoll = secondRoll * 10 + firstRoll;
			}
			if (player == 1) {
				writeConsole("Der Spieler würfelt: ");
			} else {
				writeConsole("Der Computer würfelt: ");
			}
			writeLineConsole(totalRoll);

			if (totalRoll == 21) {
				// "Meier" wins instantly
				running = 0;
				write("Meier!");
				// At game end its assumed the current player lost, so we need
				// to change it
				player *= -1;
			} else if (firstRoll != secondRoll
					&& (lastThrow / 10) == (lastThrow % 10)) {
				// A non-double always loses against a double
				running = 0;
				write("Nicht überboten!");
			} else if (firstRoll == secondRoll
					&& (lastThrow / 10) != (lastThrow % 10)) {
				// A non-double always loses against a double, other way round
				write("Überboten!");
			} else if (totalRoll <= lastThrow) {
				// Otherwise the numerical value matters
				running = 0;
				write("Nicht überboten!");
			} else {
				// If you dont lose, you win
				write("Überboten!");
			}

			lastThrow = totalRoll;
			player *= -1;
		}

		if (player == 1) {
			write("Der Spieler gewinnt!");
		} else {
			write("Der Computer gewinnt!");
		}
	}
}

