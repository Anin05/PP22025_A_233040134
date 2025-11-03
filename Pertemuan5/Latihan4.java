package Pertemuan5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Latihan 4 - BorderLayout");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Belum ada tombol ditekan", JLabel.CENTER);
        JButton btnNorth = new JButton("NORTH");
        JButton btnSouth = new JButton("SOUTH");

        frame.add(label, BorderLayout.CENTER);
        frame.add(btnNorth, BorderLayout.NORTH);
        frame.add(btnSouth, BorderLayout.SOUTH);

        btnSouth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol SOUTH ditekan");
            }
        });

        frame.setVisible(true);
    }
}
