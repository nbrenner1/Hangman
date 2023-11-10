import java.io.*;
import java.util.Scanner;

public class main
{
    public static void main(String [] args)
    {
        if(authenticateUser())      // Call the method to verify the user's credentials
        {
            hangman hangman1 = new hangman("computer");   // If credentials are correct, create an instance
        }                                                 // of hangman with the unknown word "zugzwang"
    }

    private static boolean authenticateUser()
    {
        try
        {
            File secretFile = new File("secret");          // Check to ensure file "secret" exists
            Scanner fileScanner = new Scanner(secretFile);
            String line = fileScanner.nextLine().trim();   // Scan first line of file
            String[] credentials = line.split(":");        // Split line at ":" character
            String username = credentials[1].trim();       // Save the username as the string after the ":"
            String line2 = fileScanner.nextLine().trim();  // Scan next line of file
            String[] credentials2 = line2.split(":");
            String password = credentials2[1].trim();      // Same as username: Split at ":" and save password as string after ":"

            Scanner inputScanner = new Scanner(System.in); // Read in user's inputted username and password
            System.out.print("Enter Username: ");
            String inputUsername = inputScanner.nextLine();
            System.out.print("Enter Password: ");
            String inputPassword = inputScanner.nextLine();

            if (!inputUsername.equals(username) || !inputPassword.equals(password))   // Check if inputted username and password match
            {                                                                         // the username and password read from the file
                System.out.println("Username or password are incorrect");
                return false;
            }
            else
            {
                System.out.println("Welcome to Hangman!");
                return true;
            }
        }
        catch (FileNotFoundException e)                               // If the file "secret" does not exist, throw an
        {                                                             // error and return false to stop the start of the game
            System.out.println("File \"secret\" is not found");
            return false;
        }
    }
}
