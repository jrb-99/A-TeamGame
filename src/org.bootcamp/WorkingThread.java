package org.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WorkingThread extends Thread {


    Game game;

    boolean bool = false;
    Integer cycles = new Integer(0);
    boolean isMenu = true;

    public WorkingThread() throws InterruptedException {
        this.game = new Game();
        // game.init();
    }

    @Override
    public void run() {
        while (true) {
            if (!bool) {
                try {
                    Thread.sleep(100);
                    continue;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (this.isMenu) {
                    //game.init();
                    game.menu.menuEnd();
                    game.init();
                    this.isMenu = false;
                }
                if (!game.handler.user.isDead) {
                    game.crashDetection(game.snake, game.handler.user);
                    try {
                        switch((int)Math.floor(Math.random()*4)){
                            case 0:
                            case 1:
                            case 2:
                                game.snake.move(game.handler.user.pos);
                                break;
                            case 3:
                        }
                        cycles++;
                        this.game.background.score.delete();
                        this.game.background.score = new Text(1083, 575, cycles.toString() );
                        this.game.background.score.grow(25,20);
                        this.game.background.score.setColor(Color.LIGHT_GRAY);
                        this.game.background.score.draw();
                        this.game.background.mines.delete();
                        Integer mineTotal = new Integer(cycles/10);
                        this.game.background.mines = new Text(230, 575, mineTotal.toString());
                        this.game.background.mines.grow(25,20);
                        this.game.background.mines.setColor(Color.LIGHT_GRAY);
                        this.game.background.mines.draw();
                        if (cycles % 10 == 0) {
                            game.snake.grow();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    game.crashDetection(game.snake, game.handler.user);
                }
                if (game.handler.user.isDead) {
                   // game.snake = null;
                    //game.handler.user = null;
                    try {
                        game.background.gameOverInit();
                        Thread.sleep(3000);
                        bool = false;
                        this.isMenu = true;
                        this.cycles = -1;
                        this.game = new Game();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }

                bool = false;
            }
        }
    }

    public void sleeping() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

