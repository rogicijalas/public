/**
 * 
 */
package hr.generali.java.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Slu�i za �itanje podataka iz datotek.
 * 
 * @author Igor
 *
 */
public class ProgramFileReader {

	private String target;

	/**
	 * Slu�i za kreiranje objekta klase <code>ProgramFileReader</code>, preko kojega
	 * �e se pristupati datotekama i �itati ih. Pri kreiranju objekta definira se
	 * putanja do datoteke koja �e se obra�ivati.
	 * 
	 * @param target
	 *            putanja do datoteke koja se obra�uje
	 */
	public ProgramFileReader(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	/**
	 * �ita formatiranu, odnosno tekstualnu datoteku i �itav sadr�aj stavlja u jedan
	 * string koji vra�a.
	 * 
	 * @return string koji sadr�i �itavu datoteku
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

			// bri�e se zadnji znak koji ozna�ava kraj retka (U WinOS duljine 2, Unix, MacOS
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
