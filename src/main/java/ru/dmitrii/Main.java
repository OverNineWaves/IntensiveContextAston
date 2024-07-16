package ru.dmitrii;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        IntensiveContext context = new IntensiveContext("ru.dmitrii");
        SomeClassOne classOne = context.getObject(SomeClassOne.class);
        classOne.run();
    }
}
