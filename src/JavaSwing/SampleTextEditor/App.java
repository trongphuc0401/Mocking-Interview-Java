package JavaSwing.SampleTextEditor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    private JPanel panel1;
    private JComboBox<Integer> comboBox2;
    private JButton greenButton;
    private JButton redButton;
    private JButton blueButton;
    private JButton bButton;
    private JButton iButton;
    private JButton uButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton centerButton;
    private JTextArea textArea1;
    private JButton fileButton;

    public App() {
        Integer[] fontSizes = {1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15 ,16, 17, 18,19, 20,21,22,23, 24,25,26,27, 28,29,30,31,32,33,34,35,36,37,38,39,40};
        for (Integer size : fontSizes) {
            comboBox2.addItem(size);
        }
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedSize = (int) comboBox2.getSelectedItem();
                Font currentFont = textArea1.getFont();
                Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), selectedSize);
                textArea1.setFont(newFont);
            }
        });
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setForeground(Color.BLUE);
            }
        });
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setForeground(Color.RED);
            }
        });
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setForeground(Color.GREEN);
            }
        });
        iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = textArea1.getFont();
                int newStyle = currentFont.getStyle() ^ Font.ITALIC;
                Font newFont = new Font(currentFont.getFontName(), newStyle, currentFont.getSize());
                textArea1.setFont(newFont);
            }
        });
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = textArea1.getFont();
                int newStyle = currentFont.getStyle() ^ Font.BOLD;
                Font newFont = new Font(currentFont.getFontName(), newStyle, currentFont.getSize());
                textArea1.setFont(newFont);
            }
        });
        uButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = textArea1.getFont();
                Map<TextAttribute, Object> attributes = new HashMap<>(currentFont.getAttributes());

                // Kiểm tra xem font hiện tại đã là gạch dưới hay chưa, nếu chưa thì đặt là gạch dưới, nếu rồi thì bỏ gạch dưới
                if (TextAttribute.UNDERLINE_ON.equals(attributes.get(TextAttribute.UNDERLINE))) {
                    attributes.put(TextAttribute.UNDERLINE, -1);
                } else {
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                }

                Font newFont = currentFont.deriveFont(attributes);
                textArea1.setFont(newFont);
            }
        });


        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setAlignmentX(Component.LEFT_ALIGNMENT);
            }
        });

        centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setAlignmentX(Component.RIGHT_ALIGNMENT);
            }
        });
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popupMenu = new JPopupMenu();
                // Tạo ImageIcon với kích thước đã chỉ định
                ImageIcon newIcon = new ImageIcon("./JavaSwing/SampleTextEditor/assect/img/new.jpg");
                newIcon.setImage(newIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                JMenuItem newItem = new JMenuItem("New", newIcon);

                newItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea1.setText("");
                    }
                });
                ImageIcon saveIcon = new ImageIcon("save_icon.png");
                saveIcon.setImage(saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                JMenuItem saveItem = new JMenuItem("Save", saveIcon);

                saveItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String content = textArea1.getText();

                        // Lấy đường dẫn mà người dùng muốn lưu tệp
                        JFileChooser fileChooser = new JFileChooser();
                        int result = fileChooser.showSaveDialog(null);

                        if (result == JFileChooser.APPROVE_OPTION) {
                            // Lấy đường dẫn đã chọn
                            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                            try {
                                // Tạo một đối tượng BufferedWriter để ghi vào tệp
                                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                                // Ghi nội dung từ textField vào tệp
                                writer.write(content);

                                // Đóng luồng ghi
                                writer.close();

                                // Thông báo khi lưu thành công
                                JOptionPane.showMessageDialog(null, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } catch (IOException ex) {
                                // Xử lý ngoại lệ nếu có lỗi khi ghi tệp
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                });
                ImageIcon openIcon = new ImageIcon("open_icon.png");
                openIcon.setImage(openIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                JMenuItem openItem = new JMenuItem("Open", openIcon);

                openItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Select a .txt file");
                        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

                        // Xử lý khi người dùng chọn một tệp
                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            try {
                                // Đọc nội dung từ tệp .txt và hiển thị trong JTextArea
                                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                                StringBuilder content = new StringBuilder();
                                String line;
                                while ((line = reader.readLine()) != null) {
                                    content.append(line).append("\n");
                                }
                                reader.close();
                                textArea1.setText(content.toString());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                // Tạo một JPopupMenu và thêm openItem vào

                ImageIcon exitIcon = new ImageIcon("open.jpg");
                exitIcon.setImage(exitIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                JMenuItem exitItem = new JMenuItem("Exit", exitIcon);

                popupMenu.add(newItem);
                popupMenu.add(saveItem);
                popupMenu.add(openItem);
                popupMenu.add(exitItem);

                popupMenu.show(fileButton, 0, fileButton.getHeight());
            }
        });

    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Sample Text Editor");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
