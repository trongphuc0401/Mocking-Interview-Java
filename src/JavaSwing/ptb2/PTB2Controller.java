package JavaSwing.ptb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PTB2Controller implements ActionListener {


    private PTB2View view;
    private float hangsoA;
    private float hangsoB;
    private float hangsoC;

    public PTB2Controller(PTB2View view) {
        this.view = view;

        view.getBtnKetQua().addActionListener(this);

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    private static String giaiPhuongTrinhBac2(float a , float b ,  float c) {
        String ketqua =  null;

        if (a == 0) {
            if (b == 0) {
                ketqua = "Phương trình vô nghiệm";

            }else {
                ketqua = "Phương trình có một nghiệm: " + "x = " + (-c / b);
            }
        }

        float delta = b*b - 4*a*c;

        float x1,x2;
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));

            ketqua = "Phương trình có 2 nghiệm là: " + "\nx1 = " + x1
                    + "\nx2 = " + x2;
        }else if (delta == 0){
            x1 = (-b / (2 * a));
            ketqua = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;

        }else  {
            ketqua = "Phương trình vô nghiệm!";
        }
        return ketqua;

    }

    public boolean validateHangSoA() {
        boolean isValid = false;

        try {
            if (!"".equals(view.getTextFieldA().getText())){
                hangsoA  =Float.parseFloat(view.getTextFieldA().getText());
                isValid = true;
            }else {
                JOptionPane.showMessageDialog(view , "Hằng số không được bỏ trống.");
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view ,"Hằng số không hợp lệ");

        }
        return isValid;
    }

    public boolean validateHangSoB() {
        boolean isValid = false;

        try {
            if (!"".equals(view.getTextFieldB().getText())){
                hangsoB  =Float.parseFloat(view.getTextFieldB().getText());
                isValid = true;
            }else {
                JOptionPane.showMessageDialog(view , "Hằng số không được bỏ trống.");
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view ,"Hằng số không hợp lệ");

        }
        return isValid;
    }

    public boolean validateHangSoC() {
        boolean isValid = false;

        try {
            if (!"".equals(view.getTextFieldC().getText())){
                hangsoC  =Float.parseFloat(view.getTextFieldC().getText());
                isValid = true;
            }else {
                JOptionPane.showMessageDialog(view , "Hằng số không được bỏ trống.");
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view ,"Hằng số không hợp lệ");

        }
        return isValid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (validateHangSoA() && validateHangSoB() && validateHangSoC()) {
            view.getTextArea().setText(giaiPhuongTrinhBac2(hangsoA,hangsoB,hangsoC));
        }else {
            view.getTextArea().setText("");
        }
    }
    public PTB2View getView() {
        return view;
    }

    public void setView(PTB2View view) {
        this.view = view;
    }
}
