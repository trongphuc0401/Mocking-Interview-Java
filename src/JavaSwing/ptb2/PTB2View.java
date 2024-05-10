package JavaSwing.ptb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTB2View extends JFrame {

    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JButton btnKetQua;

    private JButton btnXoa;

    private JButton btnThoat;
    private JTextArea textArea;

    public PTB2View() {
        setTitle("^..^");

        JPanel header = new JPanel(new BorderLayout());
        JLabel labelHangSo = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
        labelHangSo.setBounds(130, 20, 300, 30);

        header.add(labelHangSo,BorderLayout.NORTH);
        // tạo các label hằng số
        header.setBackground(Color.cyan);

        JLabel labelHangSoA = new JLabel("Nhập a:");
        labelHangSoA.setBounds(20, 70, 60, 20);

        JLabel labelHangSoB = new JLabel("Nhập b:");
        labelHangSoB.setBounds(20, 110, 60, 20);

        JLabel labelHangSoC = new JLabel("Nhập c:");
        labelHangSoC.setBounds(20, 150, 60, 20);


        textFieldA = new JTextField();
        textFieldB = new JTextField();
        textFieldC = new JTextField();
        textFieldA.setBounds(80, 70, 300, 20);
        textFieldB.setBounds(80, 110, 300, 20);
        textFieldC.setBounds(80, 150, 300, 20);


        btnKetQua = new JButton("Kết Quả");
        btnKetQua.setBounds(60, 200, 80, 30);

        btnXoa = new JButton("Xóa");
        btnXoa.setBounds(160, 200, 80, 30);
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               textFieldA.setText("");
               textFieldB.setText("");
               textFieldC.setText("");
               textArea.setText("");
            }
        });


        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(260, 200, 80, 30);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        textArea = new JTextArea();
        textArea.setBounds(20, 240, 380, 150);


        add(labelHangSo);
        add(labelHangSoA);
        add(textFieldA);
        add(labelHangSoB);
        add(textFieldB);
        add(labelHangSoC);
        add(textFieldC);
        add(btnKetQua);
        add(btnXoa);
        add(btnThoat);
        add(textArea);
        add(header);

        setLayout(null);
        setSize(430, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }



    public JTextField getTextFieldA() {
        return textFieldA;
    }

    public void setTextFieldA(JTextField textFieldA) {
        this.textFieldA = textFieldA;
    }

    public JTextField getTextFieldB() {
        return textFieldB;
    }

    public void setTextFieldB(JTextField textFieldB) {
        this.textFieldB = textFieldB;
    }

    public JTextField getTextFieldC() {
        return textFieldC;
    }

    public void setTextFieldC(JTextField textFieldC) {
        this.textFieldC = textFieldC;
    }

    public JButton getBtnKetQua() {
        return btnKetQua;
    }

    public void setBtnKetQua(JButton btnKetQua) {
        this.btnKetQua = btnKetQua;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
