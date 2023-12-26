package org.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.bootcamp.*;

public class Game {

    //int delay = 500;

    //Snake snake;
    Handler handler;
    Grid grid;
    Background background;
    Keyboard keyboard;
    Menu menu;

    Snake snake;


   // boolean turn = false;




    public Game() throws InterruptedException {
        this.menu = new Menu();
    }
    public void init(){
        this.grid = new Grid(10,22);


        this.start();

    }

    public void start(){
        this.background = new Background(10,10);
        background.levelInit();
        handler = new Handler(this.grid);
        snake = new Snake(new GridPosition(11,6, this.grid),this.grid);

    }

    public void crashDetection(Snake snake, User user){
        for(GridPosition snakePos : snake.gridList){
            if(user.pos.getRow() == snakePos.getRow() && user.pos.getCol() == snakePos.getCol()){
                user.isDead = true;
                return;
            }
        }
    }

    /*
    public void kbInit(){

        this.keyboard = new Keyboard(this);

        KeyboardEvent spaceKeyboardPress = new KeyboardEvent();
        KeyboardEvent spaceKeyboardRelease = new KeyboardEvent();
        spaceKeyboardRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyboardPress.setKey(KeyboardEvent.KEY_D);
        spaceKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(spaceKeyboardPress);
        this.keyboard.addEventListener(spaceKeyboardPress);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        System.out.println("keypressed");
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                this.skipTurn();
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }*/
}
