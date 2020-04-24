package client.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JButton creazaJocButton;
    private JTextField textField1;
    private JButton intraInJocButton;
    private JPanel contentPane;

    public MainFrame() {
        initListeners();

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initListeners() {
        creazaJocButton.addActionListener(e -> {
            dispose();
            new CreateGameFrame().setVisible(true);
        });

        intraInJocButton.addActionListener(e -> {
            dispose();

            String gameId = textField1.getText();

            new JoinFrame(gameId).setVisible(true);
        });
    }

}
