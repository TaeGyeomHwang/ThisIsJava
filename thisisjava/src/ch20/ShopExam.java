package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShopExam {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 찾아주면 메모리에 스태틱 블록으로 올라간다.
			// ip, 포트, db명으로 db에 연결 / 계정 / 패스워드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "java", "1234");
			System.out.println("연결 성공");

			String sql = """
					select *
					from buytbl as b
					where b.userid = any (
						select u.userid
						from usertbl as u
						where height > ?
					);
					""";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			Scanner scan = new Scanner(System.in);
			System.out.print("기준 키를 입력하십시오> ");
			pstmt.setString(1, scan.nextLine());
			scan.close();

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t");
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
