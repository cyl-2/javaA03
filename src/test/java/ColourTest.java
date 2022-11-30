import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Colour Class
 *
 * The naming convention I used for naming test methods: Should_ExpectedBehavior_When_StateUnderTest
 */
class ColourTest {

    private final static Colour colourFloat = new Colour(0.9f,0.6f,0.5f);
    private final static Colour colourInt = new Colour(6915853);

    @Test
    void Should_ReturnValidValuesForColourComponents_When_FloatParametersForConstructorAreValid(){
        assertEquals(230, colourFloat.getRed());
        assertEquals(153, colourFloat.getGreen());
        assertEquals(128, colourFloat.getBlue());
    }

    @Test
    void Should_ThrowException_When_FloatParametersForConstructorAreInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(20,40,20),
                "Float values are not valid!"
        );
    }

    @Test
    void Should_ReturnValidValuesForColourComponents_When_IntParameterForConstructorIsValid(){
        assertEquals(105, colourInt.getRed());
        assertEquals(135, colourInt.getGreen());
        assertEquals(13, colourInt.getBlue());
    }

    @Test
    void Should_ThrowException_When_IntParameterForConstructorIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> new Colour(999999999),
                "Integer value is not valid!"
        );
    }

    @Test
    void Should_ReturnFalse_When_AColourObjectInitializedWithIntParameterAndAColourObjectInitializedWithFloatParametersAreNotEqual() {
        assertFalse(Colour.equalColours(colourFloat, colourInt));
    }

    @Test
    void Should_ReturnTrue_When_AColourObjectInitializedWithIntParameterAndAColourObjectInitializedWithFloatParametersAreEqual() {
        var c1 = new Colour(16777215);
        var c2 = new Colour(1.0f,1.0f,1.0f);
        assertTrue(Colour.equalColours(c1, c2));
    }

    @Test
    void Should_ReturnTrue_When_TwoColourObjectsInitializedWithIntParameterAreEqual() {
        var colour = new Colour(6915853);
        assertTrue(Colour.equalColours(colourInt, colour));
    }

    @Test
    void Should_ReturnFalse_When_TwoColourObjectsInitializedWithIntParameterAreNotEqual() {
        var colour = new Colour(16715);
        assertFalse(Colour.equalColours(colourInt, colour));
    }

    @Test
    void Should_ReturnTrue_When_TwoColourObjectsInitializedWithFloatParametersAreEqual() {
        var colour = new Colour(0.9f,0.6f,0.5f);
        assertTrue(Colour.equalColours(colourFloat, colour));
    }

    @Test
    void Should_ReturnFalse_When_TwoColourObjectsInitializedWithFloatParametersAreNotEqual() {
        var colour = new Colour(0.0f,0.1f,0.5f);
        assertFalse(Colour.equalColours(colourFloat, colour));
    }
}