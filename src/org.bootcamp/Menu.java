package org.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Menu implements KeyboardHandler {

    Background background;
    Keyboard keyboard;




    public Menu() throws InterruptedException {
        this.background = new Background(10, 10);
        this.background.bgInit();
        this.kbInit();

      //  Thread.sleep(1000);

       // this.background.rect.delete();
       // this.background.picture.delete();
    }
    public void menuEnd(){
        this.background.rect.delete();
        this.background.picture.delete();
    }

    public void kbInit() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent spaceKeyboardPress = new KeyboardEvent();
        // KeyboardEvent spaceKeyboardRelease = new KeyboardEvent();
        //spaceKeyboardRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyboardPress.setKey(KeyboardEvent.KEY_D);
        spaceKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        //  spaceKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(spaceKeyboardPress);
        //  this.keyboard.addEventListener(spaceKeyboardPress);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
