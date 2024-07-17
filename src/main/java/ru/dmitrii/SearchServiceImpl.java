package ru.dmitrii;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация метода интерфейса {@link SearchService}
 */
public class SearchServiceImpl implements SearchService{

    /**
     * Метод находит все аннотированные классы переданной аннотацией в переданном пакете
     * С помощью ClassLoader загружаем контекст класса текущего потока
     * В URL записываем локальный адрес расположения содержимого/ресурсов
     * File читаем файлы по указанному пути.
     * Перебираем, ищем совпадения, парсим имя, проверяем содержит ли класс нужную аннотацию, добавляем его в список
     * @param packageName пакет для поиска классов
     * @param annotation аннотация по которой выполняется поиск
     * @throws ClassNotFoundException если класс не найден
     * @return возвращаем список аннотированных классов
     */
    public List<Class<?>> annotatedClasses(String packageName, Class< ? extends Annotation> annotation) throws ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();
        //String packageName = "ru.dmitrii";
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(path);
        //URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(path); //укороченный вариант.
        File files = new File(resource.getFile());
        for(File file : files.listFiles()){
            if (file.getName().endsWith(".class")){
                //System.out.println(file.getName());
                String className = packageName + '.' + file.getName().substring(0, file.getName().lastIndexOf("."));
                //System.out.println(className);
                Class someClass = Class.forName(className);

                if (someClass.isAnnotationPresent(annotation)){
                    classList.add(someClass);
                }
            }
        }
//        for (Class<?> c : classList){
//            System.out.println(c.getName());
//        }
        return classList;
    }

//    public static void main(String[] args) throws ClassNotFoundException {
//        SearchService searchService = new SearchService();
//        searchService.annotatedClasses("ru.dmitrii",IntensiveComponent.class);
//    }
}
