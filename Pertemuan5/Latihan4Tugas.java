package Pertemuan5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan4Tugas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Latihan 4 - BorderLayout (Tugas)");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Belum ada tombol ditekan", JLabel.CENTER);
        JButton btnNorth = new JButton("NORTH");
        JButton btnSouth = new JButton("SOUTH");
        JButton btnEast = new JButton("EAST");
        JButton btnWest = new JButton("WEST");

        frame.add(label, BorderLayout.CENTER);
        frame.add(btnNorth, BorderLayout.NORTH);
        frame.add(btnSouth, BorderLayout.SOUTH);
        frame.add(btnEast, BorderLayout.EAST);
        frame.add(btnWest, BorderLayout.WEST);

        // Tambahkan aksi untuk setiap tombol
        btnNorth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol NORTH ditekan");
            }
        });

        btnSouth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol SOUTH ditekan");
            }
        });

        btnEast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol EAST ditekan");
            }
        });

        btnWest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol WEST ditekan");
            }
        });

        frame.setVisible(true);
    }
}
