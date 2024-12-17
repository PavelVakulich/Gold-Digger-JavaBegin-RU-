package ru.javabegin.training.goldman.validators;

import java.util.Arrays;

public class NameValidator implements StringValidator{

    private final static String[] notAllowNames = {"KING", "LADY", "LORD", "QUEEN", "SIR"};

    private final static char[] romanNumerals = {'C', 'D', 'I', 'L', 'M', 'V', 'X'};

    @Override
    public boolean isValid(String text) {
        
        if (text==null || text.trim().length()==0){
            return false;
        }
        
        boolean isValidName = false;
        if (Arrays.binarySearch(notAllowNames, text.toUpperCase()) < 0) {
            if (Arrays.binarySearch(romanNumerals, text.charAt(text.length() - 1)) < 0) {
                isValidName = true;
            }
        }
        return isValidName;
    }
}
