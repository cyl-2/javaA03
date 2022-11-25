package org.ucc.a03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    @Test
    void testIfConstructorValuesAreValidForRGBTypeFloatRed(){
        var colour = new Colour(0.9f,0.6f,0.5f);
        assertTrue(colour.getRed() == 230);
        assertTrue(colour.getGreen() == 153);
        assertTrue(colour.getBlue() == 128);
    }

    @Test
    void exceptionTestingForTheConstructorThatTakesInRGBTypeFloat() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(20,40,20),
                "Float values are not valid!"
        );
    }

    @Test
    void testIfConstructorValuesAreValidForRGBTypeInt(){
        var colour = new Colour(6915853);

        assertTrue(colour.getRed() == 105);
        assertTrue(colour.getGreen() == 135);
        assertTrue(colour.getBlue() == 13);
    }

    @Test
    void exceptionTestingForTheConstructorThatTakesInRGBTypeInt() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(999999999),
                "Integer value is not valid!"
        );
    }

    @Test
    void compareColoursBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultIsFalse() {
        var c1 = new Colour(6915853);
        var c2 = new Colour(0.9f,0.6f,0.5f);

        assertFalse(Colour.compareColours(c1, c2));
    }

    @Test
    void compareColoursBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultIsTrue() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(1.0f,1.0f,1.0f);

        assertTrue(Colour.compareColours(c1, c2));
    }


    @Test
    void compareColoursBetweenTwoColoursOfTypeIntComparisonResultIsTrue() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(16777215);

        assertTrue(Colour.compareColours(c1, c2));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeIntComparisonResultIsFalse() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(16715);

        assertFalse(Colour.compareColours(c1, c2));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeFloatComparisonResultIsTrue() {
        var c1 = new Colour(0.9f,0.6f,0.5f);
        var c2 = new Colour(0.9f,0.6f,0.5f);

        assertTrue(Colour.compareColours(c1, c2));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeFloatComparisonResultIsFalse() {
        var c1 = new Colour(0.9f,0.6f,0.5f);
        var c2 = new Colour(0.0f,0.1f,0.5f);

        assertFalse(Colour.compareColours(c1, c2));
    }
}