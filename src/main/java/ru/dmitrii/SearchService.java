package ru.dmitrii;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Интерфейс для поиска аннотиторанных классов.
 */
public interface SearchService {

    /**
     * Метод находит все аннотированные классы переданной аннотацией в переданном пакете.
     * @param packageName пакет для поиска классов
     * @param annotation аннотация по которой выполняется поиск
     * @throws ClassNotFoundException если класс не найден
     */
    List<Class<?>> annotatedClasses(String packageName, Class< ? extends Annotation> annotation) throws ClassNotFoundException;

}
