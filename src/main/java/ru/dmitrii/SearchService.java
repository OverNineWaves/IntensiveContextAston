package ru.dmitrii;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public List<Class<?>> annotatedClasses(String packageName, Class< ? extends Annotation> annotation) throws ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();
        //String packageName = "ru.dmitrii";
        String path = packageName.replace(".", "/");
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(path);
        File files = new File(scannedUrl.getFile());
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
        for (Class<?> c : classList){
            System.out.println(c.getName());
        }
        return classList;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        SearchService searchService = new SearchService();
        searchService.annotatedClasses("ru.dmitrii",IntensiveComponent.class);
    }
}
