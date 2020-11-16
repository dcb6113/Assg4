import java.util.Scanner;
/**
 * Driver module for Game of Nim.
 *
 * @author CS140 Instructors
 * @version 3/28/2019
 */
public class Project5
{
    public static void main(String args[])
    {
        Scanner console = new Scanner(System.in);
        String output;
        do{
        System.out.print("Enter the minimum number of marbles in your pile: ");
        int min = console.nextInt();
        System.out.print("Enter the maximum number of marbles in your pile: ");
        int max= console.nextInt();
        
        GameOfNim game = new GameOfNim(min, max);
        game.play();
        
        System.out.println("Do you want to try again? type 'yes' or 'no'");
        output = console.next();
    } while(output.equalsIgnoreCase("yes"));
    System.out.println("GOODBYE!");
}
}
