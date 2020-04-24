package client.gui;

import client.controller.GameController;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;
import java.util.Objects;

public class JoinFrame extends JFrame {
    private Player player;
    private JPanel contentPane;
    private JLabel label1;

    private String gameId;

    public JoinFrame(String gameId) {
        this.gameId = gameId;

        new Thread(() -> {
            Question firstQuestion = joinGame(gameId);

            new GamePlayerFrame(firstQuestion, gameId, player)
                    .setVisible(true);

            dispose();
        }).start();

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
    }

    private Question joinGame(String gameId) {
        String playerName = null;
        Question question = null;

        while (playerName == null) {
            playerName = JOptionPane.showInputDialog(null, "Introdu un nume");

            try {
                Objects.requireNonNull(playerName);

                question = GameController.getInstance()
                        .joinGame(playerName, gameId);

                player = new Player(playerName);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nume deja folosit");
                playerName = null;
                e.printStackTrace();
            }
        }

        return question;
    }
}
