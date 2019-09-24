package p79.WordSearch;

class Solution {
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (existHelper(board, word, visited, i, j))
                    return true;
            }
        }
        return false;
    }

    private static boolean existHelper(char[][] board, String word, boolean[][] visited, int row, int col) {
        if (board[row][col] != word.charAt(0))
            return false;
        if (word.length() == 1 && board[row][col] == word.charAt(0))
            return true;

        visited[row][col] = true;
        boolean result = false;
        if (valid(board, row - 1, col) && !visited[row - 1][col] && board[row - 1][col] == word.substring(1).charAt(0))
            result = result || existHelper(board, word.substring(1), visited, row - 1, col);
        if (valid(board, row + 1, col) && !visited[row + 1][col] && board[row + 1][col] == word.substring(1).charAt(0))
            result = result || existHelper(board, word.substring(1), visited, row + 1, col);
        if (valid(board, row, col - 1) && !visited[row][col - 1] && board[row][col - 1] == word.substring(1).charAt(0))
            result = result || existHelper(board, word.substring(1), visited, row, col - 1);
        if (valid(board, row, col + 1) && !visited[row][col + 1] && board[row][col + 1] == word.substring(1).charAt(0))
            result = result || existHelper(board, word.substring(1), visited, row, col + 1);
        visited[row][col] = false;
        return result;
    }

    private static boolean valid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
