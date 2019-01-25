/**
 * 
 */
package hr.generali.java.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hr.generali.java.domain.ProgLanguage;
import hr.generali.java.util.ProgLanguageComparator;
import hr.generali.java.util.Utils;

/**
 * Služi za ispis sortiranih podataka iz datoteke <code>map-mock.txt</code> na
 * konzoli.
 * <p>
 * Podaci se sortiraju pozivom metode <code>sort</code> iz klase
 * <code>Collections</code>. Nakon što se na konzoli ispišu sortirani podaci, od
 * korisnika se traži unos dva broj koji predstavljaju raspon podataka iz
 * dokumenta koji æe se prikazati korisniku. Raspon ukljucuje i ta dva broja u
 * ispis.
 * 
 * @author Igor
 *
 */
public class Main {

	/**
	 * Glavna metoda koja služi za pokretanje programa.
	 * 
	 * @param args
	 *            ulazni argumenti komandne linije (u ovom programu se ne koriste)
	 */
	public static void main(String[] args) {

		ArrayList<ProgLanguage> list = Utils.getProgramList();

		// System.out.println("Before sort.");
		// Utils.printProgramList(list);
		// System.out.println("_______________________________________");

		Collections.sort(list, new ProgLanguageComparator()); // sortiranje liste

		Utils.printProgramList(list); // ispis sortirane liste

		boolean test = true;
		int i = 0, j = 0;

		Scanner scan = new Scanner(System.in);

		// do-while se izvršava beskonaèno dok se ne upišu dva cijela broja
		do {
			System.out.println("Input two different numbers that represent range: ");

			if (scan.hasNextInt()) {
				i = scan.nextInt();
				test = false;
			} else {
				test = true;
				scan.next();
			}

			if (!test) {
				if (scan.hasNextInt()) {
					j = scan.nextInt();
					test = false;
				} else {
					test = true;
					scan.next();
				}
			}
			if(i == j) {
				test = true;
			}

		} while (test);

		Utils.printBetweenTwoValues(i, j, list);
	}

}
