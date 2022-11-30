import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    private final static Colour colourFloat = new Colour(0.9f,0.6f,0.5f);
    private final static Colour colourInt = new Colour(6915853);

    @Test
    void exceptionTestingForTheConstructorThatTakesInParamTypeFloat() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(20,40,20),
                "Float values are not valid!"
        );
    }

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
    void compareIfColoursAreEqualBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultShouldBeFalse() {
        assertFalse(Colour.equalColours(colourFloat, colourInt));
    }

    @Test
    void compareIfColoursAreEqualBetweenAColourOfTypeIntAndAColourOfTypeFloatComparisonResultShouldBeTrue() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(1.0f,1.0f,1.0f);
        assertTrue(Colour.equalColours(c1, c2));
    }

    @Test
    void compareIfColoursAreEqualBetweenTwoColoursOfTypeIntComparisonResultShouldBeTrue() {
        var colour = new Colour(6915853);
        assertTrue(Colour.equalColours(colourInt, colour));
    }

    @Test
    void compareIfColoursAreEqualBetweenTwoColoursOfTypeIntComparisonResultShouldBeFalse() {
        var colour = new Colour(16715);
        assertFalse(Colour.equalColours(colourInt, colour));
    }

    @Test
    void compareIfColoursAreEqualBetweenTwoColoursOfTypeFloatComparisonResultShouldBeTrue() {
        var colour = new Colour(0.9f,0.6f,0.5f);
        assertTrue(Colour.equalColours(colourFloat, colour));
    }

    @Test
    void compareIfColoursAreEqualBetweenTwoColoursOfTypeFloatComparisonResultShouldBeFalse() {
        var colour = new Colour(0.0f,0.1f,0.5f);
        assertFalse(Colour.equalColours(colourFloat, colour));
    }
}