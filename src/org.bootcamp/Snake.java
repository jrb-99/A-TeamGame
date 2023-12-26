package org.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.Grid;
import org.bootcamp.GridDirection;
import org.bootcamp.GridPosition;


import javax.jws.soap.SOAPBinding;
import java.util.LinkedList;

public class Snake {
    LinkedList<GridPosition> gridList;
    Grid grid;
    GridDirection currentDirection;
    public GridPosition posSnake;


    public Snake(GridPosition gridPositionSnake, Grid grid) {
        this.grid = grid;
        this.gridList = new LinkedList<>();
        gridList.add(gridPositionSnake);
        gridList.getFirst().pic = new Picture(grid.colToX(gridList.getFirst().col), grid.rowToY(gridList.getFirst().row), "/CarSnake.png");
        gridList.getFirst().pic.draw();
    }

    public void move(GridPosition gpos) throws InterruptedException {

        switch (chooseDirection(gpos)) {
            case UP:
                gridList.getFirst().moveUp();
                gridList.getFirst().pic.translate(0, -25);
                Thread.sleep(25);
                gridList.getFirst().pic.translate(0, -25);
                break;
            case DOWN:
                gridList.getFirst().moveDown();
                gridList.getFirst().pic.translate(0, 25);
                Thread.sleep(25);
                gridList.getFirst().pic.translate(0, 25);
                break;
            case RIGHT:
                gridList.getFirst().moveRight();
                gridList.getFirst().pic.translate(25, 0);
                Thread.sleep(25);
                gridList.getFirst().pic.translate(25, 0);
                break;
            case LEFT:
                gridList.getFirst().moveLeft();
                gridList.getFirst().pic.translate(-25, 0);
                Thread.sleep(25);
                gridList.getFirst().pic.translate(-25, 0);
                break;
        }

    }


    public GridDirection chooseDirection(GridPosition p1Pos) {

        GridPosition head = gridList.getFirst();
        GridPosition buffer = new GridPosition(p1Pos.getCol(), p1Pos.getRow(), this.grid);
        if (p1Pos.getCol() == head.getCol()) {
            if (p1Pos.getRow() < head.getRow()) {
                this.currentDirection = GridDirection.UP;
            }
            if (p1Pos.getRow() > head.getRow()) {
                this.currentDirection = GridDirection.DOWN;
            }
        }
        if (p1Pos.getRow() == head.getRow()) {
            if (p1Pos.getCol() < head.getCol()) {
                this.currentDirection = GridDirection.LEFT;
                return this.currentDirection;
            }
            if (p1Pos.getCol() > head.getCol()) {
                this.currentDirection = GridDirection.RIGHT;
            }
        }
        if (p1Pos.getCol() > head.getCol()) {
            if (p1Pos.getRow() > head.getRow()) {
                switch ((int) Math.floor(Math.random() * 2)) {
                    case 0:
                        buffer.addCol();
                        for (GridPosition pos : gridList) {
                            if (buffer.equals(pos)) {
                                this.currentDirection = GridDirection.DOWN;
                            }
                        }
                        this.currentDirection = GridDirection.RIGHT;
                    case 1:
                        buffer.addRow();
                        for (GridPosition pos : gridList) {
                            if (buffer.equals(pos)) {
                                this.currentDirection = GridDirection.RIGHT;
                            }
                        }
                        this.currentDirection = GridDirection.DOWN;
                }
            }
            if (p1Pos.getRow() < head.getRow()) {
                switch ((int) Math.floor(Math.random() * 2)) {
                    case 0:
                        buffer.addCol();
                        for (GridPosition pos : gridList) {
                            if (buffer.equals(pos)) {
                                this.currentDirection = GridDirection.UP;
                            }
                        }
                        this.currentDirection = GridDirection.RIGHT;
                    case 1:
                        buffer.subRow();
                        for (GridPosition pos : gridList) {
                            if (buffer.equals(pos)) {
                                this.currentDirection = GridDirection.RIGHT;
                            }
                        }
                        this.currentDirection = GridDirection.UP;
                }
            }
        }
        if (p1Pos.getCol() < head.getCol()) {
            if (p1Pos.getRow() > head.getRow()) {
                switch ((int) Math.floor(Math.random() * 2)) {
                    case 0:
                        buffer.subCol();
                        for (GridPosition pos : gridList) {
                            if (buffer.equals(pos)) {
                                this.currentDirection = GridDirection.DOWN;
                            }
                        }
                        this.currentDirection = GridDirection.LEFT;
                    case 1:
                        buffer.addRow();
                        for (GridPosition pos : gridList) {
                            if (buffer.equals(pos)) {
                                this.currentDirection = GridDirection.LEFT;
                            }
                        }
                        this.currentDirection = GridDirection.DOWN;
                }
            }
        }
        if (p1Pos.getRow() < head.getRow()) {
            switch ((int) Math.floor(Math.random() * 2)) {
                case 0:
                    buffer.subCol();
                    for (GridPosition pos : gridList) {
                        if (buffer.equals(pos)) {
                            this.currentDirection = GridDirection.UP;
                        }
                    }
                    this.currentDirection = GridDirection.LEFT;
                case 1:
                    buffer.subRow();
                    for (GridPosition pos : gridList) {
                        if (buffer.equals(pos)) {
                            this.currentDirection = GridDirection.LEFT;
                        }
                    }
                    this.currentDirection = GridDirection.UP;
            }

        }
        return this.currentDirection;
    }

    public void grow() {

            int i = (int) Math.floor(Math.random()*3);

            GridPosition gridPosition = new GridPosition(gridList.getFirst().getCol(), gridList.getFirst().getRow(), this.grid);
            switch(i){
                case 0:
                    gridPosition.pic = new Picture(grid.colToX(gridPosition.col), grid.rowToY(gridPosition.row), "/tankLeftpng.png");
                    break;
                case 1:

                    break;

                case 3:

                    break;
            }
            switch((int) Math.floor(Math.random()*5)){
                case 0:
                    gridPosition.pic = new Picture(grid.colToX(gridPosition.col), grid.rowToY(gridPosition.row), "/bombcs.png");
                    break;
                case 1:
                    gridPosition.pic = new Picture(grid.colToX(gridPosition.col), grid.rowToY(gridPosition.row), "/damageCop.png");
                    break;
                case 2:
                    gridPosition.pic = new Picture(grid.colToX(gridPosition.col), grid.rowToY(gridPosition.row), "/mina1.png");
                    break;
                case 3:
                    gridPosition.pic = new Picture(grid.colToX(gridPosition.col), grid.rowToY(gridPosition.row), "/mina2.png");
                    break;
                case 4:
                    gridPosition.pic = new Picture(grid.colToX(gridPosition.col), grid.rowToY(gridPosition.row), "/noLegCope.png");
                    break;
            }
            gridList.add(gridPosition);
            gridPosition.pic.draw();
        }
    }


