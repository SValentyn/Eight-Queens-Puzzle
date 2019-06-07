import javax.swing.*;
import java.awt.*;

/**
 * Class with methods to implement the solution of the eight queens problem.
 * The visualization is based on the Swing library.
 */
class EightQueensPuzzle {

    private static final int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];
    private static JLabel[][] jLabel = new JLabel[SIZE][SIZE];

    EightQueensPuzzle() {
        JFrame jFrame = new JFrame("<<< EightQueensPuzzle >>>");
        jFrame.setLayout(new GridLayout(SIZE, SIZE));
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* filling cells with information and adding them to the panel */
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                jLabel[i][j] = new JLabel("(" + i + ";" + j + ")");
                jLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                jLabel[i][j].setSize(200, 200);
                jLabel[i][j].setOpaque(true); // paint over each pixel within its borders

                jFrame.add(jLabel[i][j]);
            }
        }

        jFrame.setVisible(true);
    }

    static void solutionTask() throws InterruptedException {
        Thread.sleep(500);

        /* set board */
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                Thread.sleep(25);
                board[i][j] = 0;
                jLabel[i][j].setBackground(Color.BLUE);
            }
        }

        if (!findSolution(0)) {
            System.out.println("No Solution!\n");
        } else {
            System.out.println("The result of the program:\n");
            printSolution();
        }

    }

    /**
     * Search for a solution to the task.
     */
    private static boolean findSolution(int column) throws InterruptedException {
        if (column >= SIZE) return true;

        for (int i = 0; i < SIZE; ++i) {
            /* slow down animation */
            Thread.sleep(0);

            /* if the queen is located correctly */
            if (ifBusy(i, column)) {
                board[i][column] = 1; // mark the location of the queen
                jLabel[i][column].setBackground(Color.ORANGE);

                if (findSolution(column + 1)) return true;

                board[i][column] = 0; // cells that have already been involved in building
                jLabel[i][column].setBackground(Color.WHITE);
            }
        }

        return false;
    }

    /**
     * Method for detecting queens conflicts.
     */
    private static boolean ifBusy(int row, int column) throws InterruptedException {
        Thread.sleep(20);

        for (int i = 0; i < column; ++i) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; i < SIZE && j >= 0; ++i, --j) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method to show the solution on the console.
     */
    private static void printSolution() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }

}
