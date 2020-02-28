package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exemplu1 {

    public static void main(String[] args) throws Exception {
        Class<Punct> punctClass = (Class<Punct>) Class.forName("main.Punct");

        Constructor<Punct> constructor = punctClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Punct punct = constructor.newInstance();

        Field xField = punctClass.getDeclaredField("x");
        xField.setAccessible(true);
        Valoare vx = xField.getDeclaredAnnotation(Valoare.class);
        xField.setInt(punct, vx.value());

        Field yField = punctClass.getDeclaredField("y");
        yField.setAccessible(true);
        Valoare vy = yField.getDeclaredAnnotation(Valoare.class);
        yField.setInt(punct, vy.value());

        Method afisMethod = punctClass.getDeclaredMethod("afis");
        afisMethod.setAccessible(true);
        afisMethod.invoke(punct);
    }
}
