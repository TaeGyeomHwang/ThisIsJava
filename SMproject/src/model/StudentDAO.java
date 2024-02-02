package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class StudentDAO {
	static final String url = "jdbc:mysql://localhost/studentdemo";
	static final String user = "java";
	static final String password = "1234";
	private static final StudentDAO instance = new StudentDAO();
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public static StudentDAO getInstance() {
		return instance;
	}
	
	private static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			instance.conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void close() throws SQLException { // 리소스 할당 해제
		if ( instance.rs != null ) instance.rs.close();
		if ( instance.pstmt != null ) instance.pstmt.close();
		if ( instance.conn != null ) instance.conn.close();
	}
	
	public List<StudentDTO> getStudents() {
		connect();
		String sql = "select * from students order by name";
		List<StudentDTO> students = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentDTO student = new StudentDTO();
				student.setSno(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setBirth(rs.getDate(3));
				student.setGender(rs.getString(4));
				student.setPhoneNumber(rs.getString(5));
				student.setEmail(rs.getString(6));
				students.add(student);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public StudentDTO getStudentBySno(int sno) {
		connect();
		StudentDTO student = new StudentDTO();
		sql = "select * from students where sno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				student.setSno(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setBirth(rs.getDate(3));
				student.setGender(rs.getString(4));
				student.setPhoneNumber(rs.getString(5));
				student.setEmail(rs.getString(6));
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public StudentDTO getStudentBySeatNo(int seatNo) {
		connect();
		StudentDTO student = new StudentDTO();
		sql = "select * from students where seatNumber=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seatNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				student.setSno(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setBirth(rs.getDate(3));
				student.setGender(rs.getString(4));
				student.setPhoneNumber(rs.getString(5));
				student.setEmail(rs.getString(6));
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public int countStudents() {
		connect();
		sql = "select count(*) from students";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void updateStudent(StudentDTO student, int sno) {
		connect();
		sql = """
				update students 
				set name=?, birth=?, gender=?, phonenumber=?, email=?  
				where sno = ? 
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setDate(2, student.getBirth());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getPhoneNumber());
			pstmt.setString(5, student.getEmail());
			pstmt.setInt(6, sno);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println(student.getName()+"-"+student.getSno() + " [학생의 데이터가 변경되었습니다]");
			}else {
				JOptionPane.showMessageDialog(null,"해당 학번의 학생을 찾을 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"해당 학생의 데이터를 변경할 수 없습니다\n [원인]"+e.getMessage(),"확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void updateSeatNumber(int sno, int seatNo) {
		connect();
		sql = "update students set seatNumber=? where sno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seatNo);
			pstmt.setInt(2, sno);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println(sno+"번 [학생의 자리가 이동되었습니다]"+"->"+seatNo);
			}else {
				JOptionPane.showMessageDialog(null,"해당 학번의 학생을 찾을 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"해당 학생의 자리를 변경할 수 없습니다\n [원인]"+e.getMessage(),"확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void insertStudent(StudentDTO student) { // 학생 추가
		connect();
		sql = """
				insert into students (name, birth, gender, phoneNumber, email)
				values (?, ?, ?, ?, ?)
				""";
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, student.getName());
			pstmt.setDate(2, student.getBirth());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getPhoneNumber());
			pstmt.setString(5, student.getEmail());
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				System.out.println(student.getName()+"-"+rs.getInt(1) + " [학생이 추가되었습니다]");
			}else {
				JOptionPane.showMessageDialog(null,"해당 학생을 추가할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"해당 학생을 추가할 수 없습니다\n [원인]"+e.getMessage(),"확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void deleteStudent(int sno) { // 학생 삭제
		connect();
		sql = "delete from students where sno=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println(sno + "번 [학생이 삭제되었습니다]");
			}else {
				JOptionPane.showMessageDialog(null,"해당 학생을 삭제할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"해당 학생을 삭제할 수 없습니다\n [원인]"+e.getMessage(),"확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
