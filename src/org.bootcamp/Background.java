package org.bootcamp;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    Picture picture;
    Rectangle rect;

    Text nome;
    Text score;
    Text mines;
    Text scoreText;
    Text minesText;
    Text controls;


    public Background(int padX, int padY) {
        this.rect = new Rectangle(padX, padY, 1200, 600);
        //this.rect.setColor(Color.BLACK);
        //this.rect.fill();

    }

    public void bgInit(){
        this.rect.setColor(Color.BLACK);
        this.picture = new Picture(10, 10, "Title.jpeg");
        this.picture.draw();
    }

    public void levelInit(){
        //this.nome = new Text(10,10, "A TEAM GAME");
       // this.nome.setColor(Color.WHITE);
       // this.nome.draw();
        this.rect.setColor(Color.BLACK);
        this.rect.fill();
        switch((int) Math.floor(Math.random()*5)){
            case 0:
                this.picture = new Picture(60,60,"City.png");
                this.picture.draw();
                break;
            case 2:
                this.picture = new Picture(60,60,"City1.png");
                this.picture.draw();
                break;
            case 1:
                this.picture = new Picture(60,60,"City2.png");
                this.picture.draw();
                break;
            case 3:
                this.picture = new Picture(60,60,"City3.png");
                this.picture.draw();
                break;
            case 4:
                this.picture = new Picture(60,60,"City4.png");
                this.picture.draw();
                break;
            case 5:
                this.picture = new Picture(60,60,"battlefieldBG.jpeg");
                this.picture.draw();
                break;
        }
        this.nome = new Text(575,27, "A TEAM GAME");
        this.nome.grow(50,25);
        this.nome.setColor(Color.LIGHT_GRAY);
        this.nome.draw();
        this.scoreText = new Text(1000, 575, "SCORE: "  );
        this.scoreText.grow(30,20);
        this.scoreText.setColor(Color.LIGHT_GRAY);
        this.scoreText.draw();
        this.score = new Text(575, 567, " " );
        this.score.grow(30,20);
        this.score.setColor(Color.LIGHT_GRAY);
        this.score.draw();
        this.minesText = new Text(150, 575, "MINES: ");
        this.minesText.grow(30,20);
        this.minesText.setColor(Color.LIGHT_GRAY);
        this.minesText.draw();
        this.mines = new Text(500, 567," ");
        this.mines.draw();
        this.controls = new Text(585, 580, "W ↑     A ←     D →     S ↓");
        this.controls.grow(60,15);
        this.controls.setColor(Color.LIGHT_GRAY);
        this.controls.draw();

    }

    public void gameOverInit() throws InterruptedException {
        this.picture = new Picture (10,10, "gameOver.png");
        this.picture.draw();
        Thread.sleep(700);
        this.picture = new Picture(10,10,"estudasses1.jpg");
        this.picture.draw();
        Thread.sleep(700);
        this.picture = new Picture(10,10,"estudasses2.jpg");
        this.picture.draw();
    }
}
