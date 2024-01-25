package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionExam {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 찾아주면 메모리에 스태틱 블록으로 올라간다.
			// ip, 포트, db명으로 db에 연결 / 계정 / 패스워드
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava",
					"java",
					"1234"); 
			System.out.println("연결 성공");
			
			// sql문 작성
			String sql = new StringBuilder()
					.append("insert into users (userid, username, userpassword, userage, useremail) ")
					.append("values (?, ?, ?, ?, ?) ")
					.toString();
			
			// PreparedStatement로 value에 들어갈 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			pstmt.setString(2, "한겨울");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "winter@mycompany.com");
			
			// sql문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: "+ rows);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 통상적으로 db 연결 후에는 db 연결 끊어줌
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
				}
			}
		}

	}
}