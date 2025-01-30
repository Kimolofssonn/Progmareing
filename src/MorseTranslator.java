import java.util.HashMap;
import java.util.Map;

// Två statiska hashmaps för att lagra översättningen mellan bokstäver och Morse-kod
public class MorseTranslator {
    private static final Map<String, String> morseMap = new HashMap<>();
    private static final Map<String, String> textMap = new HashMap<>();

    static {
        // En array med bokstav-Morse-kod-par
        String[][] morsePairs = {{"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                {"Z", "--.."}
        };
        // Fyller hashmaps med par
        for (String[] pair : morsePairs) {
            morseMap.put(pair[0], pair[1]); // Bokstav → Morse
            textMap.put(pair[1], pair[0]); // Morse → Bokstav
        }
    }


    public String translateToMorse(String text) {
        if (text.isBlank()) {
            return "Fel: Tom inmatning!";
        }

        StringBuilder morseResult = new StringBuilder();
        // Loopar igenom varje tecken i texten
        for (char c : text.toUpperCase().toCharArray()) {
            // Hämtar motsvarande Morse-kod från hashmappen, annars returneras en tom sträng
            String morseCode = morseMap.getOrDefault(String.valueOf(c), "");
            // Om tecknet finns i Morse-tabellen, lägg till det i resultatet
            if (!morseCode.isEmpty()) {
                morseResult.append(morseCode).append(" ");
            }
        }

        return morseResult.toString().trim();// Trimma bort sista mellanslaget
    }


    public String translateToText(String morseCode) {
        if (morseCode.isBlank()) {
            return "Fel: Tom inmatning!";
        }
        StringBuilder textResult = new StringBuilder();

        // Delar upp Morse-koden i separata tecken baserat på mellanslag
        String[] morseChars = morseCode.split(" ");
        for (String morseChar : morseChars) {
            if (!textMap.containsKey(morseChar)) {
                throw new IllegalArgumentException("Fel: Ogiltig morsekod '" + morseChar + "' hittades!");
            }
            textResult.append(textMap.get(morseChar));
        }
        return textResult.toString();
    }

    public void morseAlphabet() {
        // Loopar igenom hashmappen och skriver ut varje bokstav med motsvarande Morse-kod
        morseMap.forEach((letter, morse) -> System.out.println(letter + ": " + morse));
    }
}


