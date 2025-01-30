import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMorse {
    @Test
    public void testTranslateSingleLetter() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToMorse("A");
        Assertions.assertEquals(".-", result, "Bokstaven A borde bli '.-'");
    }

    @Test
    public void testTranslateMoreLetters() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToMorse("ABCD");
        Assertions.assertEquals(".- -... -.-. -..", result, "Texten borde bli: .- -... -.-. -..");
    }

    @Test
    public void testTranslateMixedCases() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToMorse("AbCdE");
        Assertions.assertEquals(".- -... -.-. -.. .", result, "Både små och stor bokstäver ska fungera");
    }

    @Test
    public void testTranslateInvalidCharacters() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToMorse("AbC123A");
        Assertions.assertEquals(".- -... -.-. .-", result, "Både små och stor bokstäver ska fungera och sifror ska hoppas över");
    }

    @Test
    public void testTranslateHelloWorld() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToMorse("HELLO WORLD");
        Assertions.assertEquals(".... . .-.. .-.. --- .-- --- .-. .-.. -..", result, "Resultat ska vara samma som i kraven");
    }

    @Test
    public void testTranslateMorseToText() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToText(".- -... -.-.");
        Assertions.assertEquals("ABC", result, "Morsekoden borde översättas till 'ABC'.");
    }

    @Test
    public void testTranslateMorseToTextWithInvalidCharacters() {
        MorseTranslator translator = new MorseTranslator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> translator.translateToText(".- -... % -.-."));
        // Kontrollera att felmeddelandet är det förväntade
        Assertions.assertEquals("Fel: Ogiltig morsekod '%' hittades!", exception.getMessage());
    }

    @Test
    public void testTranslateMorseToHelloWorld() {
        MorseTranslator translator = new MorseTranslator();
        String result = translator.translateToText(".... . .-.. .-.. --- .-- --- .-. .-.. -..");
        Assertions.assertEquals("HELLOWORLD", result, "Borde ge samma som i kraven.");
    }

}
