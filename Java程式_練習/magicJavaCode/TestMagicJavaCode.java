import java.lang.reflect.Field;

public class TestMagicJavaCode {

    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        Class<?> declaredClasses0 = Integer.class.getDeclaredClasses()[0];
        Field declaredField = declaredClasses0.getDeclaredField("cache");
        declaredField.setAccessible(true);
        Integer[] integerArray = (Integer[]) declaredField.get(declaredClasses0);
        integerArray[132] = integerArray[133];

        System.out.printf("%d%n", 2 + 2);
        // System.out.printf("%s%n", String.valueOf(2 + 2));
    }

}

// System.out.printf("%d%n", 2 + 2);
// sample output: 5
