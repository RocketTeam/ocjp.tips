package basics;

import org.junit.Test;

/**
 * User: mnikitin
 * Date: 3/2/15
 * Time: 8:26 PM
 *
 * This test shows all tricks that could occur
 * when primitive or autoboxed value is passed to method as arguments
 */
public class MethodArgumentScopeTest {

    @Test
    public void test_primitiveScopes() {
        byte primitiveByte = 2;
        short primitiveShort = 2;
        int primitiveInt = 2;
        Short objectShort = 2;
        Integer objectInteger = 2;
        Number objectNumber = 2;

        System.out.println("When all types are matched:");
        System.out.print("Primitive byte");
        noTypeCast(primitiveByte);
        System.out.print("Primitive short");
        noTypeCast(primitiveShort);
        System.out.print("Primitive int");
        noTypeCast(primitiveInt);
        System.out.print("Short");
        noTypeCast(objectShort);
        System.out.print("Integer");
        noTypeCast(objectInteger);
        System.out.print("Number");
        noTypeCast(objectNumber);

        System.out.println("\nWhen most appropriate primitive is chosen:");
        System.out.print("Primitive byte");
        shortOrInt(primitiveByte);

        System.out.println("\nWhen primitive is chosen, but not an object wrapper:");
        System.out.print("Primitive int");
        intOrInteger(primitiveInt);
    }

    private void noTypeCast(byte value) {
        System.out.println(" was passed as primitive byte.");
    }

    private void noTypeCast(short value) {
        System.out.println(" was passed as primitive short.");
    }

    private void noTypeCast(int value) {
        System.out.println(" was passed as primitive int.");
    }

    private void noTypeCast(Short value) {
        System.out.println(" was passed as Short.");
    }

    private void noTypeCast(Integer value) {
        System.out.println(" was passed as Integer.");
    }

    private void noTypeCast(Number value) {
        System.out.println(" was passed as Number.");
    }

    private void shortOrInt(short value) {
        System.out.println(" was passed as primitive short.");
    }

    private void shortOrInt(int value) {
        System.out.println(" was passed as primitive int.");
    }

    private void intOrInteger(int value) {
        System.out.println(" was passed as primitive int.");
    }

    private void intOrInteger(Integer value) {
        System.out.println(" was passed as Integer.");
    }
}
