import java.util.Scanner;

public class hangman
{
    private final String word;
    private String currentGuess;
    private int attemptsRemaining;

    public hangman(String word)
    {
        this.word = word;
        this.currentGuess = "_".repeat(word.length());
        this.attemptsRemaining = 8;
        startGame();        // Call method to start the game
    }

    public void startGame()
    {
        boolean wordGuessed=false;
        while((attemptsRemaining > 0) && (wordGuessed==false))   // Continue asking for guesses until
        {                                                        // attempts run out or the word is guessed
            System.out.println();
            System.out.println(currentGuess);
            System.out.println("Attempts remaining: " + attemptsRemaining);
            System.out.print("Guess a letter: ");
            Scanner inputGuess = new Scanner(System.in);
            char guess = inputGuess.next().charAt(0);
            if (guessLetter(guess))               // Call method to check if the guessed letter is in the word
            {
                if (currentGuess.equals(word))    // If the letter is in the word, check if the puzzle has been solved
                {
                    wordGuessed = true;
                }
            }
            else                                  // If the letter is not in the word, decrement attempts remaining
            {
                System.out.println("Incorrect guess!");
                attemptsRemaining--;
            }
        }

        if (wordGuessed)
        {
            System.out.println();
            System.out.println("Congratulations! You've guessed the word: " + word);
        }
        else
        {
            System.out.println();
            System.out.println("You lose -- 8 strikes exceeded!");
        }
    }

    private boolean guessLetter(char letter)
    {
        boolean result = false;

        for (int i=0; i<word.length(); i++)    // Cycle through the word to see if the guessed letter is present
        {
            if (letter == word.charAt(i))      // If the letter is in the word, replace the underscore with that letter and return true
            {
                currentGuess = currentGuess.substring(0, i) + letter + currentGuess.substring(i + 1);
                result = true;
            }
        }

        return result;
    }
}
