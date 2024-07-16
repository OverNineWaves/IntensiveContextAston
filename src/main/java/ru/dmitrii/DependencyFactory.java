package ru.dmitrii;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DependencyFactory {

    public <T> T createObject(Class<T> type){
        try {
            Constructor<T> constructor = type.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
