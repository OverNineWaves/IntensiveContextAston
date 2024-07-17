package ru.dmitrii;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс для обработки оъектов аннотировнных {@link IntensiveComponent}
 */
public class IntensiveContext {
    private final SearchService searchService;
    private final DependencyFactory dependencyFactory;
    public String packageName;

    /**
     * @param packageName передаем имя пакета для поиска аннотированных классов
     */
    public IntensiveContext(String packageName){
        this.packageName = packageName;
        this.searchService = new SearchServiceImpl();
        this.dependencyFactory = new DependencyFactory();
    }

    /**
     * Метод для получения экземпляра класса
     * @param type указываем тип объекта
     * @throws RuntimeException если больше одной реализации
     * @return экземпляр объектра, которого запрашивали
     */
    public <T> T getObject(Class<T> type) throws ClassNotFoundException {

        List<Class<?>> classList = searchService.annotatedClasses(packageName, IntensiveComponent.class);
        List<Class<?>> list = new ArrayList<>();

        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).isAssignableFrom(type)){
                list.add(classList.get(i));
            }
        }
        if (list.size() != 1){
            throw new RuntimeException("больше одного совпадающего класса");
        }

        Class<?> firstClass = list.get(0);

        Object object = dependencyFactory.createObject(firstClass);

        return (T) object;
    }
}
