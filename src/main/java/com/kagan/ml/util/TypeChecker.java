package com.kagan.ml.util;

public final class TypeChecker {

    private TypeChecker() { }

    public static String correctTypeInput(String type) {
        return type.toUpperCase().strip();
    } 

    public static boolean isTypeCorrect(String type) {
        String[] typeParts = type.split("_");

        if (typeParts.length != 3) {
           return false; 
        }

        return true;
    }
    
} 