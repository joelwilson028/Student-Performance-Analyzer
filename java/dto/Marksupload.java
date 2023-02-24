package dto;

public class Marksupload 
{
	private String name;
	private String enrollno;
	private String subject;
	private double marksob;
	private double totalmarks;
	
	
	
	public Marksupload(String name, String enrollno, String subject, double marksob, double totalmarks) {
		super();
		this.name = name;
		this.enrollno = enrollno;
		this.subject = subject;
		this.marksob = marksob;
		this.totalmarks = totalmarks;
	}
	
	public Marksupload() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnrollno() {
		return enrollno;
	}
	public void setEnrollno(String enrollno) {
		this.enrollno = enrollno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getMarksob() {
		return marksob;
	}
	public void setMarksob(double marksob) {
		this.marksob = marksob;
	}
	public double getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(double totalmarks) {
		this.totalmarks = totalmarks;
	}
}
