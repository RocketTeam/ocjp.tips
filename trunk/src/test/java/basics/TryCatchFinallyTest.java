package basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: mnikitin
 * Date: 2/2/15
 * Time: 9:07 PM
 *
 * TODO: implement all possible combinations
 */
public class TryCatchFinallyTest {

	public static final String RESULT_FINALLY = "Finally is result.";

	@Test
	public void returnOrder() {
		String result = throwExceptionInCatchBlock();
		String message = "'Finally' section always executes it's body." +
				"No matter were or not there any exceptions in try or catch block";
		assertEquals(message, RESULT_FINALLY, result);
	}

	private String throwExceptionInCatchBlock() {
		try {
			doSomethingWrong();
		} catch (Exception e) {
			throw new Exception("Re-throwing exception", e);
		} finally {
			return RESULT_FINALLY;
		}
	}

	private void doSomethingWrong() throws Exception {
		throw new Exception("Something goes totally wrong!");
	}
}
