import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MorseTranslator translator = new MorseTranslator();
        Scanner scanner = new Scanner(System.in);
        boolean meny = true;

        while (meny){
            try {
                System.out.println("""
                        ____MENY____
                        1. För att översätta från engelska till morsekod tryck 1
                        2. För att översätta från morsekod till engelska tryck 2
                        3. För att visa alfabetet översatt till morsekod tryck 3
                        4. För att avsluta programmet tryck 4""");

                int val = scanner.nextInt();
                scanner.nextLine();

                switch (val) {
                    case 1 -> {
                        System.out.println("Skriv in text att översätta till morsekod");

                        String textToMorse = scanner.nextLine();
                        System.out.println("Morsekod: " + translator.translateToMorse(textToMorse));
                    }
                    case 2 -> {
                        System.out.println("Skriv in morsekod att översätta till text: ");
                        String morseToText = scanner.nextLine();
                        System.out.println("Text: " + translator.translateToText(morseToText));
                    }
                    case 3 -> translator.morseAlphabet();
                    case 4 ->{
                        System.out.println("Avslutar programmet......");
                    meny = false;
                    }
                    default-> System.out.println("Ogiltigt val försök igen. ");
                }
                System.out.println();
            }catch (InputMismatchException e){
                System.out.println("Felaktig inmatning! Använd endast siffror mellan 1 till 4.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ett oväntat fel har uppstått försök igen!");
            }
        }
        scanner.close();
    }
}
