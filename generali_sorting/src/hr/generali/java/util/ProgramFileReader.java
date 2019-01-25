/**
 * 
 */
package hr.generali.java.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Služi za èitanje podataka iz datotek.
 * 
 * @author Igor
 *
 */
public class ProgramFileReader {

	private String target;

	/**
	 * Služi za kreiranje objekta klase <code>ProgramFileReader</code>, preko kojega
	 * æe se pristupati datotekama i èitati ih. Pri kreiranju objekta definira se
	 * putanja do datoteke koja æe se obraðivati.
	 * 
	 * @param target
	 *            putanja do datoteke koja se obraðuje
	 */
	public ProgramFileReader(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	/**
	 * Èita formatiranu, odnosno tekstualnu datoteku i èitav sadržaj stavlja u jedan
	 * string koji vraæa.
	 * 
	 * @return string koji sadrži èitavu datoteku
	 */
	public String readString() {
		StringBuilder string = new StringBuilder();

		BufferedReader read = null;

		try {
			read = new BufferedReader(new FileReader(getTarget()));
			String line;

			while ((line = read.readLine()) != null) {
				if (line.trim().length() > 0) {
					string.append(line.trim());
					string.append(System.getProperty("line.separator"));
				}
			}

			// briše se zadnji znak koji oznaèava kraj retka (U WinOS duljine 2, Unix, MacOS
			// duljine 1)
			string.setLength(string.length() - 2);

			read.close();

		} catch (IOException e) {
			System.err.println("Error while opening file " + getTarget());
			e.printStackTrace();

		} finally {
			try {
				if (read != null) {
					read.close();
				}
			} catch (IOException e) {
				System.err.println("Error while closing file " + getTarget());
				e.printStackTrace();
			}
		}

		return string.toString();
	}
}
