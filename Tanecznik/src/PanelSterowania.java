import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelSterowania extends JFrame{
    private JButton hamulecButton;
    private JButton OnButton;
    private JButton gazButton;
    private JButton biegWyzejButton;
    private JLabel predkoscLabel;
    private JButton Offbutton;
    private JLabel obrotyLabel;
    private JLabel biegLabel;
    private JLabel paliwoLabel;
    private JLabel olejLabel;
    private javax.swing.JPanel JPanel;
    private JButton stacjaButton;
    private JButton biegNizejButton;


    public static void main(String[] args)
    {
        PanelSterowania PanelSterowania = new PanelSterowania();
        PanelSterowania.setVisible(true);
        BazaDanych.pobierzStanPaliwa();
        BazaDanych.pobierzStanOleju();
    }

    public void Parametry()
    {
        predkoscLabel.setText("Prędkość: " + samochod.getPredkosc() + " km/h");
        obrotyLabel.setText("Obroty silnika:" + samochod.getObrotySilnika());
        paliwoLabel.setText("Ilość paliwa: "+ samochod.getBak() + " l");
        olejLabel.setText("Ilość oleju: " + samochod.getOlej() + " %");
        biegLabel.setText("Bieg: " + samochod.getBieg());
    }

    private Samochod samochod = new Samochod();


    public PanelSterowania()
    {
        super("Panel sterowania samochodem");
        this.setContentPane(this.JPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 400;
        this.setSize(width, height);

       


        OnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.odpalSamochod();
                Parametry();
            }
        });

        Offbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.zgasSamochod();
            }
        });

        gazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.przyspiesz();
                Parametry();

            }
        });

        hamulecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               samochod.hamuj();
                Parametry();
            }
        });


        biegWyzejButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.biegWyzej();
                Parametry();
            }
        });
        biegNizejButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.biegNizej();
                Parametry();
            }
        });
        stacjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                samochod.zapiszStan();
                Stacja Stacja = new Stacja();
                Stacja.setVisible(true);
                dispose();

            }
        });
    }



    }
