package basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: mnikitin
 * Date: 2/3/15
 * Time: 5:56 PM
 *
 * This method shows some rules regarding methods of Object class.
 */
public class ObjectTest {

	@Test
	public void testClone() {
		try {
			CloneableObject x = new CloneableObject("original field");
			Object xClone = x.clone();

			String message = "Cloned object should be != to original object.";
			System.out.println(message);
			assertTrue(message, xClone != x);

			message = "Cloned object should be .equal to original object. (If .equals method have been overridden)";
			System.out.println(message);
			assertTrue(message, xClone.equals(x));

			message = "Cloned object should have the same class as original object.";
			System.out.println(message);
			assertEquals(message, xClone.getClass(), x.getClass());

			message = "Clone convention: clone and original object should be independent of each other. Deep clone could help to avoid it.";
			System.out.println(message);

			message = "Default implementation of clone method creates new instance of the same Class and then fills all fields by copying them from original object.";
			System.out.println(message);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = CloneNotSupportedException.class)
	public void testCloneOrdinaryObject() throws CloneNotSupportedException {
		System.out.println("Only Cloneable objects could be cloned.");
		new NonCloneableObject().clone();
	}

	public static class NonCloneableObject {

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	public static class CloneableObject implements Cloneable {

		private final String field;

		public CloneableObject(String field) {
			this.field = field;
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof CloneableObject)) return false;

			CloneableObject that = (CloneableObject) o;

			if (!field.equals(that.field)) return false;

			return true;
		}

		@Override
		public int hashCode() {
			return field.hashCode();
		}
	}
}
