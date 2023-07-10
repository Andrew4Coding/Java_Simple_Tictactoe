package TicTacToePack;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Program Start
        Container.print(Container.black, Container.yellow_bg, "     PLAY TIC TAC TOE     ");

        label:
        while (true) {
            System.out.println("\n->\tMAIN MENU");
            System.out.print("1.\tPlay TicTacToe\n");
            System.out.print("2.\tHow to Play?\n");
            System.out.print("3.\tExit?\n");
            System.out.print("\n  \tInput (1 - 3)\t: ");

            String option = scanner.next();
            switch (option){
                case "1":
                    String[][] tictacTable = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
                    String[][] tictacFill2 = {{"n", "n", "n"}, {"n", "n", "n"}, {"n", "n", "n"}};

                    boolean continuePlay = true;

                    while (continuePlay) {
                        continuePlay = !Container.checkWin(tictacFill2);
                        Container.printTicTac(tictacTable);
                        if (continuePlay) {
                            System.out.print("Input\t: ");
                            String playerInput = scanner.next();

                            Container.pinSymbol(playerInput, tictacTable, tictacFill2);
                        }
                    }

                    while (true){
                        System.out.println("Play again? (y/n): ");
                        String response = scanner.next();
                        switch (response){
                            case "y":
                                continue label;
                            case "n":
                                Container.print(Container.black, Container.yellow_bg, "     THANKS FOR PLAYING     ");
                                break label;
                            default:
                                Container.Invalid();
                        }
                    }

                case "2":
                    Container.print(Container.black, Container.yellow_bg, "     HOW TO PLAY     ");
                    System.out.println("""
                            - \tFill Input with NUMBER and SYMBOL.
                             \tFor example: 1x, 2o, 3x, etc.""");
                    System.out.println("- \tEach player gets their turn.");
                    System.out.println("- \tEnjoy!\n");
                    break;

                case "3":
                    Container.print(Container.black, Container.yellow_bg, "     THANKS FOR PLAYING     ");
                    break label;
                default:
                    Container.Invalid();
            }
        }
    }
}