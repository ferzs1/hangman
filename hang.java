package hangman;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        int elet = 8;
        System.out.printf("Üdv. Ez itt a Hangman. Ebben a játékban %d életed lesz.", elet);

        ArrayList<String> words = new ArrayList<>();
        words.add("fabulous");
        words.add("llama");
        words.add("ghost");
        words.add("beautiful");

        Random rnd = new Random();
        int wordNo = rnd.nextInt(words.size());

        ArrayList<String> badGuess = new ArrayList<>();
        ArrayList<String> goodGuess = new ArrayList<>();

//      System.out.println("\n" + words.get(wordNo));
        String wordToGuess = words.get(wordNo);
        boolean win = false;
        while (!win && elet > 0) {
            System.out.println("");
            for (int i = 0; i < wordToGuess.length(); i++) {
                
                if (goodGuess.contains(wordToGuess.charAt(i))) {
                    System.out.print(wordToGuess.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }

            }
            System.out.println("\n");

            Scanner scan = new Scanner(System.in);
            System.out.println("Tippelj!");
            String Guess = scan.next();

            //lekezelni, hogy csak 1 karaktert lehessen megadni!
            if (wordToGuess.contains(Guess)) {
                goodGuess.add(Guess);
                System.out.println(goodGuess);

            } else {
                elet--;
                System.out.printf("%d életed maradt.", elet);
                badGuess.add(Guess);
            }
        }
        System.out.println("\nNem nyert.");
    }

}
