package com.gt.comments.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class CommentsDAO {

	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
			//1. 나자신의 객체를 스태틱으로 선언
			private static CommentsDAO instance = new CommentsDAO();
			//2. 직접 생성하지 못하도록 생성자 제한
			private CommentsDAO() {
				//생성자에서 드라이버클래스 호출
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (Exception e) {
				}
				
			}
			//3. getter를 통해서 객체를 반환
			public static CommentsDAO getInstance() {
				return instance;
			}

			private String url = "jdbc:oracle:thin:@172.30.1.58:1521:xe";
			private String uid = "JSP";
			private String upw = "JSP";	
			
			//글 등록
			public int comregist(String id, String comment_text, String bno) {
				int result = 0;
				String sql = "INSERT INTO COMMENTS(CNO, ID, COMMENT_TEXT, BNO) VALUES(CNO_SEQ.NEXTVAL, ?, ?, ?)";
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					
					conn = DriverManager.getConnection(url, uid, upw);
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, comment_text);
					pstmt.setString(3, bno);
					
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

			//댓 목록
			public List<CommentsVO> getComList(String bno) {
				List<CommentsVO> list = new ArrayList<>();
				
				String sql = "SELECT * FROM COMMENTS WHERE BNO = ? ORDER BY REGDATE";
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					
					conn = DriverManager.getConnection(url, uid, upw);
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bno);
					rs = pstmt.executeQuery();
					
					/*
					 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램코드
					 */
					while(rs.next()) {
						//1행에대한 처리
						int cno = rs.getInt("cno");
						String id = rs.getString("id");
						String comment_text = rs.getString("comment_text").replace("\r\n", "<br>");
						Timestamp regdate = rs.getTimestamp("regdate");
						int bno2 = rs.getInt("bno");
						CommentsVO vo = new CommentsVO(cno, id, comment_text, regdate, bno2);
						
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

			//댓 삭제
			public void deleteCom(String cno) {

				String sql = "DELETE FROM COMMENTS WHERE CNO = ?";

				Connection conn = null;
				PreparedStatement pstmt = null;

				try {

					conn = DriverManager.getConnection(url, uid, upw);
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cno) ;

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
