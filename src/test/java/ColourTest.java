import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    private final static Colour colourFloat = new Colour(0.9f,0.6f,0.5f);
    private final static Colour colourInt = new Colour(6915853);

    @Test
    void testIfConstructorValuesAreValidForRGBTypeFloatRed(){
        assertEquals(230, colourFloat.getRed());
    }

    @Test
    void testIfConstructorValuesAreValidForRGBTypeFloatGreen(){
        assertEquals(153, colourFloat.getGreen());
    }

    @Test
    void testIfConstructorValuesAreValidForRGBTypeFloatBlue(){
        assertEquals(128, colourFloat.getBlue());
    }

    @Test
    void exceptionTestingForTheConstructorThatTakesInRGBTypeFloat() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(20,40,20),
                "Float values are not valid!"
        );
    }

    @Test
    void testIfConstructorValuesAreValidForRGBTypeIntRed(){
        assertEquals(105, colourInt.getRed());
    }

    @Test
    void testIfConstructorValuesAreValidForRGBTypeIntGreen(){
        assertEquals(135, colourInt.getGreen());
    }

    @Test
    void testIfConstructorValuesAreValidForRGBTypeIntBlue(){
        assertEquals(13, colourInt.getBlue());
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
        assertFalse(Colour.compareColours(colourFloat, colourInt));
    }

    @Test
    void compareColoursBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultIsTrue() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(1.0f,1.0f,1.0f);
        assertTrue(Colour.compareColours(c1, c2));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeIntComparisonResultIsTrue() {
        var colour = new Colour(6915853);
        assertTrue(Colour.compareColours(colourInt, colour));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeIntComparisonResultIsFalse() {
        var colour = new Colour(16715);
        assertFalse(Colour.compareColours(colourInt, colour));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeFloatComparisonResultIsTrue() {
        var colour = new Colour(0.9f,0.6f,0.5f);
        assertTrue(Colour.compareColours(colourFloat, colour));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeFloatComparisonResultIsFalse() {
        var colour = new Colour(0.0f,0.1f,0.5f);
        assertFalse(Colour.compareColours(colourFloat, colour));
    }
}