package Pertemuan5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Latihan 3 - Tombol dan Aksi");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gunakan layout agar label & tombol tidak saling timpa
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Belum ada aksi");
        JButton button = new JButton("Klik Saya!");

        // Tambahkan aksi ke tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
