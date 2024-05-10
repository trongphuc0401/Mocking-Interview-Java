package JavaSwing.Caculate;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        view.getSolveButton().addActionListener(e -> performCalculation());
    }

    private void performCalculation() {
        double a, b, result;
        try {
            a = Double.parseDouble(view.getInputA().getText());
            b = Double.parseDouble(view.getInputB().getText());
        } catch (NumberFormatException ex) {
            view.getResultField().setText("Lỗi: Giá trị nhập vào không hợp lệ");
            return;
        }

        if (view.getAddRadio().isSelected()) {
            result = a + b;
            view.getResultField().setText(String.valueOf(result));
        } else if (view.getSubtractRadio().isSelected()) {
            result = a - b;
            view.getResultField().setText(String.valueOf(result));
        } else if (view.getMultiplyRadio().isSelected()) {
            result = a * b;
            view.getResultField().setText(String.valueOf(result));
        } else if (view.getDivideRadio().isSelected()) {
            if (b == 0) {
                view.getResultField().setText("Lỗi: Không thể chia cho 0");
            } else {
                result = a / b;
                view.getResultField().setText(String.valueOf(result));
            }
        } else {
            view.getResultField().setText("Lỗi: Chưa chọn phép tính");
        }
    }
}