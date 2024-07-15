package ru.dmitrii;

public class Main {
    IntensiveContext context = new IntensiveContext("пакет");
    SomeClassOne classOne = context.getObject(SomeClassOne.class);
	classOne.run();
}
