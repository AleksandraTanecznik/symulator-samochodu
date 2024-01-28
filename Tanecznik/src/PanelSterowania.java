import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSterowania extends JFrame{
    private JButton hamulecButton;
    private JButton OnButton;
    private JButton gazButton;
    private JButton biegButton;
    private JLabel predkoscLabel;
    private JButton Offbutton;
    private JLabel obrotyLabel;
    private JLabel biegLabel;
    private JLabel paliwoLabel;
    private JLabel olejLabel;
    private javax.swing.JPanel JPanel;
    private JButton stacjaButton;


    public static void main(String[] args)
    {
        PanelSterowania PanelSterowania = new PanelSterowania();
        PanelSterowania.setVisible(true);
    }

    public void Parametry()
    {
        predkoscLabel.setText("Prędkość: " + samochod.getPredkosc());
        obrotyLabel.setText("Obroty silnika:" + samochod.getObrotySilnika());
        paliwoLabel.setText("Ilość paliwa: "+ samochod.getBak());
        olejLabel.setText("Ilość oleju:" + samochod.getOlej());
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

        biegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.zmienBieg(3);
            }
        });
    }
}
