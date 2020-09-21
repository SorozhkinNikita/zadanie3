package ru.spbstu.sorozhkin.zadanie3;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class pole extends JPanel {
    private int score = 1;
    private Image pc;
    private Image fon;
    int x = 400;
    private int slogn;
    private software[] gameSoftware;
    private Image end_game;
    private Timer timerUpdate, timerDraw;

    pole(int slogn) {
        this.slogn = slogn;
        try {
            pc = ImageIO.read(new File("images/pc.png"));
        } catch (IOException ignored) {
        }
        try {
            fon = ImageIO.read(new File("images/fon.png"));
        } catch (IOException ignored) {
        }
        try {
            end_game = ImageIO.read(new File("images/end_game.png"));
        } catch (IOException ignored) {
        }
        gameSoftware = new software[14];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 7; i++) {
                try {
                    gameSoftware[i+7*j] = new software(ImageIO.read(new File("images/p" + i + ".png")));
                } catch (IOException ignored) {
                }
            }
        }
        //поработать над формулой запуска
        timerUpdate = new Timer(65*(9-slogn)*(10-score/5), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStart();
            }
        });
        timerUpdate.start();

        timerDraw = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();
    }
//вынести проверки
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(fon, 0, 0, null);
        gr.drawImage(pc, x, 465, null);
        for (int i = 0; i < 14; i++) {
            gameSoftware[i].draw(gr);
            if (score%5==0)gameSoftware[i].speed=score/5+1;
            if (gameSoftware[i].act) {
                if ((gameSoftware[i].y + gameSoftware[i].img.getHeight(null)) >= 470)
                    if (Math.abs(gameSoftware[i].x - x) > 75) {
                        gr.drawImage(end_game, 0, 0, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        //погуглить ошибку
                        JOptionPane.showMessageDialog(null, "Ваш счет:" + score, "game over", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        gameSoftware[i].act = false;
                        score++;
                    }
            }
        }
    }

    private void updateStart() {
        int kol = 0;
        for (int i = 0; i < 14; i++) {
            if (!gameSoftware[i].act) {
                if (kol < slogn * 2) {
                    gameSoftware[i].start();
                    break;
                }
            } else kol++;
        }
    }
}