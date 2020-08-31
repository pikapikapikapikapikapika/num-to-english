package com.fama.numtoenglish.translator.utilities;

import java.util.ArrayList;
import java.util.List;

public final class TranslatorUtilities {
    private TranslatorUtilities() {
        // do not allow instantiating utility class
    }

    protected static String threeDigitNumberToName(String number) {
        String threeDigitNumber = number;
        if (number.length() == 1) {
            threeDigitNumber = "00" + number;
        } else if (number.length() == 2) {
            threeDigitNumber = "0" + number;
        }

        List<String> nameParts = new ArrayList<>();

        // hundreds place is represented by "x hundred"
        String hundredsDigit = threeDigitNumber.substring(0, 1);
        if (!"0".equals(hundredsDigit)) {
            nameParts.add(digitToName(hundredsDigit));
            nameParts.add("hundred");
        }

        // tens place is has a -ty name unless tens place is 1, in which case it has a special name
        String tensDigit = threeDigitNumber.substring(1, 2);
        String teenDigits = threeDigitNumber.substring(1, 3);
        boolean skipOnesDigit = false;
        if (!tensDigit.equals("0")) {
            if ("1".equals(tensDigit)) {
                nameParts.add(teensNumberToName(teenDigits));
                skipOnesDigit = true;
            } else {
                nameParts.add(tensDigitToName(tensDigit));
            }
        }

        // ones place is present in the name if the tens place is not 1
        String onesDigit = threeDigitNumber.substring(2, 3);
        if (!skipOnesDigit && !"0".equals(onesDigit)) {
            nameParts.add(digitToName(onesDigit));
        }

        return String.join(" ", nameParts);
    }

    private static String teensNumberToName(String teen) {
        switch (teen) {
            case "10":
                return "ten";
            case "11":
                return "eleven";
            case "12":
                return "twelve";
            case "13":
                return "thirteen";
            case "14":
                return "fourteen";
            case "15":
                return "fifteen";
            case "16":
                return "sixteen";
            case "17":
                return "seventeen";
            case "18":
                return "eighteen";
            case "19":
                return "nineteen";
        }
        return null;
    }

    private static String tensDigitToName(String digit) {
        switch (digit) {
            case "1":
                return "ten";
            case "2":
                return "twenty";
            case "3":
                return "thirty";
            case "4":
                return "forty";
            case "5":
                return "fifty";
            case "6":
                return "sixty";
            case "7":
                return "seventy";
            case "8":
                return "eighty";
            case "9":
                return "ninety";
        }
        return null;
    }

    private static String digitToName(String digit) {
        switch (digit) {
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
        }
        return null;
    }
}
