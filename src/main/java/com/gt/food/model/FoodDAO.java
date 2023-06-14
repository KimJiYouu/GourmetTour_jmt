package com.gt.food.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class FoodDAO {
	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
	//1. 나자신의 객체를 스태틱으로 선언
	private static FoodDAO instance = new FoodDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private FoodDAO() {
		//생성자에서 드라이버클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}

	}
	//3. getter를 통해서 객체를 반환
	public static FoodDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@172.30.1.58:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";	

	//글 등록
	public int regist(String id, String food, String title, String writing, String region, String address, String open) {
		int result = 0;
		String sql = "INSERT INTO FOODBOARD(FNO, ID, FOOD, TITLE, WRITING, REGION, REGDATE, ADDRESS, OPEN) VALUES(FNO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, sysdate, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id );
			pstmt.setString(2, food );
			pstmt.setString(3, title );
			pstmt.setString(4, writing );
			pstmt.setString(5, region );
			pstmt.setString(6, address );
			pstmt.setString(7, open );

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
	public List<FoodVO> getList(String food) {
		List<FoodVO> list = new ArrayList<>();

		String sql = "SELECT * FROM FOODBOARD WHERE FOOD = ? ORDER BY FNO DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, food);
			rs = pstmt.executeQuery();

			/*
			 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램코드
			 */
			while(rs.next()) {
				//1행에대한 처리
				int fno = rs.getInt("FNO");
				String id = rs.getString("ID");
				String region = rs.getString("REGION");
				String title = rs.getString("TITLE");
				String writing = rs.getString("WRITING");
				int hit = rs.getInt("HIT");
				Timestamp regdate = rs.getTimestamp("REGDATE");

				FoodVO vo = new FoodVO();
				vo.setFno(fno);
				vo.setId(id);
				vo.setRegion(region);
				vo.setTitle(title);
				vo.setWriting(writing);
				vo.setHit(hit);
				vo.setRegdate(regdate);
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
	public FoodVO getContent(String fno) {


		String sql = "SELECT * FROM FOODBOARD WHERE FNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		FoodVO vo = new FoodVO();
		try {
			conn = DriverManager.getConnection(url, uid, upw);			

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fno); 

			rs = pstmt.executeQuery();

			if(rs.next()) {
				int fno2 = rs.getInt("fno");
				String id = rs.getString("id");
				String region = rs.getString("region");
				String title  = rs.getString("title");
				String writing = rs.getString("writing").replace("\r\n", "<br>");
				String address = rs.getString("address");
				String open = rs.getString("open");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");

				vo.setFno(fno2);
				vo.setId(id);
				vo.setRegion(region);
				vo.setTitle(title);
				vo.setWriting(writing);
				vo.setAddress(address);
				vo.setOpen(open);
				vo.setHit(hit);
				vo.setRegdate(regdate);
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
	public void update(String fno, String region, String title, String writing, String address, String open) {

		String sql = "UPDATE FOODBOARD SET REGION = ?, TITLE = ?, WRITING = ?, ADDRESS = ?, OPEN = ? WHERE FNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, region );
			pstmt.setString(2, title) ;
			pstmt.setString(3, writing);
			pstmt.setString(4, address);
			pstmt.setString(5, open);
			pstmt.setString(6, fno);

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
	public void delete(String fno) {

		String sql = "DELETE FROM FOODBOARD WHERE FNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fno) ;

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
	public void hitCount(String fno) {

		String sql ="UPDATE FOODBOARD SET HIT = HIT + 1 WHERE FNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fno);

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
	
	
	//JMT
	   public List<FoodVO> getJMTList(String id){

	      List<FoodVO> list = new ArrayList<>();

	      String sql ="SELECT * FROM FOODBOARD WHERE ID = ? ORDER BY FNO DESC";

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;


	      try {
	         conn = DriverManager.getConnection(url, uid, upw);
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);

	         rs = pstmt.executeQuery();

	         while(rs.next()) {
	            int fno = rs.getInt("fno");
	            String id2 = rs.getString("id");
	            String food = rs.getString("food");
	            String title  = rs.getString("title");
	            String writing = rs.getString("writing");
	            String region = rs.getString("region");
	            Timestamp regdate = rs.getTimestamp("regdate");
	            String address = rs.getString("address");
	            String open = rs.getString("open");
	            int hit = rs.getInt("hit");

	            FoodVO vo = new FoodVO(fno, id2, food, title, writing, region, regdate, address, open, hit);
	            list.add(vo);

	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {

	         try {
	            conn.close();
	            pstmt.close();

	         } catch (Exception e2) {

	         }
	      }

	      return list;

	   }
	   
	   public void FBDelete(String id) {
		   
		   String sql = "DELETE FROM FOODBOARD WHERE ID = ?";

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
