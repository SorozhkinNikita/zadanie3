package ru.spbstu.sorozhkin.zadanie3;

import javax.swing.*;

public class game {
    public static void main(String[] args) {
       String rez =
               JOptionPane.showInputDialog(null, "Введите сложность игры от 1 до 7:", "Сложность игры", JOptionPane.INFORMATION_MESSAGE);
       int slogn = rez.charAt(0)-'0';
       if ((slogn>=1)&&(slogn<=7)){
           new okno(slogn);
       }
       else JOptionPane.showMessageDialog(null, "Введена некорректная сложность");
    }
}
