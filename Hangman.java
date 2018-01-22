import java.lang.reflect.Array;
import java.util.*;

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
            char G = Guess.charAt(0);

            //lekezelni, hogy csak 1 karaktert lehessen megadni!
            while (true){
                if (Guess.length() > 1){ 
                    System.out.println("Legyszi egy betut adj csak meg.");
                    Guess = scan.next();
                    G = Guess.charAt(0);
                }
                else if (goodGuess.contains(G) || badGuess.contains(G)){
                    System.out.println("Mar volt ez a betu! Irj be egy ujat!");
                    Guess = scan.next();
                    G = Guess.charAt(0);
                } else {
                    break;
                }
            }
            if (wordToGuess.contains(Guess)) {
                goodGuess.add(G);
                toBeGuessed--;
            } else {
                elet--;
                System.out.printf("%d életed maradt.", elet);
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
