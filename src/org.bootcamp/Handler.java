package org.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Handler implements KeyboardHandler {

    Keyboard keyboard;
    User user;

    public Handler(Grid grid) {
        this.user = new User(grid);
        this.user.pos = new GridPosition(1, 1, grid);
        switch((int) Math.floor(Math.random() * 4)){
            case 0:
                this.user.pos.pic = new Picture(grid.colToX(user.pos.col), grid.rowToY(user.pos.row), "/mr.png");
                break;
            case 1:
                this.user.pos.pic = new Picture(grid.colToX(user.pos.col), grid.rowToY(user.pos.row), "/faceMan.png");
                break;
            case 2:
                this.user.pos.pic = new Picture(grid.colToX(user.pos.col), grid.rowToY(user.pos.row), "/Hannibal.png");
                break;
            case 3:
                this.user.pos.pic = new Picture(grid.colToX(user.pos.col), grid.rowToY(user.pos.row), "/Murdock.png");
                break;
        }
        this.user.pos.pic.draw();
        keyboard = new Keyboard(this);
        createKeyboardEvents();

    }

    public void createKeyboardEvents() {

        //Right
        KeyboardEvent rightKeyboardPress = new KeyboardEvent();
        KeyboardEvent rightKeyboardRelease = new KeyboardEvent();
        rightKeyboardRelease.setKey(KeyboardEvent.KEY_D);
        rightKeyboardPress.setKey(KeyboardEvent.KEY_D);
        rightKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(rightKeyboardPress);
        this.keyboard.addEventListener(rightKeyboardRelease);

        //left
        KeyboardEvent leftKeyboardPress = new KeyboardEvent();
        KeyboardEvent leftKeyboardRelease = new KeyboardEvent();
        leftKeyboardRelease.setKey(KeyboardEvent.KEY_A);
        leftKeyboardPress.setKey(KeyboardEvent.KEY_A);
        leftKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(leftKeyboardPress);
        this.keyboard.addEventListener(leftKeyboardRelease);

        //up
        KeyboardEvent upKeyboardPress = new KeyboardEvent();
        KeyboardEvent upKeyboardRelease = new KeyboardEvent();
        upKeyboardRelease.setKey(KeyboardEvent.KEY_W);
        upKeyboardPress.setKey(KeyboardEvent.KEY_W);
        upKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(upKeyboardPress);
        this.keyboard.addEventListener(upKeyboardRelease);

        //down

        KeyboardEvent downKeyboardPress = new KeyboardEvent();
        KeyboardEvent downKeyboardRelease = new KeyboardEvent();
        downKeyboardRelease.setKey(KeyboardEvent.KEY_S);
        downKeyboardPress.setKey(KeyboardEvent.KEY_S);
        downKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(downKeyboardPress);
        this.keyboard.addEventListener(downKeyboardRelease);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case (KeyboardEvent.KEY_W):
                if(user.pos.row == 1){
                    break;
                }
                try {
                    user.moveUp();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (KeyboardEvent.KEY_S):
                if(user.pos.row == user.userGrid.getRows()  ){
                    break;
                }
                try {
                    user.moveDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (KeyboardEvent.KEY_D):
                if(user.pos.col == user.userGrid.getCols() ){
                    break;
                }
                try {
                    user.moveRight();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (KeyboardEvent.KEY_A):
                if(user.pos.col == 1){
                    break;
                }
                try {
                    user.moveLeft();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
