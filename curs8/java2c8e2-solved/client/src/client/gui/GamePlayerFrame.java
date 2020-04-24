package client.gui;

import client.controller.GameController;
import lib.model.Answer;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GamePlayerFrame extends JFrame {
    private JPanel contentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;

    private Question currentQuestion;

    private String gameId;

    private Player player;

    public GamePlayerFrame(Question firstQuestion, String gameId, Player player) {
        this.currentQuestion = firstQuestion;
        this.gameId = gameId;
        this.player = player;

        initComponents();

        showQuestion(firstQuestion);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
    }

    private void showQuestion(Question q) {
        label1.setText(q.getContent());

        List<String> choices = new ArrayList<>(
                q.getChoices().keySet()
        );

        button1.setText(choices.get(0));
        button2.setText(choices.get(1));
        button3.setText(choices.get(2));
        button4.setText(choices.get(3));

        enableButtons(true);
    }

    private void initComponents() {
        ActionListener al = ev -> {
            enableButtons(false);
            JButton source = (JButton) ev.getSource();

            Answer answer = new Answer(
                    currentQuestion.getNumber(),
                    source.getText(),
                    gameId,
                    player
            );

            new Thread(() -> {
                Question next = GameController.getInstance().answerAndGetNext(answer);

                if (next != null) {
                    showQuestion(next);
                } else {
                    JOptionPane.showMessageDialog(null, "end");
                    dispose();
                    new MainFrame();
                }
            }).start();
        };

        button1.addActionListener(al);
        button2.addActionListener(al);
        button3.addActionListener(al);
        button4.addActionListener(al);
    }

    private void enableButtons(boolean enable) {
        button1.setEnabled(enable);
        button2.setEnabled(enable);
        button3.setEnabled(enable);
        button4.setEnabled(enable);
    }
}
