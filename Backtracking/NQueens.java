import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // Solve N-Queens and return list of board representations
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n]; // queens[row] = col
        backtrack(0, n, queens, solutions);
        return solutions;
    }

    private void backtrack(int row, int n, int[] queens, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(buildBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;
                backtrack(row + 1, n, queens, solutions);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] queens) {
        for (int r = 0; r < row; r++) {
            int c = queens[r];
            if (c == col) return false; // same column
            if (Math.abs(c - col) == Math.abs(r - row)) return false; // diagonal
        }
        return true;
    }

    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; c++) {
                sb.append(queens[r] == c ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }

    // Demo main
    public static void main(String[] args) {
        NQueens solver = new NQueens();
        int n = 4;
        List<List<String>> sols = solver.solveNQueens(n);
        System.out.println("Solutions for " + n + "-Queens:");
        for (List<String> board : sols) {
            for (String row : board) System.out.println(row);
            System.out.println();
        }
    }
}
