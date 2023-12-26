package org.bootcamp;


public class Grid {


    private int row;
    private int col;

    public static final int CELL_SIZE = 50;

    final int PADDING = 10;

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public int getCols() {
        return col;
    }


    public int getRows() {
        return row;
    }

    public int colToX(int col) {
        return PADDING + col * CELL_SIZE;
    }

    public int rowToY(int row) {
        return PADDING + row * CELL_SIZE;
    }

    public GridPosition makeGridPosition() {
        int randomCol = (int) (Math.random() * (col - 0)) + 0;
        int randomRow = (int) (Math.random() * (row - 0)) + 0;
        return new GridPosition(col, row, this);
    }


    public GridPosition makeGridPosition(int col, int row) {
        return new GridPosition(col, row, this);

    }
}

