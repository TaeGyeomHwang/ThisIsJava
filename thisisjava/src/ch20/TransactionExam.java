package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExam {

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
			// 트랜잭션 시작
			try {
				conn.setAutoCommit(false);
				String withdraw = "update accounts set balance=balance-? where ano=?";
				String deposit = "update accounts set balance=balance+? where ano=?";
				
				// 1단계
				PreparedStatement pstmt = conn.prepareStatement(withdraw);
				pstmt.setInt(1, 10000);
				pstmt.setString(2, "111-111-1111");
				int rows = pstmt.executeUpdate();
				if(rows==0) throw new WithdrawException("출금이 되지 않음");
				pstmt.close();
				
				// 2단계
				pstmt = conn.prepareStatement(deposit);
				pstmt.setInt(1, 10000);
				pstmt.setString(2, "222-222-2222");
				rows = pstmt.executeUpdate();
				if(rows==0) throw new DepositException("입금이 되지 않음");
				pstmt.close();
				
				conn.commit();
				System.out.println("계좌 이체가 성공했습니다");
			}catch(WithdrawException e) {
				conn.rollback();	// 에러 발생 시 커넥션을 롤백함
				System.out.println(e.getMessage());
			}catch(DepositException e) {
				conn.rollback();
				System.out.println(e.getMessage());
			}finally {
				conn.setAutoCommit(true);	// 트랜잭션 한 단위가 끝나면 다시 돌려놓아야 한다
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
