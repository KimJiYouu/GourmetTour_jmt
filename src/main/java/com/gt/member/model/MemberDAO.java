package com.gt.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;



public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		return instance;
	}
	
	private String url = "jdbc:oracle:thin:@172.30.1.58:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";
	
	//아이디 중복체크
	public int idCheck(String id) {
		int result = 1;
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1. Connector - 디비연결
			conn = DriverManager.getConnection(url, uid, upw);
			//2. pstmt - sql을 실행하기 위한 클래스
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//3. ResultSet
			rs = pstmt.executeQuery(); //select문
			
			if(rs.next()) { //중복이 있음
				result = 1;
			} else { //중복이 없음
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	//회원가입
	public void join(MemberVO vo) {
		String sql = "INSERT INTO MEMBERS(ID, PW, NAME, EMAIL, GENDER, FOOD) VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getFood());
			
			pstmt.executeUpdate(); //성공 시 1, 실패시 0
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//로그인
	public MemberVO login(String id, String pw) {
		
		//로그인 성공이면 객체가 반환, 로그인 실패면 null값이 반환
		MemberVO vo = null;
		String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String food = rs.getString("food");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new MemberVO(id2, null, name, email, gender, food, regdate);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vo;
	}

	//회원정보조회
	public MemberVO getInfo(String id) {
		MemberVO vo = null;
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // id는 pk라서 1행
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String food = rs.getString("food");
				
				vo = new MemberVO(id2, null, name, email, gender, food, null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vo;
		
	}

	//회원정보 업데이트
	public int updateInfo(MemberVO vo) {
		int result = 0;
		
		String sql = "UPDATE MEMBERS SET PW = ?, NAME = ?, EMAIL = ?, GENDER = ?, FOOD = ? WHERE ID = ?";
		

		Connection conn = null;
		PreparedStatement pstmt  = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getFood());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate(); // 성공 시 1 실패 시 0
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//회원정보 삭제
	public int deleteMember(String id) {
		int result = 0;
		
		String sql = "DELETE FROM MEMBERS WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	


}
