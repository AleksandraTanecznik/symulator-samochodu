import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stacja extends JFrame{
    private JButton paliwoButton;
    private JButton zatankujButton;
    private JButton Samochodbutton;
    private javax.swing.JPanel JPanel;
    private JLabel komunikat1;
    private JLabel komunikat2;


    public Stacja() {
        super("Stacja benzynowa");
        this.setContentPane(this.JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 400;
        this.setSize(width, height);
        this.setVisible(true);


        zatankujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BazaDanych.zapiszStan(55,100);
                komunikat1.setText("Zatankowano do pełna oraz dolano oleju");
                komunikat2.setText("Olej: 100%,\n" +
                        " Ilość paliwa w baku: 55l");
            }
        });



        Samochodbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSterowania panel = new PanelSterowania();
                panel.setVisible(true);
                dispose();
            }
        });
    }
}
