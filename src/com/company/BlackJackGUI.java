package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackGUI {
    private JButton startNewRoundButton;
    private JTextField enterBetHereTextField;
    private JButton drawButton;
    private JButton doubleDownButton;
    private JButton standButton1;
    private JPanel firstPanel;

    public BlackJackGUI() {
        startNewRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main();
            }
        });
    }

    public void setData(Main data) {
    }

    public void getData(Main data) {
    }

    public boolean isModified(Main data) {
        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Blackjack App");
        frame.setContentPane(new BlackJackGUI().firstPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
