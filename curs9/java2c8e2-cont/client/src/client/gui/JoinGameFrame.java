package client.gui;

import client.service.GameController;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;

public class JoinGameFrame extends JFrame {
    private JPanel mainPanel;

    private String gameId;

    public JoinGameFrame(String gameId) {
        this.gameId = gameId;

        new Thread(() -> joinGame(gameId)).start();

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void joinGame(String gameId) {
        Question q = null;

        while (q == null) {
            String playerName = JOptionPane.showInputDialog("Introdu un nume");
            Player player = new Player(playerName);

            try {
                q = GameController.getInstance().joinGame(gameId, player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null, q.getContent());
        dispose();
        new MainFrame();

        // TODO: deschide fereastra cu intrebarea
    }
}
