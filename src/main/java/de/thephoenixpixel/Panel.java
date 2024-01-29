package de.thephoenixpixel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame{
    private JPanel panel;
    private JButton rechnenButton;
    private JTextField zahl1Field;
    private JTextField zahl2Field;
    private JButton clearButton;
    private JLabel outputField;
    private JComboBox rechenOperationenBox1;

    public Panel() {
        setTitle("TaschenRechner");
        setContentPane(panel);
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechnen();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl1Field.setText("");
                zahl2Field.setText("");
                outputField.setText("Ergebniss: 0");
            }
        });
    }

    public void rechnen() {
        int zahl1 = Integer.parseInt(zahl1Field.getText());
        int zahl2 = Integer.parseInt(zahl2Field.getText());
        int ergebniss = 0;
        switch (rechenOperationenBox1.getModel().getSelectedItem().toString()) {
            case "+":
                ergebniss = Mathe.addieren(zahl1, zahl2);
                break;
            case "-":
                ergebniss = Mathe.subtrahieren(zahl1, zahl2);
                break;
            case "*":
                ergebniss = Mathe.multiplizieren(zahl1, zahl2);
                break;
            case "/":
                ergebniss = Mathe.dividieren(zahl1, zahl2);
                break;
            default:
                System.out.println("Error kein gültiges Rechen Zeichen");
                break;
        }
        outputField.setText("Ergebniss: " + ergebniss);
    }

}
