package com.kagan.ml.util;

public final class TypeChecker {
    private static final int INPUT_LENGTH = 3;
    private static final String TYPE_SPLITER = "_";

    private TypeChecker() { }

    public static String correctTypeInput(String type) {
        return type.toUpperCase().strip();
    } 

    public static boolean isTypeCorrect(String type) {
        String[] typeParts = type.split(TYPE_SPLITER);

        if (typeParts.length != INPUT_LENGTH) {
           return false; 
        }

        return true;
    }
    
} 