package org.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class User {


    public GridPosition pos;
   // Picture pic;
    Grid userGrid;

    Boolean isDead = false;

    public User(Grid grid){
        this.userGrid = grid;
    }



    public void moveRight() throws InterruptedException {
        pos.addCol();
        pos.pic.translate(25,0);
        pos.pic.translate(25,0);
    }

    public void moveLeft() throws InterruptedException {
        pos.subCol();
        pos.pic.translate(-25,0);
        pos.pic.translate(-25,0);
    }

    public void moveUp() throws InterruptedException {
        pos.subRow();
        pos.pic.translate(0,-25);
        pos.pic.translate(0,-25);
    }

    public void moveDown() throws InterruptedException {
        pos.addRow();
        pos.pic.translate(0,25);
        pos.pic.translate(0,25);
    }
}
