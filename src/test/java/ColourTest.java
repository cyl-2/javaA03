import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    private final static Colour colourFloat = new Colour(0.9f,0.6f,0.5f);
    private final static Colour colourInt = new Colour(6915853);

    @Test
    void testIfParamTypeFloatConstructorLogicReturnsValidValueForRed(){
        assertEquals(230, colourFloat.getRed());
    }


    @Test
    void testIfParamTypeFloatConstructorLogicReturnsValidValueForGreen(){
        assertEquals(153, colourFloat.getGreen());
    }

    @Test
    void testIfParamTypeFloatConstructorLogicReturnsValidValueForBlue(){
        assertEquals(128, colourFloat.getBlue());
    }

    @Test
    void exceptionTestingForTheConstructorThatTakesInParamTypeFloat() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(20,40,20),
                "Float values are not valid!"
        );
    }

    @Test
    void testIfParamTypeIntConstructorLogicReturnsValidValueForRed(){
        assertEquals(105, colourInt.getRed());
    }

    @Test
    void testIfParamTypeIntConstructorLogicReturnsValidValueForGreen(){
        assertEquals(135, colourInt.getGreen());
    }

    @Test
    void testIfParamTypeIntConstructorLogicReturnsValidValueForBlue(){
        assertEquals(13, colourInt.getBlue());
    }

    @Test
    void exceptionTestingForTheConstructorThatTakesInParamTypeInt() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(999999999),
                "Integer value is not valid!"
        );
    }

    @Test
    void compareColoursBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultShouldBeFalse() {
        assertFalse(Colour.compareColours(colourFloat, colourInt));
    }

    @Test
    void compareColoursBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultShouldBeTrue() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(1.0f,1.0f,1.0f);
        assertTrue(Colour.compareColours(c1, c2));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeIntComparisonResultShouldBeTrue() {
        var colour = new Colour(6915853);
        assertTrue(Colour.compareColours(colourInt, colour));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeIntComparisonResultShouldBeFalse() {
        var colour = new Colour(16715);
        assertFalse(Colour.compareColours(colourInt, colour));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeFloatComparisonResultShouldBeTrue() {
        var colour = new Colour(0.9f,0.6f,0.5f);
        assertTrue(Colour.compareColours(colourFloat, colour));
    }

    @Test
    void compareColoursBetweenTwoColoursOfTypeFloatComparisonResultShouldBeFalse() {
        var colour = new Colour(0.0f,0.1f,0.5f);
        assertFalse(Colour.compareColours(colourFloat, colour));
    }
}