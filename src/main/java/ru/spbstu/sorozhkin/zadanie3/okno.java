package ru.spbstu.sorozhkin.zadanie3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class okno extends JFrame {
    private int windowWidth = 800;
    private pole gameP;

    private class myKey implements KeyListener{
        public void keyPressed(KeyEvent e){
            int key_ = e.getKeyCode();
            int pcWidthPart = 48;
            int step = 30;
            if (key_ == KeyEvent.VK_ESCAPE) System.exit(0);
            else if (key_ == KeyEvent.VK_LEFT) {
                if (gameP.x - step > -pcWidthPart) gameP.x -= step;
                else gameP.x=windowWidth- pcWidthPart;
            }
            else if (key_ == KeyEvent.VK_RIGHT){
                if (gameP.x+ step <windowWidth- pcWidthPart) gameP.x+= step;
                else gameP.x=-pcWidthPart;
            }
        }
        public  void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e){}
    }

    okno(int slogn){
        addKeyListener(new myKey());
        setFocusable(true);
        setBounds(0,0,windowWidth,600);
        setTitle("Игра: Установка ПО");
        gameP = new pole(slogn);
        Container con = getContentPane();
        con.add(gameP);
        setVisible(true);
    }
}
