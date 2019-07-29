public class Solution {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] tempCells = new int[8];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 8; j++) tempCells[j] = cells[j];
            for (int j = 1; j < 7; j++) {
                if (tempCells[j - 1] == 1 && tempCells[j + 1] == 1) {
                    cells[j] = 1;
                } else if (tempCells[j - 1] == 0 && tempCells[j + 1] == 0) {
                    cells[j] = 1;
                } else {
                    cells[j] = 0;
                }
            }
            cells[0] = 0;
            cells[7] = 0;
        }
        return cells;
    }

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 7;
        prisonAfterNDays(cells ,N);
    }
}