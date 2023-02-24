package dto;

public class Studentform 
{
	private String fullname;
	private String enrollno;
	private String email;
	private String mobileno;
	private String branch;
	private String sem;
	
	
	public Studentform(String fullname, String enrollno, String email, String mobileno, String branch, String sem) {
		super();
		this.fullname = fullname;
		this.enrollno = enrollno;
		this.email = email;
		this.mobileno = mobileno;
		this.branch = branch;
		this.sem = sem;
	}
	
	public Studentform() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEnrollno() {
		return enrollno;
	}
	public void setEnrollno(String enrollno) {
		this.enrollno = enrollno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	
}
