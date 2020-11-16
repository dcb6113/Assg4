
import java.util.Random;
import java.util.Scanner;
/**
 * This class creates the game and choices how the computer will play.
 * On random the computer will play smart or dummb, and the compter will
 * choice at random if the user or system will go first. Whoever leaves the pile
 * with one marble wins.
 *
 * @author Dylan Bragiel
 * @version 4/11/2019
 */
public class GameOfNim
{
    Scanner input=new Scanner(System.in);
    Random rand=new Random();
    boolean compFirst=rand.nextBoolean();
    boolean smartComp=rand.nextBoolean();
    private int pile;
    private int start;
    private int computer;
    private int take;
    private int diff;
    /**@param min sets minimum value of random pile
     * @param max sets max value of randomp pile
     * 
     */
    public GameOfNim (int min, int max){
        pile=rand.nextInt(max-min + 1)+min;
    }

    /**This method creates the smart 
     * movement for the computer.
     * 
     */
    public void smartComputer(){ 
        if(pile == 3 || pile == 7 ||
        pile == 15 || pile == 31 ||
        pile ==63){
            take= rand.nextInt((pile/2)+1);
            pile = (pile-take);
        } 
        else{ 
            if (pile>63){
                take=pile;
                pile = 63;
                diff=(take-pile);
            }
            else if(pile>31){
                take=pile;
                pile = 31;
                diff=(take-pile);
            }
            else if(pile>15){
                take=pile;
                pile = 15;
                diff=(take-pile);
            }
            else if(pile>7){
                take=pile;
                pile = 7;
                diff=(take-pile);
            }
            else if(pile>3){
                take=pile;
                pile = 3;
                diff=(take-pile);
            }
            System.out.println("Computers turn:     Removed " + diff + " marble(s)." + " Current number of marbles: " + pile);
        }
        if(pile==1){ 
            System.out.println("COMPUTER WINS!");
        }
    }

    /**
     * This method creates the movement for the dumb
     * computer.
     */
    public void dumbComputer() {  
        if(pile != 1){int dumbMove = rand.nextInt(pile/2)+1;
            pile -= dumbMove;
            System.out.println("Computers turn:     Removed " + (int)dumbMove + " marble(s)." + " Current number of marbles: " + pile);
        }
        if(pile==1){ 
            System.out.println("COMPUTER WINS!");
        }
    }

    /**
     * This method takes the user move and check's if it follows
     * the rules of the game.
     */
    public void userMove() { 
        if(pile != 1){
            System.out.println("User please enter the amount of marbles to be removed");
            int userTake = input.nextInt();
            if(userTake<=(pile/2)){
                pile -= userTake;
                System.out.println("Human's turn:     Removed " + userTake +  " marble(s)." + " Current number of marbles: " + pile);
            } else { 
                System.out.println("please enter a valid amount to remove (no more than half and no less than 1)");
                System.out.println("User please enter the amount of marbles to be removed");
                userTake = input.nextInt();
                pile-=userTake;
                System.out.println("Human's turn:     Removed " + userTake +  " marble(s)." + " Current number of marbles: " + pile);
            }
            if(pile==1){ 
                System.out.println("HUMAN WINS!");
            }
        }
    }

    /**
     * This method calls all the other methods, and runs the game.
     */
    public void play() {
        System.out.println("Game Begins");
        System.out.println("Initially there are "+ pile +" marbles in the pile");    
        do{ 
            if(smartComp) { 
                if(compFirst){ 
                    smartComputer();
                    userMove();
                } else { 
                    userMove();
                    smartComputer();
                }
            } else { 
                if(compFirst){ 
                    dumbComputer();
                    userMove();
                } else { 
                    userMove();
                    dumbComputer();
                }
            }
        } while(pile > 1);
}
}
