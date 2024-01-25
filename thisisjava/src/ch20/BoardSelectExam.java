package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardSelectExam {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 찾아주면 메모리에 스태틱 블록으로 올라간다.
			// ip, 포트, db명으로 db에 연결 / 계정 / 패스워드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "1234");
			System.out.println("연결 성공");
			
			String sql = """
					select *
					from boards
					where bwriter=?
					""";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			ResultSet rs = pstmt.executeQuery();
			List<Board> list = new ArrayList<>();
			while(rs.next()) {	// 컬렉션에 일관적으로 값을 담고
				Board board = new Board(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDate(5),
						rs.getString(6),
						rs.getBlob(7)
						);
				list.add(board);
			}
			rs.close();
			pstmt.close();

			list.stream().forEach(e -> e.setBtitle("비 오는 날"));	// 컬렉션에 담은 값을 변경
			for(Board b : list) {
				String sql2 = """
						update boards set
						btitle=?
						where bwriter=?
						""";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, b.getBtitle());
				pstmt2.setString(2, b.getBwriter());
				int rows = pstmt2.executeUpdate();	// 업데이트
				System.out.println(rows);
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
