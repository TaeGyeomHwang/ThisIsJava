package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BoardDAO {
	private static final BoardDAO instance = new BoardDAO();
	private final String url = "jdbc:mysql://localhost:3306/boarddemo";
	private final String user = "java";
	private final String password = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	public static BoardDAO getInstance() {
		return instance;
	}

	private void connect() {
		try {
			// JDBC 드라이버 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "DB에 연결할 수 없습니다", "확인", JOptionPane.WARNING_MESSAGE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "드라이버를 찾을 수 없습니다", "확인", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void close() throws SQLException {
		if (conn != null)
			conn.close();
		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
	}

	public void insertBoard(BoardDTO board) {
		try {
			connect();
			// sql에 쿼리 입력
			sql = """
					insert into boards (btitle, bwriter, bcontent, bdate)
					values (?, ?, ?, now());
					""";
			// conn으로부터 pstmt(sql) 받기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			// execute 호출
			pstmt.executeUpdate();
			close();
		} catch (Exception e) {}
	}

	public BoardDTO getBoardByBno(int bno) { // 게시글 하나만 받아옴
		BoardDTO board = new BoardDTO();
		try {
			connect();
			// sql에 쿼리 입력
			sql = """
					select btitle, bcontent, bwriter, bhitcount
					from boards
					where bno=?;
					""";
			// conn으로부터 pstmt(sql) 받기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			// execute 호출
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setTitle(rs.getString("btitle"));
				board.setContent(rs.getString("bcontent"));
				board.setWriter(rs.getString("bwriter"));
				board.setHitcount(rs.getInt("bhitcount"));
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public List<BoardDTO> getBoards() { // 게시글 전체 가져오기
		List<BoardDTO> boardList = new ArrayList<>();
		try {
			connect();
			// sql에 쿼리 입력
			sql = """
					select bno, btitle, bcontent, bwriter, bdate, bhitcount
					from boards
					order by bno;
					""";
			// conn으로부터 pstmt(sql) 받기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// execute 호출
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("btitle"));
				board.setContent(rs.getString("bcontent"));
				board.setWriter(rs.getString("bwriter"));
				board.setRegdate(rs.getDate("bdate"));
				board.setHitcount(rs.getInt("bhitcount"));
				boardList.add(board);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

	public void updateBoard(BoardDTO board, int bno) {	// 게시글 수정
		try {
			connect();
			String sql = """
					update boards set btitle=?, bcontent=?, bwriter=?
					where bno=?
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setInt(4, bno);
			pstmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(int bno) {
		try {
			connect();
			String sql = "delete from boards where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addHitcount(int hitcount, int bno) {
		try {
			connect();
			String sql = """
					update boards set bhitcount=?
					where bno=?
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hitcount);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void truncateBoard() {
		try {
			connect();
			String sql = "truncate table boards";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
