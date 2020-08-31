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
                    builder.insert(0, DigitUtilities.powerOfThousandToName(count));
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
                builder.append(DigitUtilities.digitToName("" + number.charAt(i)));
            }
        }
        return builder.toString();
    }

    static String threeDigitNumberToName(String number) {
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
            nameParts.add(DigitUtilities.digitToName(hundredsDigit));
            nameParts.add("hundred");
        }

        // tens place is has a -ty name unless tens place is 1, in which case it has a special name
        String tensDigit = threeDigitNumber.substring(1, 2);
        String teenDigits = threeDigitNumber.substring(1, 3);
        boolean skipOnesDigit = false;
        if (!tensDigit.equals("0")) {
            if ("1".equals(tensDigit)) {
                nameParts.add(DigitUtilities.teensNumberToName(teenDigits));
                skipOnesDigit = true;
            } else {
                nameParts.add(DigitUtilities.tensDigitToName(tensDigit));
            }
        }

        // ones place is present in the name if the tens place is not 1
        String onesDigit = threeDigitNumber.substring(2, 3);
        if (!skipOnesDigit && !"0".equals(onesDigit)) {
            nameParts.add(DigitUtilities.digitToName(onesDigit));
        }

        return String.join(" ", nameParts);
    }

}
