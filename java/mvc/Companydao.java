package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Marksupload;
import dto.Studentform;
import dto.Users;

public class Companydao 
{
	public static Connection createConnection() throws IOException, ClassNotFoundException
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");//forName() method, to dynamically load the driver's class file into memory, which automatically registers it.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spademo","root","root");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public int signupUser( Users u) throws IOException 
	{
		Connection con = null;
		int i=0;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("create table if not exists signup (Name varchar(25),Email varchar(100) ,UserName varchar(20),Password varchar(10),PRIMARY KEY(Email))");
			//A prepared statement is a feature used to execute the same (or similar) SQL statements repeatedly with high efficiency.
			ps.executeUpdate();
			PreparedStatement ps1 = con.prepareStatement("insert into signup values(?,?,?,?)");
			ps1.setString(1, u.getFirstname());
			ps1.setString(2, u.getEmail());
			ps1.setString(3, u.getUsername());
			ps1.setString(4, u.getPassword());
			
			i = ps1.executeUpdate();
			
			con.close();
		} 
		catch (SQLException | NullPointerException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public int checksignup(String email,String uname)
	{
		Connection con = null;
		int j=0;
		try
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from signup where email=?");
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				j=1;
			}
			
			PreparedStatement ps1 = con.prepareStatement("select * from signup where username=?");
			ps1.setString(1,uname);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
				j=2;
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return j;
	}
	
	public int checklogin(String username , String password) throws IOException
	{
		Connection con = null;
		int i=0;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from signup where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				i = 1;
			}
			con.close();
		} 
		catch (SQLException | NullPointerException |ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public int marksUpload(Marksupload mu) throws IOException
	{
		Connection con = null;
		int i=0;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("create table if not exists marks (Name varchar(25) not null,EnrollNo varchar(12) not null,Subject varchar(100) not null, MarksObtained varchar(100) not null,TotalMarks varchar(100) not null)");
			//A prepared statement is a feature used to execute the same (or similar) SQL statements repeatedly with high efficiency.
			ps.executeUpdate();
			PreparedStatement ps1 = con.prepareStatement("insert into marks values(?,?,?,?,?)");
			ps1.setString(1, mu.getName());
			ps1.setString(2, mu.getEnrollno());
			ps1.setString(3, mu.getSubject());
			ps1.setDouble(4, mu.getMarksob());
			ps1.setDouble(5, mu.getTotalmarks());
			
			i = ps1.executeUpdate();
			
			con.close();
		} 
		catch (SQLException | NullPointerException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public int studentUpload(Studentform sf) throws IOException
	{
		Connection con = null;
		int i=0;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("create table if not exists studentdetail (Fullname varchar(25) not null, EnrollNo varchar(12) not null, Email varchar(100) not null, MobileNo varchar(10) not null, Branch varchar(100) not null, Semester varchar(1) not null,PRIMARY KEY(EnrollNo))");
			//A prepared statement is a feature used to execute the same (or similar) SQL statements repeatedly with high efficiency.
			ps.executeUpdate();
			PreparedStatement ps1 = con.prepareStatement("insert into studentdetail values(?,?,?,?,?,?)");
			ps1.setString(1, sf.getFullname());
			ps1.setString(2, sf.getEnrollno());
			ps1.setString(3, sf.getEmail());
			ps1.setString(4, sf.getMobileno());
			ps1.setString(5, sf.getBranch());
			ps1.setString(6, sf.getSem());
			
			i = ps1.executeUpdate();
			
			con.close();
		} 
		catch (SQLException | NullPointerException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public ArrayList<Studentform> getAllStudentDetails() // getAllUsersDetails is to bring all user data.
	{
		Connection con = null;
		ArrayList<Studentform> list = new ArrayList<>();
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentdetail order by EnrollNo");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Studentform sf = new Studentform(rs.getString("fullname"),rs.getString("enrollno"), rs.getString("email"), rs.getString("mobileno"), rs.getString("branch"), rs.getString("semester"));
				list.add(sf);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Marksupload> studentAnalysis() // getAllUsersDetails is to bring all user data.
	{
		Connection con = null;
		ArrayList<Marksupload> list = new ArrayList<>();
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from marks order by EnrollNo");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Marksupload mu = new Marksupload(rs.getString("name"),rs.getString("enrollno"), rs.getString("subject"), rs.getDouble("marksobtained"), rs.getDouble("totalmarks"));
				list.add(mu);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateStudentDetails(Studentform usf) throws NullPointerException
	{
		Connection con = null;
		int i=0;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("update studentdetail set Fullname=? ,Email=? ,MobileNo=? ,Branch=?, Semester=? where EnrollNo = ?");
			ps.setString(1, usf.getFullname());
			ps.setString(2, usf.getEmail());
			ps.setString(3, usf.getMobileno());
			ps.setString(4, usf.getBranch());
			ps.setString(5, usf.getSem());
			ps.setString(6, usf.getEnrollno());
			
			i = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public Studentform getStudent(String enrollno) // getUser is to bring single user data.
	{
		Studentform s = null;
		Connection con = null;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentdetail where EnrollNo = ?");
			ps.setString(1, enrollno);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				s = new Studentform(rs.getString("Fullname"),rs.getString("EnrollNo"), rs.getString("Email"), rs.getString("MobileNo"), rs.getString("Branch"), rs.getString("Semester"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public int deleteStudentDetails(String enrollno)
	{
		Connection con = null;
		int i=0;
		try 
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("delete from studentdetail where EnrollNo=?");
			ps.setString(1, enrollno);
			i = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public int checkStudentDetail(String enroll,String email)
	{
		Connection con = null;
		int j=0;
		try
		{
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentdetail where Email=?");
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				j=1;
			}
			
			PreparedStatement ps1 = con.prepareStatement("select * from studentdetail where EnrollNo=?");
			ps1.setString(1,enroll);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
				j=2;
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return j;
	}
}
