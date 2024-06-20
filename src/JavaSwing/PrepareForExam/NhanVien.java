package JavaSwing.PrepareForExam;




public class NhanVien {
	private int id;
	private String tennv;
	private int namsinh;
	private byte gioitinh;
	private String diachi;

	public NhanVien(int id, String diachi, byte gioitinh, String tennv, int namsinh) {
		this.id = id;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.tennv = tennv;
		this.namsinh = namsinh;
	}

	public NhanVien() {};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public byte getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(byte gioitinh) {
		this.gioitinh = gioitinh;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	@Override
	public String toString() {
		return "NhanVien{" +
				"id=" + id +
				", tennv='" + tennv + '\'' +
				", namsinh=" + namsinh +
				", gioitinh=" + gioitinh +
				", diachi='" + diachi + '\'' +
				'}';
	}
}
