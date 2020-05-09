package springlogin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class lienhe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "hoten", length = 45)
	private String hoten;
	@Column(name = "diachi", length = 100)
	private String diachi;
	@Column(name = "dienthoai", length = 11)
	private String dienthoai;
	@Column(name = "email", length = 45)
	private String email;
	@Column(name = "mucdichgui", length = 45)
	private String mucdichgui;
	@Column(name = "tieudegui", length = 100)
	private String tieudegui;
	@Column(name = "noidung", length = 500)
	private String noidung;
	@Column(name = "ngay")
	private String ngay;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMucdichgui() {
		return mucdichgui;
	}
	public void setMucdichgui(String mucdichgui) {
		this.mucdichgui = mucdichgui;
	}
	public String getTieudegui() {
		return tieudegui;
	}
	public void setTieudegui(String tieudegui) {
		this.tieudegui = tieudegui;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
}
