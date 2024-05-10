package JavaSwing.GeneratePrimeNumber;

import javax.swing.*;

public class PrimeNumberView extends JFrame {
    private  JTextField textFieldA;
    private JTextArea ketquArea;
    private JButton generate;


    public PrimeNumberView() {


        // tạo các label thong tin
        setTitle("Java Swing - liet ke số nguyên ");
        JLabel labelSoN = new JLabel("Nhập N: ");

        // tạo label nhap lieu
        labelSoN.setBounds(20, 50, 100, 20);
        // tạo textField nhap lieu
        textFieldA = new JTextField();
        textFieldA.setBounds(80, 50, 40, 20);

        generate = new JButton("Generate");
        generate.setBounds(150, 50, 100, 20);
        // tạo label ket qua
        ketquArea = new JTextArea();
        ketquArea.setBounds(20, 100, 350, 100);

        // add jframe
        add(labelSoN);
        add(textFieldA);
        add(generate);
        add(ketquArea);
        // thiết lập bố cục (layout)
        setLayout(null);
        // thiết lập kích thước jframe
        setSize(450, 400);
        // hiển thị jframe
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

    public JTextArea getKetquArea() {
        return ketquArea;
    }

    public void setKetquArea(JTextArea ketquArea) {
        this.ketquArea = ketquArea;
    }

    public JButton getGenerate() {
        return generate;
    }

    public void setGenerate(JButton generate) {
        this.generate = generate;
    }
}
