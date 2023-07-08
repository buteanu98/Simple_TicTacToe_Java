package tictactoe;

import java.util.*;

public class Main {

    public static void display_matrix(String[][] matrix) {
        System.out.println("---------");
        for (int row = 1; row <= 3; row++) {
            System.out.print("| ");
            for (int col = 1; col <= 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("|"); // Move to the next line after each row
        }
        System.out.println("---------");
    }


    public static int[] get_coords() {
        Scanner scanner = new Scanner(System.in);
        int[] coord = new int[2];
        int k = 0;
        while (k < 2) {
            try {
                coord[k] = scanner.nextInt();
            } catch (InputMismatchException e) {
                k = 0;
                System.out.println("You should enter numbers!");
                scanner.nextLine();

            }

            if (coord[k] >= 4) {
                System.out.println("Coordinates should be from 1 to 3!");
                k = 0;

                try {
                    coord[k] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    k = 0;
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();

                }
            } else if (coord[k] < 4)
                k++;
        }
        return coord;
    }

    public static void main(String[] args) {
        // write your code here
        int cntu = 9;
        int player = 0;
        int turns = 0;
        int[] coord;


        // Define a 2-dimensional array for the matrix
        String[][] matrix = new String[4][4];

        //String input = scanner.nextLine();
        // Assign values from the input string to the elements of the matrix
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                matrix[row][col] = " ";

            }
        }
        while (turns < 9) {

            // Display the matrix
            display_matrix(matrix);

            cntu--;
            if (matrix[1][1].equals(matrix[1][2]) && matrix[1][1].equals(matrix[1][3]) && !matrix[1][1].equals(" ")) {
                System.out.println(matrix[1][1] + " wins");
                return;
            }

            if (matrix[2][1].equals(matrix[2][2]) && matrix[2][1].equals(matrix[2][3]) && !matrix[2][1].equals(" ")) {
                System.out.println(matrix[2][1] + " wins");
                return;
            }

            if (matrix[3][1].equals(matrix[3][2]) && matrix[3][1].equals(matrix[3][3]) && !matrix[3][1].equals(" ")) {
                System.out.println(matrix[3][1] + " wins");
                return;
            }

            //Columns condition
            else if (matrix[1][1].equals(matrix[2][1]) && matrix[1][1].equals(matrix[3][1]) && !matrix[1][1].equals(" ")) {
                System.out.println(matrix[1][1] + " wins");
                return;
            } else if (matrix[1][2].equals(matrix[2][2]) && matrix[1][2].equals(matrix[3][2]) && !matrix[1][2].equals(" ")) {
                System.out.println(matrix[1][2] + " wins");
                return;
            } else if (matrix[1][3].equals(matrix[2][3]) && matrix[1][3].equals(matrix[3][3]) && !matrix[1][3].equals(" ")) {
                System.out.println(matrix[1][3] + " wins");
                return;
            }

            //Diagonal
            else if (matrix[1][1].equals(matrix[2][2]) && matrix[1][1].equals(matrix[3][3]) && !matrix[1][1].equals(" ")) {
                System.out.println(matrix[1][1] + " wins");
                return;
            } else if (matrix[3][1].equals(matrix[2][2]) && matrix[3][1].equals(matrix[1][3]) && !matrix[3][1].equals(" ")) {
                System.out.println(matrix[3][1] + " wins");
                return;
            } else if (cntu >= 9) {
                System.out.println("Game not finished" + cntu);
                return;
            } else {
                coord = get_coords();
            }


            while ((matrix[coord[0]][coord[1]].equals("X") || matrix[coord[0]][coord[1]].equals("O")) && !matrix[coord[0]][coord[1]].equals(" ")) {
                System.out.println("This cell is occupied! Choose another one!");
                coord = get_coords();
            }

            if (player == 0) {
                matrix[coord[0]][coord[1]] = "O";
                turns++;
                player = 1;
            } else if (player == 1) {
                matrix[coord[0]][coord[1]] = "X";
                turns++;
                player = 0;
            }
        }
        for (int i=1;i<=3;i++)
            for(int j=1;j<=3;j++)
                if(matrix[i][j].equals(" ")) {
                    System.out.println("Game not finished!");
                    return;
                }
                else
                {

                    display_matrix(matrix);
                    System.out.println("Draw");
                    return;
                }

    }

}


