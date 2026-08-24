class Solution {
    public boolean isValidSudoku(char[][] board) {

        // We create 9 HashSets for rows.
        // rows[i] will store all numbers already seen in row i.
        HashSet<Character>[] rows = new HashSet[9];

        // We create 9 HashSets for columns.
        // cols[j] will store all numbers already seen in column j.
        HashSet<Character>[] cols = new HashSet[9];

        // We create 9 HashSets for 3x3 boxes.
        // boxes[k] will store all numbers already seen in box k.
        HashSet<Character>[] boxes = new HashSet[9];


        // Initialize all 9 HashSets for rows, columns and boxes.
        // We need separate HashSets because every row, column and box
        // has its own set of numbers.
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        // Visit every cell of the Sudoku board.
        // i = row number
        // j = column number
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                // Get the current cell value.
                char num = board[i][j];


                // '.' means the cell is empty.
                // We don't need to check an empty cell,
                // so move directly to the next cell.
                if (num == '.') {
                    continue;
                }


                // Find which 3x3 box this cell belongs to.
                //
                // The boxes are numbered like this:
                //
                //  0 | 1 | 2
                // ---+---+---
                //  3 | 4 | 5
                // ---+---+---
                //  6 | 7 | 8
                //
                // (i / 3) gives the box row.
                // (j / 3) gives the box column.
                //
                // Multiplying box row by 3 converts it
                // into the correct box number.
                int boxIndex = (i / 3) * 3 + (j / 3);


                // Check whether this number already exists in:
                //
                // 1. The current row
                // 2. The current column
                // 3. The current 3x3 box
                //
                // If it exists in ANY of these,
                // the Sudoku is invalid.
                if (rows[i].contains(num) ||
                    cols[j].contains(num) ||
                    boxes[boxIndex].contains(num)) {

                    return false;
                }


                // The number is valid so far.
                // Add it to the current row.
                rows[i].add(num);

                // Add it to the current column.
                cols[j].add(num);

                // Add it to the current 3x3 box.
                boxes[boxIndex].add(num);
            }
        }


        // We checked all 81 cells and didn't find
        // any duplicate in a row, column or box.
        // Therefore, the Sudoku is valid.
        return true;
    }
}