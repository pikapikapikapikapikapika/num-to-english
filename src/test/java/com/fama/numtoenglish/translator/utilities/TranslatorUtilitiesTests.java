package com.fama.numtoenglish.translator.utilities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TranslatorUtilitiesTests {

    @Test
    public void testTranslateNumberToNameZero() {
        String result = TranslatorUtilities.translateNumberToName("0");
        Assert.assertEquals("translating 0 returns zero", "zero", result);
        result = TranslatorUtilities.translateNumberToName("00");
        Assert.assertEquals("translating 00 returns zero", "zero", result);
    }

    @Test
    public void testTranslateNumberToNamePowersOfThousand() {
        String result = TranslatorUtilities.translateNumberToName("1000");
        Assert.assertEquals("translating 1000 resolves correctly", "one thousand", result);

        result = TranslatorUtilities.translateNumberToName("1000000");
        Assert.assertEquals("translating 1000000 resolves correctly", "one million", result);

        result = TranslatorUtilities.translateNumberToName("1000000000");
        Assert.assertEquals("translating 1000000000 resolves correctly", "one billion", result);

        result = TranslatorUtilities.translateNumberToName("1000000000000");
        Assert.assertEquals("translating 1000000000000 resolves correctly", "one trillion", result);
    }

    @Test
    public void testTranslateNumberToNameWithOnesInAllDigits() {
        String result = TranslatorUtilities.translateNumberToName("111111111111");
        Assert.assertEquals(
                "translating 111111111111 resolves correctly",
                "one hundred eleven billion one hundred eleven million one hundred eleven thousand one hundred eleven",
                result
        );
    }

    @Test
    public void testTranslateNumberToNameDecimalPts() {
        String result = TranslatorUtilities.translateNumberToName(".1");
        Assert.assertEquals("translating .1 resolves correctly", "zero point one", result);

        result = TranslatorUtilities.translateNumberToName(".0");
        Assert.assertEquals("translating .1 resolves correctly", "zero point zero", result);

        result = TranslatorUtilities.translateNumberToName(".12345");
        Assert.assertEquals("translating .12345 resolves correctly", "zero point one two three four five", result);

        result = TranslatorUtilities.translateNumberToName("111.12345");
        Assert.assertEquals("translating 111.12345 resolves correctly", "one hundred eleven point one two three four five", result);
    }

    @Test
    public void testTranslateNumberToNameNegative() {
        String result = TranslatorUtilities.translateNumberToName("-1");
        Assert.assertEquals("translating -1 resolves correctly", "negative one", result);

        result = TranslatorUtilities.translateNumberToName("-.1");
        Assert.assertEquals("translating .1 resolves correctly", "negative zero point one", result);


        result = TranslatorUtilities.translateNumberToName("-1000000");
        Assert.assertEquals("translating -1000000 resolves correctly", "negative one million", result);
    }

    @Test
    public void testThreeDigitNumberToNameZero() {
        // we expect empty string because if the number has a "000" at any step of 1000, we should exclude the "zero"
        // e.g. 1000 = one thousand, not one thousand zero,
        //      1000000 = one million, not one million zero thousand zero
        String result = TranslatorUtilities.threeDigitNumberToName("0");
        Assert.assertEquals("converting three digit number '0' gives nonempty result", "", result);
    }

    @Test
    public void testThreeDigitNumberToNameHundreds() {
        String result = TranslatorUtilities.threeDigitNumberToName("100");
        Assert.assertEquals("converting three digit number '100' resolves correctly", "one hundred", result);
    }

    @Test
    public void testThreeDigitNumberToNameTens() {
        String result = TranslatorUtilities.threeDigitNumberToName("20");
        Assert.assertEquals("converting three digit number '20' resolves correctly", "twenty", result);
    }

    @Test
    public void testThreeDigitNumberToNameTeens() {
        String result = TranslatorUtilities.threeDigitNumberToName("10");
        Assert.assertEquals("converting three digit number '10' resolves correctly", "ten", result);
    }

    @Test
    public void testThreeDigitNumberToNameOnes() {
        String result = TranslatorUtilities.threeDigitNumberToName("1");
        Assert.assertEquals("converting three digit number '1' resolves correctly", "one", result);
    }

    @Test
    public void testThreeDigitNumberToNameAllPlaces() {
        String result = TranslatorUtilities.threeDigitNumberToName("222");
        Assert.assertEquals("converting three digit number '222' resolves correctly", "two hundred twenty two", result);
    }

    @Test
    public void testThreeDigitNumberToNameAllPlacesWithTeens() {
        String result = TranslatorUtilities.threeDigitNumberToName("111");
        Assert.assertEquals("converting three digit number '111' resolves correctly", "one hundred eleven", result);
    }
}
