package Pertemuan5;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Latihan 2 - JLabel");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Halo, ini teks dari JLabel!", JLabel.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}
