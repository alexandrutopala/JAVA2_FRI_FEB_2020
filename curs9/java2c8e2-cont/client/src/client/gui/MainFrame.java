package client.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton creeazaJocButton;
    private JButton intraInJocButton;
    private JTextField textField1;
    private JPanel mainPanel;

    public MainFrame() {

        creeazaJocButton.addActionListener(ev -> {
            dispose();
            new CreateGameFrame();
        });

        intraInJocButton.addActionListener(ev -> {
            dispose();
            String gameId = textField1.getText();

            new JoinGameFrame(gameId);
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
