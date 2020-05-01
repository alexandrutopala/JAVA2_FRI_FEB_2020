package client.gui;

import client.listener.DispatcherService;
import client.listener.JoinEventListener;
import client.service.GameController;
import lib.event.JoinEvent;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class CreateGameFrame extends JFrame implements JoinEventListener {
    private JList list1;
    private JButton incepeJocButton;
    private JLabel label1;
    private JPanel mainPanel;

    private DefaultListModel<Player> model;

    public CreateGameFrame() {

        String gameId = createGame();
        label1.setText(gameId);

        incepeJocButton.addActionListener(ev -> {
            dispose();

            Question q = GameController.getInstance().startGame(gameId);

            JOptionPane.showMessageDialog(null, q.getContent());

            // TODO: deschide fereastra cu intrebarea curenta
            new MainFrame();

            DispatcherService.getInstance(gameId)
                    .removeListener(this);
        });

        model = new DefaultListModel<>();
        list1.setModel(model);

        DispatcherService.getInstance(gameId)
                .addListener(this);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String createGame() {
        Question q = new Question(
                0,
                "Ce este o clasa?",
                Map.of(
                        "Un prototip", true,
                        "Un limbaj", false,
                        "Un identificator", false,
                        "Un tip de instanta", false
                )
        );

        return GameController.getInstance().createGame(List.of(q));
    }

    @Override
    public void accept(JoinEvent event) {
        Player player = event.getPlayer();

        model.addElement(player);
    }
}
