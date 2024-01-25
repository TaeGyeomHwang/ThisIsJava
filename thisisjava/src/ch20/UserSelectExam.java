package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExam {
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
			
			String sql = "select * from users where userid=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			// sql문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {	// 비어있지 않을 경우
				User user = new User(
						rs.getString("userid"),
						rs.getString("username"),
						rs.getString("userpassword"),
						rs.getInt(4),	//	컬럼 순번을 이용할 수도 있다.
						rs.getString(5)
						);
				System.out.println(user);
			}else {
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
