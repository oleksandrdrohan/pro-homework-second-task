import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            final Class<?> cls = TextContainer.class;
            TextContainer obj = new TextContainer();
            Method method = TextContainer.class.getDeclaredMethod("save", String.class, String.class);
            if (cls.isAnnotationPresent(SaveTo.class) && method.isAnnotationPresent(Saver.class)) {
                System.out.println("Class is annotated & method is annotated.");
                SaveTo an = cls.getAnnotation(SaveTo.class);
                Field field = cls.getDeclaredField("text");
                method.invoke(obj, an.path(), (String) field.get(obj));
            }
        }   catch (NoSuchMethodException | InvocationTargetException  | NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}