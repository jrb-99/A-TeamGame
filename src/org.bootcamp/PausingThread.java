package org.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PausingThread extends Thread implements KeyboardHandler {

    WorkingThread workingThread;
    Keyboard keyboard;

    public PausingThread(WorkingThread workingThread) {
        keyboard = new Keyboard(this);
        this.workingThread = workingThread;
        KeyboardEvent rightKeyboardPress = new KeyboardEvent();
        KeyboardEvent rightKeyboardRelease = new KeyboardEvent();
        KeyboardEvent leftKeyboardPress = new KeyboardEvent();
        KeyboardEvent upKeyboardPress = new KeyboardEvent();
        KeyboardEvent downKeyboardPress = new KeyboardEvent();
        KeyboardEvent spaceKeyboardPress = new KeyboardEvent();
        leftKeyboardPress.setKey(KeyboardEvent.KEY_A);
        upKeyboardPress.setKey(KeyboardEvent.KEY_W);
        downKeyboardPress.setKey(KeyboardEvent.KEY_S);
        rightKeyboardRelease.setKey(KeyboardEvent.KEY_D);
        rightKeyboardPress.setKey(KeyboardEvent.KEY_D);
        spaceKeyboardPress.setKey(KeyboardEvent.KEY_SPACE);
        leftKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyboardRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spaceKeyboardPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(upKeyboardPress);
        this.keyboard.addEventListener(leftKeyboardPress);
        this.keyboard.addEventListener(downKeyboardPress);
        this.keyboard.addEventListener(rightKeyboardPress);
        this.keyboard.addEventListener(rightKeyboardRelease);
        this.keyboard.addEventListener(spaceKeyboardPress);
    }

    public void run() {


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
            case KeyboardEvent.KEY_W:
            case KeyboardEvent.KEY_S:
            case KeyboardEvent.KEY_A:
            case KeyboardEvent.KEY_SPACE:
                workingThread.bool = true;
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
