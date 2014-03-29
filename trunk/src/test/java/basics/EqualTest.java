package basics;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TITLE:<br/>
 * Keeps tests about equal tricks<br/>
 * <p/>
 * THEORY:<br/>
 * 'x.equals(y)' - compares two different objects and check if they are "equal" in their terms<br/>
 * '==' - (OBJECT CASE) checks if references point on the same object<br/>
 * '==' - (PRIMITIVE CASE) checks if variables have the same values<br/>
 * <p/>
 * RESULTS:<br/>
 * - It's not the same: "a" and 'new String("a")'<br/>
 * <p/>
 * LINKS:<br/>
 * - (eng) http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.21<br/>
 * - (rus) http://habrahabr.ru/post/79913<br/>
 * <p/>
 * QUESTIONS AND ANSWERS:<br/>
 * Q: Why "Hello World!" object has only one instance in JVM? Even if it is a composite of strings.<br/>
 * A: String.intern() function is a reason ( link: http://habrahabr.ru/post/79913 )<br/>
 */
public class EqualTest {

	@Test
	public void autoBoxingStrings() {
		String autoBoxed = "Hello World!";
		String autoBoxedDuplicate = "Hello World!";
		String referenceOnAutoBoxed = autoBoxed;

		assertTrue(autoBoxed == autoBoxedDuplicate);
		assertTrue(autoBoxed == referenceOnAutoBoxed);
		assertTrue(autoBoxedDuplicate == referenceOnAutoBoxed);

		assertTrue(autoBoxed.equals(autoBoxedDuplicate));
		assertTrue(autoBoxed.equals(referenceOnAutoBoxed));
		assertTrue(autoBoxedDuplicate.equals(referenceOnAutoBoxed));
	}

	@Test
	public void newInstanceStrings() {
		String newInstance = new String("Hello World!");
		String anotherNewInstance = new String("Hello World!");
		String referenceOnNewInstance = newInstance;

		assertFalse(newInstance == anotherNewInstance);
		assertTrue(newInstance == referenceOnNewInstance);
		assertFalse(anotherNewInstance == referenceOnNewInstance);

		assertTrue(newInstance.equals(anotherNewInstance));
		assertTrue(newInstance.equals(referenceOnNewInstance));
		assertTrue(anotherNewInstance.equals(referenceOnNewInstance));
	}

	@Test
	public void partlyStrings() {
		String autoBoxed = "Hello World!";
		String autoBoxedComposition = "Hello" + " " + "World!";
		String referenceOnAutoBoxedComposition = autoBoxedComposition;

		assertTrue(autoBoxed == autoBoxedComposition);
		assertTrue(autoBoxedComposition == referenceOnAutoBoxedComposition);
		assertTrue(autoBoxed == referenceOnAutoBoxedComposition);

		assertTrue(autoBoxed.equals(autoBoxedComposition));
		assertTrue(autoBoxedComposition.equals(referenceOnAutoBoxedComposition));
		assertTrue(autoBoxed.equals(referenceOnAutoBoxedComposition));
	}

	@Test
	public void mixedStrings() {
		assertTrue("Hello World!" != new String("Hello World!"));
		assertTrue("Hello World!".equals(new String("Hello World!")));
	}

	@Test
	public void testOperationOrder() {
		assertTrue("Hello World!" == "Hello" + " " + "World!" == true);
	}

	@Test
	public void testDoubleNaNNotEquals() {
		assertTrue(Double.NaN != Double.NaN);
	}
}
