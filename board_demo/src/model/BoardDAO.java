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
	private final String url = "jdbc:mysql://localhost/boarddemo";
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void close() throws SQLException {
		if ( rs != null ) rs.close();
		if ( pstmt != null ) pstmt.close();
		if ( conn != null ) conn.close();
	}
	
	public void insertBoard(BoardDTO board) {
		connect();
		sql = """
				insert into board (title, writer, content, regdate)
				values (?, ?, ?, now())
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				JOptionPane.showMessageDialog(null,"게시글이 등록되었습니다","확인",JOptionPane.PLAIN_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"게시글을 등록할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"게시글을 등록할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public BoardDTO getBoardByBno(int bno) {
		connect();
		BoardDTO board = new BoardDTO();
		sql = "select * from board where bno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBno(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegdate(rs.getDate(5));
				board.setHitcount(rs.getInt(6));
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public List<BoardDTO> getBoards() {
		connect();
		String sql = "select * from board order by bno";
		List<BoardDTO> boards = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBno(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegdate(rs.getDate(5));
				board.setHitcount(rs.getInt(6));
				boards.add(board);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	
	public void updateBoard(BoardDTO board, int bno) {
		connect();
		sql = """
				update board 
				set title=?, writer=?, content=? 
				where bno = ? 
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, bno);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				JOptionPane.showMessageDialog(null,"게시글이 수정되었습니다","확인",JOptionPane.PLAIN_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"게시글을 수정할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"게시글을 수정할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void deleteBoard(int bno) {
		connect();
		sql = "delete from board where bno=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				JOptionPane.showMessageDialog(null,"게시글이 삭제되었습니다","확인",JOptionPane.PLAIN_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"게시글을 삭제할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"게시글을 삭제할 수 없습니다","확인",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void addHitcount(int hitcount, int bno) {
		connect();
		sql = """
				update board 
				set hitcount=?
				where bno = ? 
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hitcount+1);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
			close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> searchKeyword(String kind, String keyword) {
		connect();
		sql = "select * from board where "+ kind +" like ?";
		List<BoardDTO> boards = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBno(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegdate(rs.getDate(5));
				board.setHitcount(rs.getInt(6));
				boards.add(board);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
}
