package com.gt.rvboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gt.rvboard.model.RvboardDAO;

public class RvboardDAO {

	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
	//1. 나자신의 객체를 스태틱으로 선언
	private static RvboardDAO instance = new RvboardDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private RvboardDAO() {
		//생성자에서 드라이버클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}

	}
	//3. getter를 통해서 객체를 반환
	public static RvboardDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@172.30.1.58:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";	

	//글 등록
	public int regist(String id, String title, String writing) {
		int result = 0;
		String sql = "INSERT INTO RVBOARD(BNO, ID, TITLE, writing) VALUES(BNO_SEQ.NEXTVAL, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id );
			pstmt.setString(2, title );
			pstmt.setString(3, writing );

			result = pstmt.executeUpdate(); //끝.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}			
		}
		return result;
	}

	//목록을 조회
	public List<RvboardVO> getList() {
		List<RvboardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM RVBOARD ORDER BY BNO DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			/*
			 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램코드
			 */
			while(rs.next()) {
				//1행에대한 처리
				int bno = rs.getInt("bno");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String writing = rs.getString("writing");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");

				RvboardVO vo = new RvboardVO(bno, id, title, writing, hit, regdate);

				list.add(vo); //list추가
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}

	//글내용을 조회
	public RvboardVO getContent(String bno) {

		RvboardVO vo = null;

		String sql = "SELECT * FROM RVBOARD WHERE BNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);			

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno); 

			rs = pstmt.executeQuery();

			if(rs.next()) {
				int bno2 = rs.getInt("bno");
				String id = rs.getString("id");
				String title  = rs.getString("title");
				String writing = rs.getString("writing").replace("\r\n", "<br>");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");

				vo = new RvboardVO(bno2, id, title, writing, hit, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return vo;
	}

	//글 수정 기능
	public void update(String bno, String title, String writing) {

		String sql = "UPDATE RVBOARD SET TITLE = ?, WRITING = ? WHERE BNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title ) ;
			pstmt.setString(2, writing) ;
			pstmt.setString(3, bno) ;

			pstmt.executeUpdate(); //끝.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	//글 삭제 기능
	public void delete(String bno) {

		String sql = "DELETE FROM RVBOARD WHERE BNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno) ;

			pstmt.executeUpdate(); //끝.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	// 조회수 증가
	public void hitCount(String bno) {

		String sql ="UPDATE RVBOARD SET HIT = HIT + 1 WHERE BNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);

			pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				conn.close();
				pstmt.close();

			} catch (Exception e2) {

			}
		}
	}
	
	//마이페이지 내가 쓴 글
	public List<RvboardVO> getMyList(String id) {
		List<RvboardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM RVBOARD WHERE ID = ? ORDER BY BNO DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			/*
			 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램코드
			 */
			while(rs.next()) {
				//1행에대한 처리
				int bno = rs.getInt("bno");
				String id2 = rs.getString("id");
				String title = rs.getString("title");
				String writing = rs.getString("writing");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");

				RvboardVO vo = new RvboardVO(bno, id2, title, writing, hit, regdate);

				list.add(vo); //list추가
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}
	
	public void RBDelete(String id) {
		   
		   String sql = "DELETE FROM RVBOARD WHERE ID = ?";

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id) ;

				pstmt.executeUpdate(); //끝.

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		   
	   }
	
}
