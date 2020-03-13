package main;

import gui.MainFrame;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

        JFrame f; // Alt + Enter
        f = new JFrame();

        f.setContentPane(frame.getPanel());

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
