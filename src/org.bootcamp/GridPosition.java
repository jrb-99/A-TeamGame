package org.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridPosition {


    int col;
    int row;
    Grid grid;

    public Picture pic;

    public GridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;

    }


    public Grid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#setPos(int, int)
     */

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    /**
     * @see GridPosition#getCol()
     */

    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */

    public int getRow() {
        return row;
    }


    public void moveInDirection(GridDirection direction) {

        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }

    }

    /**
     * @see GridPosition#equals(GridPosition)
     */
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }

    public void moveUp() {
        this.subRow();
    }

    public void moveDown() {
        this.addRow();
    }

    public void moveLeft() {
        this.subCol();
    }

    public void moveRight() {
        this.addCol();
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }

    public void addCol() {
        this.col++;
    }

    public void addRow() {
        this.row++;
    }

    public void subRow() {
        this.row--;
    }

    public void subCol() {
        this.col--;
    }


    public void show() {
        this.pic.draw();
    }

    public void hide() {
        this.pic.delete();
    }
}


