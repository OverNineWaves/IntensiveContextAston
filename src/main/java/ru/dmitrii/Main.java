package ru.dmitrii;

/**
 * Класс демонстрирующий работу программы
 * */
public class Main {

    /**
     * Точка входа в программу
     * */
    public static void main(String[] args) throws ClassNotFoundException {
        IntensiveContext context = new IntensiveContext("ru.dmitrii");
        SomeClassOne classOne = context.getObject(SomeClassOne.class);
        classOne.run();
    }
}
