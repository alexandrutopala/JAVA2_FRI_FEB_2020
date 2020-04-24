package client.gui;

import client.controller.GameController;
import client.dispatcher.AnswerEventListener;
import client.dispatcher.DispatcherService;
import lib.event.AnswerEvent;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameOwnerFrame extends JFrame implements AnswerEventListener {
    private JPanel contentPane;
    private JList list1;
    private JButton altaIntrebareButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    private DefaultListModel<Player> model;

    private String gameId;

    public GameOwnerFrame(Question firstQuestion, String gameId) {
        this.gameId = gameId;

        initComponents();

        showQuestion(firstQuestion);
        DispatcherService.get(gameId).addListener(this);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        altaIntrebareButton.addActionListener(e -> {
            model.clear();
            Question question = GameController.getInstance()
                    .nextQuestion(gameId);

            if (question != null) {
                showQuestion(question);
            } else {
                DispatcherService.get(gameId).removeListener(this);
                JOptionPane.showMessageDialog(null, "end");

                GameController.getInstance().endGame(gameId);

                dispose();

                new MainFrame();
            }
        });

        model = new DefaultListModel<>();

        list1.setModel(model);
    }

    private void showQuestion(Question q) {
        label1.setText(q.getContent());

        List<String> choices = new ArrayList<>(
                q.getChoices().keySet()
        );

        label2.setText(choices.get(0));
        label3.setText(choices.get(1));
        label4.setText(choices.get(2));
        label5.setText(choices.get(3));
    }

    @Override
    public void onEvent(AnswerEvent event) {
        SwingUtilities.invokeLater(() -> model.addElement(event.getPlayer()));
    }
}
