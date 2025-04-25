package JavaSwing.Lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class quanlysach {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton thêmButton;
    private JButton xóaRỗngButton;
    private JButton sửaButton;
    private JButton xóaButton;
    private JComboBox comboBox1;
    private JTable table1;

    public quanlysach() {

        String[] columnNames = {"First Name", "Last Name", "Age"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table1.setModel(model);

        table1.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                try (BufferedReader br = new BufferedReader(new FileReader("src/JavaSwing/Lab4/data.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        model.addRow(data);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new quanlysach().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
