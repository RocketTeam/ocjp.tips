package basics;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * TITLE:<br/>
 * Keeps tests about main tricky features about identifiers<br/>
 * <p/>
 * THEORY:<br/>
 * - the first char of any identifier must be letter or '_' or '$'<br/>
 * - an identifier may contain letters, digits, chars '_' and '$'<br/>
 * - an identifier may contain letters from latin alphabet and from other alphabets as well: cyrillic, greek, chinese, etc<br/>
 * <p/>
 * LINKS:<br/>
 * http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8
 */
public class ValidIdentifiersTest {

	@Test
	public void _testUnderscore() {
	}

	@Test
	public void $testDollarSign() {
	}

	@Test
	public void testDollarSign() {
	}

	@Test
	public void testCharDifference() {
		// latin C letter
		assertTrue("latin".equals(getAlphabetTypeForC()));
		// cyrillic С letter
		assertTrue("cyrillic".equals(getAlphabetTypeForС()));
	}

	private String getAlphabetTypeForC() {
		return "latin";
	}

	private String getAlphabetTypeForС() {
		return "cyrillic";
	}

	/**
	 * Tests cyrillic method name
	 */
	@Test
	public void тестКириллическихБубенцов() {
		пасхальныеБубенцы();
	}

	/**
	 * Cyrillic name of a method
	 */
	private static void пасхальныеБубенцы() {
		System.out.println("- Бог мой! Что это?");
		System.out.println(new ДостоверныйИсточник().поведатьИстину());
	}

	/**
	 * Cyrillic name of inner class
	 */
	private static class ДостоверныйИсточник {

		// cyrillic name of constant
		private static final String ДОСТОВЕРНАЯ_ИНФОРМАЦИЯ = "- Пасхальные бубенцы Фаберже";
		// cyrillic name of class field
		private String обращение;

		public ДостоверныйИсточник() {
			this.обращение = "друг мой кудрявый";
		}

		public String поведатьИстину() {
			return ДОСТОВЕРНАЯ_ИНФОРМАЦИЯ + ", " + обращение;
		}
	}
}
