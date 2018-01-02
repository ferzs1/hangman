import java.lang.reflect.Array;
import java.util.*;
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

        ArrayList<Character> badGuess = new ArrayList<>();
        ArrayList<Character> goodGuess = new ArrayList<>();

//      System.out.println("\n" + words.get(wordNo));
        String wordToGuess = words.get(wordNo);
        boolean win = false;

//        int toBeGuessed = wordToGuess.length();
        List<Character> list = new ArrayList<Character>();
        Set<Character> unique = new HashSet<Character>();
        for(char c : wordToGuess.toCharArray()) {
                list.add(c);
                unique.add(c);
        }
        int toBeGuessed = unique.size();
        System.out.println(toBeGuessed);


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
                char G = Guess.charAt(0);
                goodGuess.add(G);
                toBeGuessed--;
            } else {
                elet--;
                System.out.printf("%d életed maradt.", elet);
                char G = Guess.charAt(0);
                badGuess.add(G);
            }
            if (toBeGuessed == 0) {
                win = true;
            }
        }
        if (win) {    
            System.out.println("\nNyert. A szó: " + wordToGuess);
        } else {
            System.out.println("\nNem nyert.");
        }
    }

}
