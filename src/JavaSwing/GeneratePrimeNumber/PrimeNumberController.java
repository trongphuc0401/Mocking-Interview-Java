package JavaSwing.GeneratePrimeNumber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrimeNumberController implements ActionListener {


    private  PrimeNumberView primeNumberView;
    private int N;


    public PrimeNumberController(PrimeNumberView primeNumberView) {
        this.primeNumberView = primeNumberView;

        primeNumberView.getGenerate().addActionListener(this);

        primeNumberView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });


    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String printIsPrime(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 2 ; i<= n ; i++) {
            if (isPrime(i)) {
              sb.append(i).append(" ");
            }
        }
        return sb.toString().trim();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (validateNumber()) {
            primeNumberView.getKetquArea().setText(printIsPrime(N));
        }else {
            primeNumberView.getKetquArea().setText("");
        }
    }


    public boolean validateNumber() {
        boolean isValid = false;

        try {
            if (!"".equals(primeNumberView.getTextFieldA().getText())){
                N  =Integer.parseInt(primeNumberView.getTextFieldA().getText());
                isValid = true;
            }else {
                JOptionPane.showMessageDialog(primeNumberView , "Số N không được bỏ trống.");
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(primeNumberView ,"Số N không hợp lệ");

        }
        return isValid;
    }

    public PrimeNumberView getPrimeNumberView() {
        return primeNumberView;
    }

    public void setPrimeNumberView(PrimeNumberView primeNumberView) {
        this.primeNumberView = primeNumberView;
    }


}
