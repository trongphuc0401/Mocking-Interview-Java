package JavaSwing.Caculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JTextField inputA, inputB, resultField;
    private JButton solveButton, clearButton, exitButton;
    private JRadioButton addRadio, subtractRadio, multiplyRadio, divideRadio;
    private ButtonGroup operationGroup;

    public CalculatorView() {
        setTitle("Cộng Trừ Nhân Chia");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tạo các thành phần giao diện
        JLabel chooseTaskLabel = new JLabel("Chọn tác vụ");
        chooseTaskLabel.setBounds(20, 20, 100, 20);
        add(chooseTaskLabel);

        solveButton = new JButton("Giải");
        solveButton.setBounds(20, 50, 80, 20);
        add(solveButton);

        JLabel calculationLabel = new JLabel("Tính toán");
        calculationLabel.setBounds(20, 90, 100, 20);
        add(calculationLabel);

        JLabel labelA = new JLabel("Nhập a: ");
        labelA.setBounds(10, 120, 100, 20);
        add(labelA);
        inputA = new JTextField();
        inputA.setBounds(60, 120, 100, 20);
        add(inputA);


        JLabel labelB = new JLabel("Nhập b: ");
        labelB.setBounds(200, 120, 100, 20);
        add(labelB);
        inputB = new JTextField();
        inputB.setBounds(250, 120, 100, 20);
        add(inputB);

        JLabel operationLabel = new JLabel("Phép toán");
        operationLabel.setBounds(20, 150, 100, 20);
        add(operationLabel);

        addRadio = new JRadioButton("Cộng");
        addRadio.setBounds(20, 180, 80, 20);
        subtractRadio = new JRadioButton("Trừ");
        subtractRadio.setBounds(110, 180, 80, 20);
        multiplyRadio = new JRadioButton("Nhân");
        multiplyRadio.setBounds(200, 180, 80, 20);
        divideRadio = new JRadioButton("Chia");
        divideRadio.setBounds(290, 180, 80, 20);

        operationGroup = new ButtonGroup();
        operationGroup.add(addRadio);
        operationGroup.add(subtractRadio);
        operationGroup.add(multiplyRadio);
        operationGroup.add(divideRadio);

        add(addRadio);
        add(subtractRadio);
        add(multiplyRadio);
        add(divideRadio);

        JLabel resultLabel = new JLabel("Kết quả:");
        resultLabel.setBounds(20, 210, 100, 20);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(120, 210, 250, 20);
        resultField.setEditable(false);
        add(resultField);

        clearButton = new JButton("Xóa");
        clearButton.setBounds(160, 240, 80, 20);
        add(clearButton);

        exitButton = new JButton("Thoát");
        exitButton.setBounds(300, 240, 80, 20);
        add(exitButton);

        JPanel pnlColors = new JPanel();
        pnlColors.setBackground(Color.PINK);
        JLabel lblBlue = new JLabel(" ");
        lblBlue.setOpaque(true);
        lblBlue.setBackground(Color.BLUE);
        JLabel lblRed = new JLabel(" ");
        lblRed.setOpaque(true);
        lblRed.setBackground(Color.RED);
        JLabel lblYellow = new JLabel(" ");
        lblYellow.setOpaque(true);
        lblYellow.setBackground(Color.YELLOW);
        pnlColors.add(lblBlue);
        pnlColors.add(lblRed);
        pnlColors.add(lblYellow);

        Container container = getContentPane();

        container.add(pnlColors, BorderLayout.SOUTH);
        // Thêm sự kiện cho các nút
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Thực hiện tính toán tại đây
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputA.setText("");
                inputB.setText("");
                resultField.setText("");
                operationGroup.clearSelection();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JTextField getInputA() {
        return inputA;
    }

    public void setInputA(JTextField inputA) {
        this.inputA = inputA;
    }

    public JTextField getInputB() {
        return inputB;
    }

    public void setInputB(JTextField inputB) {
        this.inputB = inputB;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public void setResultField(JTextField resultField) {
        this.resultField = resultField;
    }

    public JButton getSolveButton() {
        return solveButton;
    }

    public void setSolveButton(JButton solveButton) {
        this.solveButton = solveButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JRadioButton getAddRadio() {
        return addRadio;
    }

    public void setAddRadio(JRadioButton addRadio) {
        this.addRadio = addRadio;
    }

    public JRadioButton getSubtractRadio() {
        return subtractRadio;
    }

    public void setSubtractRadio(JRadioButton subtractRadio) {
        this.subtractRadio = subtractRadio;
    }

    public JRadioButton getMultiplyRadio() {
        return multiplyRadio;
    }

    public void setMultiplyRadio(JRadioButton multiplyRadio) {
        this.multiplyRadio = multiplyRadio;
    }

    public JRadioButton getDivideRadio() {
        return divideRadio;
    }

    public void setDivideRadio(JRadioButton divideRadio) {
        this.divideRadio = divideRadio;
    }

    public ButtonGroup getOperationGroup() {
        return operationGroup;
    }

    public void setOperationGroup(ButtonGroup operationGroup) {
        this.operationGroup = operationGroup;
    }
}
