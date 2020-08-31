package com.fama.numtoenglish.translator.utilities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TranslatorUtilitiesTests {

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
