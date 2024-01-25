package ch20;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsertExam {

	public static void main(String[] args) throws Exception {
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
					.append("insert into boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) ")
					.append("values (?, ?, ?, now(), ?, ?) ")
					.toString();
			
			// PreparedStatement로 value에 들어갈 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, "눈 오는 날");
			pstmt.setString(2, "함박눈이 내려요");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "image1.png");
			pstmt.setBlob(5, new FileInputStream("src/ch20/image1.png"));
			
			// sql문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 행의 키 값: "+ bno);
				}
				rs.close();
			}
			
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
