package org.bootcamp;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        WorkingThread workingThread = new WorkingThread();
        PausingThread pausingThread = new PausingThread(workingThread);
        pausingThread.start();
        workingThread.start();



        Sound sound = new Sound();
       // sound.play();


    }
}
