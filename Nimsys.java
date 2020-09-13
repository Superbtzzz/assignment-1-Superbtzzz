import java.util.ArrayList;
import java.util.Scanner;
public class Nimsys {
    private String inputString;
    private static NimPlayer player1, player2;
    private int UPPER_BOUND,initialNum,inputInteger, player1_win_count, player2_win_count, gameCount = 0;
    static int remainingStone;
    private boolean isPlayer1turn = true, isPlayer2turn = false, exit = false;

    public Nimsys() {
    }

    public void create1stPlayer() {
        System.out.println();
        System.out.print("Please enter player1's name ");
        userInputString();
        player1 = new NimPlayer(inputString);
    }

    public void create2ndPlayer() {
        System.out.print("Please enter player2's name ");
        userInputString();
        player2 = new NimPlayer(inputString);
    }

    public void setUpNim(){
        isPlayer1turn = true;
        isPlayer2turn= false;
        System.out.print("Enter upper bound : ");
        userInputIntger();
        this.UPPER_BOUND = inputInteger;
        System.out.print("Enter initial number of stones : ");
        userInputIntger();
        this.initialNum = inputInteger;
        remainingStone = initialNum;
        System.out.println();
    }

    public static void welcome(){
        System.out.println("Welcome to NIM");
        System.out.println();
        System.out.println("Please enter a commands to continue");
        System.out.println();
        System.out.print("$ ");
    }

    public String userInputString(){
        inputString ="";
        Scanner keyboard = new Scanner(System.in);
        if (keyboard.hasNextLine()) { inputString = keyboard.nextLine(); }
        return inputString;
    }

    private void userInputIntger(){
        Scanner keyboard = new Scanner(System.in);
        inputInteger = keyboard.nextInt();
    }

    public int getInputInteger() {return inputInteger;}

    public void help(){
        System.out.print("$");
        System.out.println(" help ");
        System.out.println("Type commands to list all available commands");
        System.out.println("Type start to play game");
        System.out.println("Player to remove the last stone loses!");
        System.out.println();
        System.out.print("$ ");
        userInputString();
        if(inputString.equalsIgnoreCase("commands")){
            commands();
        }
    }

    public void commands(){
        printCmd();
        System.out.println();
        System.out.print("$ ");
        userInputString();
        System.out.print("");
        if (inputString.equalsIgnoreCase("start")){
            System.out.println();
            create1stPlayer();
            create2ndPlayer();
            setUpNim();
            printStones();
            removeStone();
        }
        else if (inputString.equalsIgnoreCase("help")){
            help();
        }
        else if(inputString.equalsIgnoreCase("commands")){
            commands();
        }
        else {
            exit();
        }
    }

    private void printCmd(){
        ArrayList<String> cmdList = new ArrayList<String>(4);
        cmdList.add(0,": start");
        cmdList.add(1,": exit");
        cmdList.add(2,": help");
        cmdList.add(3,": commands ");
        System.out.println();
        for(String entry:cmdList)
            System.out.println(entry);
    }

    public void printStones(){
        System.out.println();
        System.out.print(remainingStone + " stones left : ");
        for (int i = 0; i < remainingStone; i++)
            System.out.print("*");
    }

    public void printThx(){
        System.out.println("Thank you for playing NIM");
    }

    public boolean exit(){
        return exit = true;
    }

    public void removeStone(){
        if(isPlayer1turn == true) {
            System.out.println();
            System.out.print(player1 + "'s turn" +" Enter stones to remove : ");
            userInputIntger();
            int move = getInputInteger();
            if ((move <= UPPER_BOUND) && ((remainingStone - move) > 0)) {
                remainingStone = remainingStone - move;
                printStones();
                isPlayer1turn = false; isPlayer2turn = true;
                System.out.println();
                removeStone();
            }
            else if ((move <= UPPER_BOUND) && ((remainingStone - move == 0))) {
                System.out.println("Game Over");
                System.out.println(player2  + " wins!");
                player2_win_count ++;
                gameCount ++ ;
                anotherRound();
            }
            else {
                System.out.println("Upper bound limit exceed, upper bound maximum choice is 3");
                removeStone();
                isPlayer1turn = true; isPlayer2turn = false;
            }
        }
        else if(isPlayer2turn) {

            System.out.print(player2 +"'s turn" + " Enter stones to remove : ");
            userInputIntger();
            int move = getInputInteger();
            if ((move <= UPPER_BOUND) && ((remainingStone - move) > 0)) {
                remainingStone = remainingStone - move;
                printStones();
                isPlayer2turn = false; isPlayer1turn = true;
                System.out.println();
                removeStone();
            }
            else if ((move <= UPPER_BOUND) && ((remainingStone - move == 0))) {
                System.out.println("Game Over");
                System.out.println(player1  + " wins!");
                player1_win_count ++;
                gameCount ++;
                anotherRound();

            }
            else {
                System.out.println("Upper bound limit exceed, upper bound maximum choice is 3");
                removeStone();
                isPlayer1turn = false; isPlayer2turn = true;
            }
        }

    }

    private void anotherRound(){
        System.out.println();
        System.out.print("Do your want to play again (Y/N) : ");
        if(userInputString().equalsIgnoreCase("Y")){
            setUpNim();
            printStones();
            removeStone();
        }

        else {
            System.out.println(player1 + " won " + player1_win_count + " out of " + gameCount + " played ");
            System.out.println(player2 + " won " + player2_win_count + " out of " + gameCount + " played");
            System.out.println("$");
            System.out.println("$ exit");
                exit();
/*            help();
            commands();
            System.out.println();*/
        }
    }

    public static void main(String[] args){
        Nimsys.welcome();
        Nimsys round1 = new Nimsys();
        String answer = round1.userInputString();
        do {
            if(answer.equalsIgnoreCase("start")){
                round1.create1stPlayer();
                round1.create2ndPlayer();
                round1.setUpNim();
                round1.printStones();
                round1.removeStone();
            }
            else if (answer.equalsIgnoreCase("help")){
                round1.help();
            }
            else if(answer.equalsIgnoreCase("commands")){
                round1.commands();
            }
            else round1.exit();
        }while(round1.exit !=true);
        System.out.println();
        round1.printThx();
    }
}


