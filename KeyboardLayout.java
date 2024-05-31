import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardLayout extends JFrame implements ActionListener {

    private JTextField kotakTeks;
    private JButton[] tombolAngka;
    private JButton[] tombolOperator;
    private JButton tombolMod;
    private JButton tombolKeluar;

    public KeyboardLayout() {
        super("Keyboard Layout");

        kotakTeks = new JTextField();
        kotakTeks.setPreferredSize(new Dimension(300, 50));

        tombolAngka = new JButton[10];
        for (int i = 0; i < tombolAngka.length; i++) {
            tombolAngka[i] = new JButton(String.valueOf(i + 1));
            tombolAngka[i].addActionListener(this);
        }

        tombolOperator = new JButton[] {
            new JButton("+"),
            new JButton("="),
            new JButton("-"),
            new JButton("*"),
            new JButton("/")
        };
        for (JButton tombol : tombolOperator) {
            tombol.addActionListener(this);
        }

        tombolMod = new JButton("Mod");
        tombolMod.addActionListener(this);

        tombolKeluar = new JButton("Exit");
        tombolKeluar.addActionListener(this);

        JPanel panelKotakTeks = new JPanel();
        panelKotakTeks.add(kotakTeks);

        JPanel panelTombolAngka = new JPanel();
        panelTombolAngka.setLayout(new GridLayout(3, 4));
        for (JButton tombol : tombolAngka) {
            panelTombolAngka.add(tombol);
        }

        JPanel panelTombolOperator = new JPanel();
        panelTombolOperator.setLayout(new FlowLayout());
        for (JButton tombol : tombolOperator) {
            panelTombolOperator.add(tombol);
        }

        JPanel panelModKeluar = new JPanel();
        panelModKeluar.setLayout(new FlowLayout());
        panelModKeluar.add(tombolMod);
        panelModKeluar.add(tombolKeluar);

        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new BorderLayout());
        panelUtama.add(panelKotakTeks, BorderLayout.NORTH);
        panelUtama.add(panelTombolAngka, BorderLayout.CENTER);
        panelUtama.add(panelTombolOperator, BorderLayout.SOUTH);
        panelUtama.add(panelModKeluar, BorderLayout.EAST);
        getContentPane().add(panelUtama);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sumber = e.getSource();

        if (sumber instanceof JTextField) {
        } else if (sumber instanceof JButton) {
            JButton tombol = (JButton) sumber;
            String teks = tombol.getText();

            if (teks.equals("Mod")) {
            } else if (teks.equals("Keluar")) {
                System.exit(0);
            } else {
                kotakTeks.setText(kotakTeks.getText() + teks);
            }
        }
    }

    public static void main(String[] args) {
        new KeyboardLayout();
    }
}