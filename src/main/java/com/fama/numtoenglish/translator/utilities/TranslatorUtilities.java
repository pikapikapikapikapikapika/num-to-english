package com.fama.numtoenglish.translator.utilities;

import java.util.ArrayList;
import java.util.List;

public final class TranslatorUtilities {
    private TranslatorUtilities() {
        // do not allow instantiating utility class
    }

    public static String translateNumberToName(String number) {
        if (number.charAt(0) == '-') {
            return "negative " + translateNumberToName(number.substring(1));
        }
        if (number.matches("^0+$")) {
            return "zero";
        }
        int decimalPtIndex = number.indexOf('.');
        int nextThreeDigitsIndex = number.length();

        StringBuilder builder = new StringBuilder();
        if (decimalPtIndex != -1 && decimalPtIndex != number.length() - 1) {
            nextThreeDigitsIndex = decimalPtIndex;
        }

        int count = 0;
        while (nextThreeDigitsIndex > 0) {
            String threeDigits = number.substring(Math.max(nextThreeDigitsIndex - 3, 0), nextThreeDigitsIndex);
            String threeDigitsName =  threeDigitNumberToName(threeDigits);
            if (!threeDigitsName.isEmpty()) {
                if (count > 0) {
                    if (builder.length() > 0) {
                        builder.insert(0, " ");
                    }
                    builder.insert(0, powerOfThousandToName(count));
                    builder.insert(0, " ");
                }
                builder.insert(0, threeDigitsName);
            }
            nextThreeDigitsIndex = nextThreeDigitsIndex - 3;
            ++count;
        }

        if (decimalPtIndex != -1 && decimalPtIndex != number.length() - 1) {
            if (builder.length() == 0) {
                builder.append("zero");
            }
            builder.append(" point");
            for (int i = decimalPtIndex + 1; i < number.length(); ++i) {
                builder.append(" ");
                builder.append(digitToName("" + number.charAt(i)));
            }
        }
        return builder.toString();
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

    private static String powerOfThousandToName(int power) {
        // names taken from Powers of 10 Wikipedia page: https://en.wikipedia.org/wiki/Power_of_10
        switch (power) {
            case 1:
                return "thousand";
            case 2:
                return "million";
            case 3:
                return "billion";
            case 4:
                return "trillion";
            case 5:
                return "quadrillion";
            case 6:
                return "quintillion";
            case 7:
                return "sextillion";
            case 8:
                return "septillion";
            case 9:
                return "octillion";
            case 10:
                return "nonillion";
            case 11:
                return "decillion";
            case 12:
                return "undecillion";
            case 13:
                return "duidecillion";
            case 14:
                return "tredecillion";
            case 15:
                return "quattuordecillion";
            case 16:
                return "quindecillion";
            case 17:
                return "sexdecillion";
            case 18:
                return "septdecillion";
            case 19:
                return "octodecillion";
            case 20:
                return "novemdecillion";
            case 21:
                return "vigintillion";
        }
        return "";
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
            case "0":
                return "zero";
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
