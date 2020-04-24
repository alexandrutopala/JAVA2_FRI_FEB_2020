package client.gui;

import client.controller.GameController;
import client.dispatcher.DispatcherService;
import client.dispatcher.JoinEventListener;
import lib.event.JoinEvent;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateGameFrame extends JFrame implements JoinEventListener {
    private JList list1;
    private JButton startButton;
    private JPanel contentPane;
    private JLabel label1;
    private DefaultListModel<Player> model;

    private String gameId;

    public CreateGameFrame() {
        initComponents();

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        startButton.addActionListener(e -> {
           DispatcherService.get(gameId)
                    .removeListener(CreateGameFrame.this);

            Question first = GameController.getInstance().startGame(gameId);

            new GameOwnerFrame(first, gameId).setVisible(true);

            dispose();
        });

        model = new DefaultListModel<>();
        list1.setModel(model);

        gameId = GameController.getInstance().createGame(getQuestions());

        label1.setText(gameId);

        setTitle("Joc: " + gameId);

        DispatcherService.get(gameId).addListener(this);
    }

    private List<Question> getQuestions() {
        Question q1 = new Question(
                1,
                "Ce e o clasa?",
                Map.of(
                        "un prototip", true,
                        "o instanta", false,
                        "o variabila", false,
                        "un limbaj", false
                )
        );

        Question q2 = new Question(
                2,
                "Ce reprezinta int?",
                Map.of(
                        "un tip de data", true,
                        "o clasa", false,
                        "o variabila", false,
                        "un limbaj", false
                )
        );

        return List.of(q1, q2);
    }

    @Override
    public void onEvent(JoinEvent event) {
        SwingUtilities.invokeLater(() -> model.addElement(event.getPlayer()));
    }
}
