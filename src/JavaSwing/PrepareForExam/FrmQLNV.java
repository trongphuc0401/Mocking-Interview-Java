package JavaSwing.PrepareForExam;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmQLNV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInput;
	private JTable tbNhanVien;
	private JTextField txtID;
	private JTextField txtTenNV;
	private JTextField txtNamSinh;
	private JTextField txtDiaChi;
	private JScrollPane scroll;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	NhanVienBusiness nhanVienBusiness = new NhanVienBusiness();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLNV frame = new FrmQLNV();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Xử lý tìm nhân viên (kỹ thuật tìm tương đối sử dụng LIKE trong truy vấn). Nếu
	 * chuỗi tìm kiếm là rỗng thì sẽ trả về toàn bộ danh sách nhân viên
	 */
	private void timNhanVien(String tenNV) {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
		model.setRowCount(0); //Xóa dữ liệu cũ đang có trong table
		
		try {
			listNhanVien = nhanVienBusiness.timNhanVien(tenNV);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (listNhanVien.isEmpty()) {
			JOptionPane.showInternalMessageDialog(null,  "Không tìm thấy nhân viên có tên: " + tenNV);
			return;
		}
	
		Object[] row;
		for (NhanVien nv : listNhanVien) {
			row = new Object[5];
			row[0] = nv.getId();
			row[1] = nv.getTennv();
			row[2] = nv.getNamsinh();
			row[3] = nv.getGioitinh();
			row[4] = nv.getDiachi();			
			model.addRow(row);			
		}
		tbNhanVien.setModel(model);
	}
	
	private void hienThiDanhNhanVien() {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		try {
			listNhanVien = nhanVienBusiness.layDanhSach();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
		model.setRowCount(0); //Xóa dữ liệu cũ đang có trong table
		Object[] row;
		for (NhanVien nv : listNhanVien) {
			row = new Object[5];
			row[0] = nv.getId();
			row[1] = nv.getTennv();
			row[2] = nv.getNamsinh();
			row[3] = nv.getGioitinh();
			row[4] = nv.getDiachi();			
			model.addRow(row);			
		}
		tbNhanVien.setModel(model);		
	}
	
	private void themNhanVien() {
		NhanVien newNV = new NhanVien();
		newNV.setTennv(txtTenNV.getText());
		newNV.setNamsinh(Integer.parseInt(txtNamSinh.getText().trim()));
		newNV.setGioitinh(rdNam.isSelected() ? (byte)1 : (byte)0);
		newNV.setDiachi(txtDiaChi.getText());
		int soNVDaThem = nhanVienBusiness.themNhanVien(newNV);
		if (soNVDaThem >0)
			JOptionPane.showInternalMessageDialog(null, "Thêm nhân viên thành công");
		else
			JOptionPane.showInternalMessageDialog(null, "Thêm nhân viên thất bại");
	}
	
	private void capNhatNhanVien() {
		NhanVien updateNV = new NhanVien();
		updateNV.setId(Integer.parseInt(txtID.getText()));
		updateNV.setTennv(txtTenNV.getText());
		updateNV.setNamsinh(Integer.parseInt(txtNamSinh.getText().trim()));
		updateNV.setGioitinh(rdNam.isSelected() ? (byte)1 : (byte)0);
		updateNV.setDiachi(txtDiaChi.getText());
		int soNVDaCapNhat = nhanVienBusiness.capNhatNhanVien(updateNV);
		if (soNVDaCapNhat >0)
			JOptionPane.showInternalMessageDialog(null, "Cập nhật nhân viên thành công");
		else
			JOptionPane.showInternalMessageDialog(null, "Cập nhật nhân viên thất bại");
	}
	
	private void xoaNhanVien() {
		NhanVien deleteNV = new NhanVien();
		deleteNV.setId(Integer.parseInt(txtID.getText()));
		
		int soNVDaDuocXoa = nhanVienBusiness.xoaNhanVien(deleteNV);
		if (soNVDaDuocXoa >0)
			JOptionPane.showInternalMessageDialog(null, "Xóa nhân viên thành công");
		else
			JOptionPane.showInternalMessageDialog(null, "Xóa nhân viên thất bại");
	}
	
	/**
	 * Create the frame.
	 */
	public FrmQLNV() {
		setTitle("Lab 4 - QLNV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTop = new JPanel();
		pnTop.setBorder(new TitledBorder(null, "Tìm thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTop.setBounds(10, 11, 425, 71);
		contentPane.add(pnTop);
		pnTop.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập họ tên: ");
		lblNewLabel.setBounds(48, 21, 75, 27);
		pnTop.add(lblNewLabel);
		
		txtInput = new JTextField();
		txtInput.setBounds(133, 28, 145, 20);
		pnTop.add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timNhanVien(txtInput.getText());
			}
		});
		btnTim.setBounds(288, 25, 89, 23);
		pnTop.add(btnTim);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnCenter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, new Color(0, 0, 255)));
		pnCenter.setBounds(10, 93, 425, 95);
		contentPane.add(pnCenter);		
		
		String colTieuDe[] = {"ID", "Họ Tên", "Năm Sinh", "Giới Tính", "Địa Chỉ"};
		DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
		tbNhanVien = new JTable(model);		
		tbNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel sm = tbNhanVien.getSelectionModel();
		sm.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && tbNhanVien.getSelectedRow() != -1) {
					 int selectedRow = tbNhanVien.getSelectedRow();
					 Object idValue = tbNhanVien.getValueAt(selectedRow, 0);
					 Object hoTenValue = tbNhanVien.getValueAt(selectedRow, 1);
					 Object namSinhValue = tbNhanVien.getValueAt(selectedRow, 2);
					 Object gioiTinhValue = tbNhanVien.getValueAt(selectedRow, 3);
					 Object diaChiValue = tbNhanVien.getValueAt(selectedRow, 4);
			         
					 txtID.setText(idValue.toString());
					 txtTenNV.setText(hoTenValue.toString());
					 txtNamSinh.setText(namSinhValue.toString());
					 int gioiTinh = Integer.parseInt(gioiTinhValue.toString());
					 if(gioiTinh == 1)
						rdNam.setSelected(true);
					 else 
						rdNu.setSelected(true);
					 txtDiaChi.setText(diaChiValue.toString());
				}
			}
		});
		scroll = new JScrollPane(tbNhanVien);
		scroll.setSize(425, 100);
		pnCenter.add(scroll);
		
		JPanel pnBottom = new JPanel();
		pnBottom.setBorder(new LineBorder(new Color(0, 64, 128)));
		pnBottom.setBounds(10, 200, 425, 188);
		contentPane.add(pnBottom);
		pnBottom.setLayout(null);
		
		JLabel lbID = new JLabel("ID:");
		lbID.setBounds(21, 11, 59, 14);
		pnBottom.add(lbID);
		
		txtID = new JTextField();
		txtID.setBounds(90, 11, 167, 20);
		pnBottom.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setBounds(21, 39, 59, 14);
		pnBottom.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(90, 39, 167, 20);
		pnBottom.add(txtTenNV);
		
		JLabel lbNgaySinh = new JLabel("Năm Sinh:");
		lbNgaySinh.setBounds(21, 67, 59, 14);
		pnBottom.add(lbNgaySinh);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(90, 67, 167, 20);
		pnBottom.add(txtNamSinh);
		
		JLabel lbGioiTinh = new JLabel("Giới Tính:");
		lbGioiTinh.setBounds(21, 95, 59, 14);
		pnBottom.add(lbGioiTinh);
		
		JLabel lbDiaChi = new JLabel("Địa Chỉ:");
		lbDiaChi.setBounds(21, 123, 59, 14);
		pnBottom.add(lbDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(90, 123, 167, 20);
		pnBottom.add(txtDiaChi);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhanVien();
			}
		});
		btnAdd.setBounds(10, 154, 68, 23);
		pnBottom.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatNhanVien();
			}
		});
		btnUpdate.setBounds(86, 154, 85, 23);
		pnBottom.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNhanVien();
			}
		});
		btnDelete.setBounds(180, 154, 58, 23);
		pnBottom.add(btnDelete);
		
		JButton btnGetAll = new JButton("Load All");
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDanhNhanVien();
			}
		});
		btnGetAll.setBounds(244, 154, 92, 23);
		pnBottom.add(btnGetAll);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hiển thị hộp thoại để xác nhận người dùng có thật sự muốn thoát chương trình hay không?
				int xacNhan = JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn thoát chương trình?","Xác nhận", JOptionPane.YES_NO_OPTION);
				if(xacNhan == JOptionPane.YES_OPTION) //Nếu người dùng chọn Yes == xác nhận thật sự muốn thoát chương trính
					System.exit(0); //Thoát chương trình
				}
		});
		btnExit.setBounds(346, 154, 70, 23);
		pnBottom.add(btnExit);
		
		rdNam = new JRadioButton("Nam");
		rdNam.setBounds(90, 94, 59, 23);
		pnBottom.add(rdNam);
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(161, 94, 59, 23);
		pnBottom.add(rdNu);
		ButtonGroup btgGioiTinh = new ButtonGroup();
		btgGioiTinh.add(rdNam);
		btgGioiTinh.add(rdNu);

		createExitHotKey();

		
	}
	private void createExitHotKey() {
		KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl T");

		InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = this.getRootPane().getActionMap();

		inputMap.put(keyStroke, "EXIT");
		actionMap.put("EXIT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
