import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean play = true;
    // Allows the program to know when to stop or to keep going //
    while (play) {
      int chooseword = (int) (Math.random() * 5);
      String word = "";
      // Gets the word //
      switch (chooseword) {
        case 0:
          word = "gravy";
          break;
        case 1:
          word = "turkey";
          break;
        case 2:
          word = "brownie";
          break;
        case 3:
          word = "bread";
          break;
        case 4: 
          word = "steak";
          break;
      }
      // Gives the user a random letter to help figure out the word //
      String gamestring = "";
      int random1 = (int) (Math.random() * 5);
      String randomletter1 = word.substring(random1, random1+1);
      for (int i = 0; i < word.length(); i++) {
        if (word.substring (i, i+1).equals(randomletter1)) {
          gamestring += randomletter1;
        }
        else {
          gamestring += "*";
        }
      }
      int tries = 3;
      System.out.println (gamestring);
      System.out.println ("You currently have " +tries+ " tries.");
      while (tries > 0) {
        String newstring = playGame(gamestring, word);
        if (newstring.equals(gamestring)) {
          tries--;
          if (tries == 0) {
            System.out.println ("Sorry. You are out of tries");
          }
          System.out.println("Sorry, your guess was not correct.");
          System.out.println(gamestring);
          System.out.println("You still have " + tries + " tries.");
        }
else {
          gamestring = newstring;
          if (gamestring.equals(word)) {
            System.out.println("Congratulations! Your guess was correct.");
            System.out.println("You have guessed the word!");
            System.out.println("The word was: " + word);
            break;
          }
          System.out.println("Good job! Your guess was correct!");
          System.out.println(gamestring);
          System.out.println("You still have " + tries + " tries.");
        }
      }
      System.out.println("Would you like to play again? Enter true for yes and false for no.");
      play = sc.nextBoolean();
    }
  }
// The actual game line //
  public static String playGame(String gameline, String word) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input a letter.");
    String input = sc.nextLine();
    char newChar = input.charAt(0);
    String newstring = gameline;
    for (int i = 0; i<word.length(); i++) {
      if (word.charAt(i) == newChar) {
        newstring = gameline.substring(0, i) + word.substring(i, i+1) + gameline.substring(i+1);
        break;
      }
    }
    return newstring;
  }
}