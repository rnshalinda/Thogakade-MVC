package edu.icet.ecom.util;

public class CommonStringFuncUtil {

    // extract numbers only from string
    // [0-9] → 0–9 replace with "", leaving letters intact
    public static String extractLetters(String text){
        return text.replaceAll("[0-9]", "");
    }

    // extract letters only from string
    // [a-zA-Z] → a-zA-Z replace with "", leaving numbers intact
    public static String extractDecimal(String text){
        return text.replaceAll("[a-zA-Z]", "");
    }
}
