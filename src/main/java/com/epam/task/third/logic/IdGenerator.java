package com.epam.task.third.logic;

public class IdGenerator {

    private static int idIterator = 0;

    public int generateId() {
        idIterator++;
        return idIterator;
    }
}
