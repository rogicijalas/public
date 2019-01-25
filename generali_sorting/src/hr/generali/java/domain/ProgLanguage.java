/**
 * 
 */
package hr.generali.java.domain;

/**
 * Predstavlja entitet programskog jezika koji je definiran nazivom programskog
 * jezika i cijelim brojem.
 * 
 * @author Igor
 *
 */
public class ProgLanguage {

	private String program;
	private int num;

	/**
	 * Služi za kreiranje objekta klase <code>ProgLanguage</code>, pri æemu se kod
	 * kreiranja samoga objekta definiraju naziv programskog jezika i cijeli broj.
	 * 
	 * @param program
	 *            podatak o nazivu programskog jezika
	 * @param num
	 *            cijeli broj
	 */
	public ProgLanguage(String program, int num) {
		this.program = program;
		this.num = num;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return getProgram() + " " + String.valueOf(getNum());
	}

}
