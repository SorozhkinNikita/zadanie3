package ru.spbstu.sorozhkin.zadanie3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class software {
    Image img;
    int x,y;
    Boolean act;
    private Timer timerUpdate;
    int speed = 1;

    software(Image img){
        timerUpdate = new Timer(25, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vniz();
            }
        });
        this.img = img;
        act = false;
    }

    void start(){
        timerUpdate.start();
        y = 0;
        x = (int)(Math.random()*700);
        act=true;
    }

    private void vniz(){
        if (act){
            y+=speed;
        }
        if((y+img.getHeight(null))>=470){
            timerUpdate.stop();
        }
    }

    void draw(Graphics gr){
        if (act){
             gr.drawImage(img, x, y, null);
        }
    }
}
