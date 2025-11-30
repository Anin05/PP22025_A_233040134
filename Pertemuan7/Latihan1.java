package Pertemuan7 ;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Latihan1 extends JFrame {

    private JTextField txtNama, txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabPane;

    public Latihan1 () {
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabPane = new JTabbedPane();
        tabPane.add("Input Data", createInputPanel());
        tabPane.add("Daftar Nilai", createTablePanel());

        add(tabPane);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 10));

        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Nilai:"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        panel.add(new JLabel("Mata Kuliah:"));
        cmbMatkul = new JComboBox<>(new String[]{"Pemrograman", "Basis Data", "Bahasa Inggris"});
        panel.add(cmbMatkul);

        JButton btnSimpan = new JButton("Simpan Data");
        btnSimpan.addActionListener(e -> prosesSimpan());
        panel.add(btnSimpan);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> resetInput());
        panel.add(btnReset);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama", "Mata Kuliah", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnHapus = new JButton("Hapus Data");
        btnHapus.addActionListener(e -> hapusData());

        JPanel panelBawah = new JPanel();
        panelBawah.add(btnHapus);

        panel.add(panelBawah, BorderLayout.SOUTH);

        return panel;
    }

    private void prosesSimpan() {
        String nama = txtNama.getText().trim();
        String strNilai = txtNilai.getText().trim();
        String matkul = cmbMatkul.getSelectedItem().toString();

        // Validasi nama tidak kosong
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }

        // Validasi nama minimal 3 karakter
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal 3 karakter!");
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!");
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this, "Nilai harus 0 - 100!");
            return;
        }

        // SWITCH CASE menentukan grade
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9: grade = "A"; break;
            case 8: grade = "B"; break;
            case 7: grade = "C"; break;
            case 6: grade = "D"; break;
            default: grade = "E"; break;
        }

        // Tambahkan ke tabel
        tableModel.addRow(new Object[]{nama, matkul, nilai, grade});
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        resetInput();
    }

    private void resetInput() {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
    }

    private void hapusData() {
        int row = tableData.getSelectedRow();

        if (row > -1) {
            tableModel.removeRow(row);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Latihan1().setVisible(true);
        });
    }
}
