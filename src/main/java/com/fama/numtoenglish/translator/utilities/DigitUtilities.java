package com.fama.numtoenglish.translator.utilities;

class DigitUtilities {
    private DigitUtilities() {
        // do not allow instantiating utility class
    }

    static String powerOfThousandToName(int power) {
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

    static String teensNumberToName(String teen) {
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

    static String tensDigitToName(String digit) {
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

    static String digitToName(String digit) {
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
