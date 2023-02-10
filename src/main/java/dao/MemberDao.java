package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {

		private static MemberDao dao = null;
		
		private MemberDao() {
			DBConnection.initConnection();
		}
		public static MemberDao getInstance() {
			if (dao == null) {
				dao = new MemberDao();
			}
			return dao;
		}
		
		public boolean getId(String id) {
			String sql = " select id "
					+ "	from member"
					+ "	where id = ?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			boolean findid = false;
			
			try {
				conn = DBConnection.getConnection();
				System.out.println("1/3 getId completed");
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				System.out.println("2/3 getId completed");
				
				rs = psmt.executeQuery();
				System.out.println("3/3 getId completed");
				
				if (rs.next()) {
					findid = true;
				}
				
			} catch (SQLException e) {
				System.out.println("getId failed");
				e.printStackTrace();
			}finally {
				DBClose.close(conn, psmt, rs);				
			}
			return findid;	
		}
		
		
		
		// 로그인
		public boolean addMember(MemberDto dto) {
			
			String sql = " insert into member(id, pwd, name, email, auth)"
					+ "	values(?, ?, ?, ?, 3) ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			int count = 0;
			
			
			try {
				conn = DBConnection.getConnection();				
				System.out.println("1/3 addMember completed");
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPwd());
				psmt.setString(3, dto.getName());
				psmt.setString(4, dto.getEmail());
				System.out.println("2/3 addMember completed");
				
				count = psmt.executeUpdate();	
				System.out.println("3/3 addMember completed");
				
			} catch (SQLException e) {
				System.out.println("addMember failed");
				e.printStackTrace();
			}finally {
				DBClose.close(conn, psmt, null);
			}
			return count > 0? true:false;
			
		}	
		
		
		
		
		
		public MemberDto login(String id, String pwd) {
			String sql = " select id, name, email, auth "
					+ "	from member"
					+ "	where id = ? and pwd = ? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			MemberDto mem = null;
			
			
			try {
				conn = DBConnection.getConnection();
				System.out.println("1/3 login completed");
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pwd);
				System.out.println("2/3 login completed");
				
				rs = psmt.executeQuery();
				System.out.println("3/3 login completed");
				
				
				if (rs.next()) {
					String _id = rs.getString(1);
					String _name = rs.getString("name");
					String _email = rs.getString(3);
					int _auth = rs.getInt(4);
					
					mem = new MemberDto(_id, pwd, _name, _email, _auth);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, psmt, rs);
			}
			return mem;
		}
}








