package ru.dmitrii;

public class IntensiveContext {
    public String somePackage;
    public IntensiveContext(String somePackage){
        this.somePackage = somePackage;
    }

    public <T> T getObject(Class<T> type) {
        return null;
    }
}
