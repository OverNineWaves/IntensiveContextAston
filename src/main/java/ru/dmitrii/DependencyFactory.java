package ru.dmitrii;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Фабрика для создания экземпляра класса
 */
public class DependencyFactory {

    /**
     * метод для создания экземпляра объекта
     * получаем его конструктор с указанным типом параметров
     * создаем новый экземпляр
     * @param type передаем класс какого-то типа
     * @throws RuntimeException выбрасываем исключение
     */
    public <T> T createObject(Class<T> type){
        try {
            Constructor<T> constructor = type.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
