import javax.swing.*;

/**
 * The main class of the software product.
 * Task: https://en.wikipedia.org/wiki/Eight_queens_puzzle
 *
 * @author Syniuk Valentyn
 * @version 1.0
 */
public class EightQueensPuzzle_Main {

    public static void main(String[] args) throws InterruptedException {

        SwingUtilities.invokeLater(EightQueensPuzzle::new);
        EightQueensPuzzle.solutionTask();
    }
}
