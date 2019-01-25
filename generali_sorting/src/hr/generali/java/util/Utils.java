/**
 * 
 */
package hr.generali.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hr.generali.java.domain.ProgLanguage;

/**
 * Sadrži metode za dohvaæanje liste podataka iz datoteke, metodu za ispisivanje
 * liste programskih jezika i metodu za odreðivanje raspona liste izmeðu dva
 * cijela broja.
 * 
 * @author Igor
 *
 */
public class Utils {

	/**
	 * Vraæa listu Programski jezika iz datoteke <code>map-mock.txt</code>
	 * <p>
	 * Podaci se dohvaæaju kao jedan <code>String</code> iz datoteke
	 * <code>map-mock.txt</code> te se razdvajaju na dijelove koj su odreðeni znakom
	 * za novi red. Svaki taj dio predstavlja jedan entitet
	 * <code>ProgLanguage</code>. Sastoji se od naziva programskog jezika i cijelog
	 * broja, a podaci su meðusobno odvojeni znakom <tt>";"</tt>
	 * 
	 * @return listu objekata tipa <code>ProgLanguage</code>
	 */
	public static ArrayList<ProgLanguage> getProgramList() {

		ArrayList<ProgLanguage> progList = new ArrayList<>();

		ProgramFileReader progInFile = new ProgramFileReader("map-mock.txt");

		String test = progInFile.readString();

		String[] lines = test.split(System.getProperty("line.separator"));
		for (String line : lines) {
			String[] params = line.split(";");

			progList.add(new ProgLanguage(params[0].trim(), Integer.parseInt(params[1].trim())));
		}

		return progList;
	}

	/**
	 * Ispisuje na ekranu listu entiteta <code>ProgLanguage</code>
	 * 
	 * @param programs
	 *            lista <code>ProgLanguage</code>
	 */
	public static void printProgramList(List<ProgLanguage> programs) {

		if (programs.isEmpty()) {
			System.out.println("The list is empty.");
		} else {
			for (ProgLanguage program : programs) {
				System.out.println(program.toString());
			}
			System.out.println("_______________________________________");
		}
	}

	/**
	 * Ispisuje na ekranu sortiranu listu entiteta <code>ProgLanguage</code> u
	 * rasponu izmeðu dva cijela broja koja se zadaju.
	 * 
	 * @param i
	 *            prvi cijeli broj, prva granica
	 * @param j
	 *            drugi cijeli broj, druga granica
	 * @param sortedList
	 *            sortirana lista <code>ProgLanguage</code> entiteta
	 */
	public static void printBetweenTwoValues(int i, int j, ArrayList<ProgLanguage> sortedList) {

		// osigurava se da je indeksu i pridružen najmannji broj raspona
		if (j < i) {
			int temp = i;
			i = j;
			j = temp;
		}

		// Binarno pretraživanje sortirane liste
		int index1 = Collections.binarySearch(sortedList, new ProgLanguage(null, i), new ProgLanguageComparator());
		int index2 = Collections.binarySearch(sortedList, new ProgLanguage(null, j + 1), new ProgLanguageComparator());

		if (index1 < 0)
			index1 = -(index1 + 1);
		if (index2 < 0)
			index2 = -(index2 + 1);

		if (index2 < index1) {
			System.out.println("The list is empty.");
		} else {

			// Kreira podlistu iz osnovne liste ovisno o rasponu i ispisuje ju.
			ArrayList<ProgLanguage> list = new ArrayList<>(sortedList.subList(index1, index2));
			printProgramList(list);
		}
	}
}
