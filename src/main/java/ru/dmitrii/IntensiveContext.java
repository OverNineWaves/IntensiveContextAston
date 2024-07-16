package ru.dmitrii;

import java.util.ArrayList;
import java.util.List;
import ru.dmitrii.SearchService;

public class IntensiveContext {
    SearchService searchService = new SearchService();
    public String packageName;
    public IntensiveContext(String packageName){
        this.packageName = packageName;
    }

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
        return null;
    }
}
