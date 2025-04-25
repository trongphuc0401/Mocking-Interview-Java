package JavaSwing.PrepareForExam;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienBusiness {

	public List<NhanVien> timNhanVien(String tenNhanVien) {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		Connection conn = null;
		try {
			conn = DataProvider.ketNoi();
			String strSQL = "SELECT * FROM NHANVIEN WHERE TenNV LIKE ?";
			System.out.println(strSQL);
			PreparedStatement ps = conn.prepareStatement(strSQL);			
			ps.setString(1, "%" + tenNhanVien + "%");		
			ResultSet rs = ps.executeQuery();
			NhanVien objNV = null;
			while(rs.next()) {
				objNV = new NhanVien();
				objNV.setId(rs.getInt("id"));
				objNV.setTennv(rs.getString("tennv"));
				objNV.setNamsinh(rs.getInt("namsinh"));
				objNV.setGioitinh(rs.getByte("gioitinh"));
				objNV.setDiachi(rs.getString("diachi"));
				listNhanVien.add(objNV);
			}
		} 
		catch (SQLException e) {
			System.out.println("Lỗi hệ thống: " + e.getMessage());
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				System.out.println("Lỗi hệ thống: " + ex.getMessage());
			}
		}
		return listNhanVien;
	}
	
	
	public List<NhanVien> layDanhSach() {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		Connection conn = null;
		try {
			conn = DataProvider.ketNoi();
			String strSQL = "SELECT * FROM NHANVIEN";
			Statement statement = conn.createStatement();			
			ResultSet rs = statement.executeQuery(strSQL);
			NhanVien objNV = null;
			while(rs.next()) {
				objNV = new NhanVien();
				objNV.setId(rs.getInt("id"));
				objNV.setTennv(rs.getString("tennv"));
				objNV.setNamsinh(rs.getInt("namsinh"));
				objNV.setGioitinh(rs.getByte("gioitinh"));
				objNV.setDiachi(rs.getString("diachi"));
				listNhanVien.add(objNV);
				Validation.erroSystem(conn);
			}
		} 
		catch (SQLException e) {
			System.out.println("SQLException. Lỗi hệ thống: " + e.getMessage());
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				System.out.println("Lỗi hệ thống: " + ex.getMessage());
			}
		}
		return listNhanVien;
	}
	
	public int themNhanVien(NhanVien nv){
		int soNhanVienDaThem =0;
		
		Connection conn = null;
		try {

			conn = DataProvider.ketNoi();
			String strSQL = "INSERT INTO NHANVIEN (TenNV, NamSinh, GioiTinh, DiaChi) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(strSQL);			
			ps.setString(1, nv.getTennv());
			ps.setInt(2, nv.getNamsinh());
			ps.setByte(3, nv.getGioitinh());
			ps.setString(4, nv.getDiachi());
			//System.out.println( nv.getTennv() + "-" + nv.getNamsinh()+ "-" + nv.getGioitinh()+ "-" +nv.getDiachi());
			//System.out.println(strSQL);

			soNhanVienDaThem = ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println("SQLException. Lỗi hệ thống: " + e.getMessage());
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				System.out.println("Lỗi hệ thống: " + ex.getMessage());
			}
		}
		return soNhanVienDaThem;
	}
	
	public int capNhatNhanVien(NhanVien nv){
		int soNhanVienDaCapNhat =0;
		Connection conn = null;
		try {
			conn = DataProvider.ketNoi();
			String strSQL = "UPDATE NHANVIEN SET TenNV=?, NamSinh=?, GioiTinh=?, DiaChi=? WHERE ID =?";
			PreparedStatement ps = conn.prepareStatement(strSQL);			
			ps.setString(1, nv.getTennv());
			ps.setInt(2, nv.getNamsinh());
			ps.setByte(3, nv.getGioitinh());
			ps.setString(4, nv.getDiachi());
			ps.setInt(5, nv.getId());			
			soNhanVienDaCapNhat = ps.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("Lỗi hệ thống: " + e.getMessage());
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				System.out.println("Lỗi hệ thống: " + ex.getMessage());
			}
		}
		return soNhanVienDaCapNhat;
	}
	
	public int xoaNhanVien(NhanVien nv){
		int soNhanVienDaBiXoa =0;
		Connection conn = null;

		try {
			conn = DataProvider.ketNoi();
			String strSQL = "DELETE FROM NHANVIEN WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(strSQL);			
			ps.setInt(1, nv.getId());
			
			soNhanVienDaBiXoa = ps.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("SQLException. Lỗi hệ thống: " + e.getMessage());
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				System.out.println("Lỗi hệ thống: " + ex.getMessage());
			}
		}
		return soNhanVienDaBiXoa;
	}
	
}
