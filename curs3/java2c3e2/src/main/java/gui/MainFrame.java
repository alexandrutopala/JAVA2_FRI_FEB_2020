package gui;

import entities.Pisica;
import service.PisicaService;
import service.ServiceProvider;

import javax.swing.*;

public class MainFrame {
    private JTextField textField1;
    private JButton adaugaButton;
    private JTextField textField2;
    private JButton cautaButton;
    private JTextField textField3;
    private JButton stergeButton;
    private JTextField textField4;
    private JTextField textField5;
    private JButton modificaButton;
    private JTextField textField6;
    private JButton actualizeazaButton;
    private JPanel mainPanel;

    private PisicaService pisicaService;
    private Pisica pisica;

    public MainFrame() {

        pisicaService = ServiceProvider.getInstance().get(PisicaService.class);
        // PisicaService.class <=> Class<PisicaService>

        adaugaButton.addActionListener(ev -> {
            String nume = textField1.getText();

            Pisica pisica = new Pisica();

            pisica.setNume(nume);

            pisicaService.persist(pisica);
        });

        cautaButton.addActionListener(ev -> {
            int id = Integer.parseInt(textField2.getText());


            Pisica p;

            if (pisica != null && pisica.getId() == id) {
                p = pisica;
            } else {
                p = pisicaService.find(id);
                pisica = p;
            }

            System.out.println(p);
        });

        stergeButton.addActionListener(ev -> {
            int id = Integer.parseInt(textField3.getText());

            pisicaService.remove(id);
        });

        modificaButton.addActionListener(ev -> {
            int id = Integer.parseInt(textField4.getText());
            String nume = textField5.getText();

            pisicaService.modifica(id, nume);
        });

        actualizeazaButton.addActionListener(ev -> {
            pisicaService.refresh(pisica);
        });
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
