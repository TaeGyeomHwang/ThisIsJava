package ch20.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample {

	// 필드
	private Scanner scan = new Scanner(System.in);
	private Connection conn;

	// 생성자
	public BoardExample() {
		try {
			// JDBC 드라이버 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결하기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "1234");
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}

	// 메소드
	public void list() {
		// 타이틀 및 컬럼명 출력
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-------------------------------------------------------");

		// boards 테이블에서 게시물 정보를 가져와서 출력하기
		try {
			String sql = """
					select bno, btitle, bcontent, bwriter, bdate
					from boards
					order by bno desc;
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s \n", board.getBno(), board.getBwriter(), board.getBdate(),
						board.getBtitle());
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		System.out.println();

		switch (menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> exit();
		}
	}

	public static void main(String[] args) {
		BoardExample boardExample = new BoardExample();
		boardExample.list();
	}

	public void create() {
		// 입력 받기
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(scan.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scan.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scan.nextLine());

		// 보조 메뉴 출력
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Canclel");
		System.out.println("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if (menuNo.equals("1")) {
			// boards 테이블에 게시물 정보 저장
			try {
				String sql = """
						insert into boards (btitle, bcontent, bwriter, bdate)
						values (?, ?, ?, now());
						""";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		// 게시물 목록 출력
		list();
	}

	public void read() {
		// 입력 받기
		System.out.println("[게시물 읽기]");
		System.out.println("bno: ");
		int bno = Integer.parseInt(scan.nextLine());

		// boards 테이블에서 해당 게시물을 가져와 출력
		try {
			String sql = """
					select bno, btitle, bcontent, bwriter, bdate
					from boards
					where bno=?;
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("#############");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println("#############");
				// 보조 메뉴 출력
				System.out.println("----------------------");
				System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
				System.out.println("메뉴 선택: ");
				String menuNo = scan.nextLine();
				System.out.println();

				if (menuNo.equals("1")) {
					update(board);
				} else if (menuNo.equals("2")) {
					delete(board);
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}

		// 게시물 목록 출력
		list();
	}

	public void update(Board board) {
		// 수정 내용 입력 받기
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(scan.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scan.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scan.nextLine());

		// 보조 메뉴 출력
		System.out.println("------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if (menuNo.equals("1")) {
			// boards 테이블에서 게시물 정보 수정
			try {
				String sql = """
						update boards set btitle=?, bcontent=?, bwriter=?
						where bno=?
						""";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}

		// 게시물 목록 출력
		list();
	}

	public void delete(Board board) {
		// boards 테이블에 게시물 정보 삭제
		try {
			String sql = "delete from boards where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}

		// 게시물 목록 출력
		list();
	}

	public void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if (menuNo.equals("1")) {
			// boards 테이블에 게시물 정보 전체 삭제
			try {
				String sql = "truncate table boards";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		
		// 게시물 목록 출력
		list();
	}

	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}
}
