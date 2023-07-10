package TicTacToePack;

import java.util.Objects;

class Container{
    public static void Invalid(){
        print(red, "", "INPUT INVALID");
    }
    static int playerNumber = 1;
    static String reset = "\u001B[0m";
    static String black = "\u001B[30m";
    static String red = "\u001B[31m";
    static String blue = "\u001B[34m";

    static String yellow_bg = "\u001B[43m";

    public static void print(String txtColor, String bgColor, String content){
        System.out.printf("\n%s%s%s%s\n", txtColor, bgColor, content, reset);
    }
    static void printTicTac(String[][] matrix){
        System.out.print("\n");
        int row = matrix[0].length;

        for (String[] strings : matrix) {
            for (int j = 0; j < row; j++) {
                System.out.print("[  ");
                System.out.print(strings[j]);
                System.out.print("  ]");
            }
            System.out.print("\n\n");
        }
        System.out.print("\n");
    }
    static void pinSymbol(String playerInput, String[][] table, String[][] table1){
        int mainIndex = Integer.parseInt(playerInput.substring(0, 1)) - 1;
        int i_Index = mainIndex / 3;
        int j_index = 0;

        String playerSymbol = playerInput.substring(1, 2).toUpperCase();

        if(i_Index == 0){
            j_index = mainIndex;
        }
        else if(i_Index == 1){
            j_index = mainIndex - 3;
        }
        else if(i_Index == 2){
            j_index = mainIndex - 6;
        }

        if (Objects.equals(table1[i_Index][j_index], "n")){
            if (playerSymbol.equals("X")){
                if (playerNumber == 1){
                    table[i_Index][j_index] = red + "X" + reset;
                    table1[i_Index][j_index] = "x";

                    playerNumber = 2;
                }
                else{
                    print(red, "", "IT'S NOT YOUR TURN");
                }

            }
            else if (playerSymbol.equals("O")){
                if (playerNumber == 2){
                    table[i_Index][j_index] = blue + "O" + reset;
                    table1[i_Index][j_index] = "o";

                    playerNumber = 1;
                }
                else{
                    print(red, "", "IT'S NOT YOUR TURN");
                }
            }
        }
        else {
            System.out.printf("\n%sCAN'T PIN '%s' THERE%s\n", red, playerSymbol, reset);
        }
    }
    static boolean checkWin(String[][] matrix){
        boolean isWin = false;
        StringBuilder cmbCol, cmbRow, cmbD1, cmbD2;

        cmbD1 = new StringBuilder();
        cmbD2 = new StringBuilder();

        for (int i = 0; i < 3; i++){
            cmbCol = new StringBuilder();
            cmbRow = new StringBuilder();

            for (int j = 0; j < 3; j++) {
                cmbRow.append(matrix[i][j]);
                cmbCol.append(matrix[j][i]);

                if (cmbCol.toString().equals("xxx") || cmbRow.toString().equals("xxx")){
                    print(red, "", "Player 1 WIN");
                    isWin = true;
                } else if (cmbCol.toString().equals("ooo") || cmbRow.toString().equals("ooo")) {
                    print(blue, "", "Player 2 WIN");
                    isWin = true;
                }
            }

            cmbD1.append(matrix[i][i]);
            cmbD2.append(matrix[i][2 - i]);

            if (cmbD1.toString().equals("xxx") || cmbD2.toString().equals("xxx")){
                print(red, "", "Player 1 WIN");
                isWin = true;
            }
            else if (cmbD1.toString().equals("ooo") || cmbD2.toString().equals("ooo")){
                print(blue, "", "Player 2 WIN");
                isWin = true;
            }

        }
        return isWin;
    }
}
