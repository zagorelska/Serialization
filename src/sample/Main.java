package sample;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {

        Test tc = new Test();
        Class<?> cls = Test.class;
        Field[] fields = cls.getDeclaredFields();
        String result = "";

        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) field.setAccessible(true);
                result += field.get(tc).toString() + System.lineSeparator();
            }
        }
        if (result.length() > 0) {
            tc.serialization(result);
            tc.deseralization();
        }
    }

}

