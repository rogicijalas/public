/**
 * 
 */
package hr.generali.java.util;

import java.util.Comparator;

import hr.generali.java.domain.ProgLanguage;

/**
 * Služi za sortiranje objekata tipa <code>ProgLanguage</code> prema vrijednosti cijeloga broja.
 * <p>
 * Sortiranje je uzlazno.
 * @author Igor
 *
 */
public class ProgLanguageComparator implements Comparator<ProgLanguage> {

	@Override
	public int compare(ProgLanguage arg0, ProgLanguage arg1) {

		if (arg0.getNum() < arg1.getNum()) {
			return -1;
		} else if (arg0.getNum() > arg1.getNum()) {
			return 1;
		} else {
			return 0;
		}

	}

}
