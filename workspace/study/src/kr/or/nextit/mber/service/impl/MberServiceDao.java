package kr.or.nextit.mber.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.nextit.mber.service.MberVo;

public class MberServiceDao {

	private static MberServiceDao instance = null;

	public static MberServiceDao getInstance() {
		if (instance == null) {
			instance = new MberServiceDao();
		}

		return instance;
	}

	public MberVo getMemberItem(Connection conn, String memId) throws SQLException {

		StringBuilder query = new StringBuilder();
		query.append("    SELECT       ");
		query.append("    mem_id,      ");
		query.append("    mem_pw,      ");
		query.append("    mem_name,    ");
		query.append("    mem_phone,   ");
		query.append("    mem_email,   ");
		query.append("    reg_date     ");
		query.append("    FROM         ");
		query.append("    tb_member    ");
		query.append("    WHERE mem_id = ?    ");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());
		pstmt.setString(1, memId);

		ResultSet rs = pstmt.executeQuery();

		MberVo result = null;

		if (rs.next()) {
			result = new MberVo();

			result.setMemId(rs.getString("mem_id"));
			result.setMemName(rs.getString("mem_name"));
			result.setMemPhone(rs.getString("mem_phone"));
			result.setMemEmail(rs.getString("mem_email"));
			result.setMemPw(rs.getString("mem_pw"));
			result.setRegDate(rs.getString("reg_date"));
		}

		return result;
	}

	public int updateMemberItem(Connection conn, MberVo params) throws SQLException {

		StringBuilder query = new StringBuilder();
		query.append("  UPDATE tb_member       ");
		query.append("  SET                    ");
		query.append("      mem_name = ?,      ");
		query.append("      mem_pw = ?,        ");
		query.append("      mem_phone = ?,     ");
		query.append("      mem_email = ?,     ");
		query.append("      reg_date = SYSDATE ");
		query.append("  WHERE                  ");
		query.append("      mem_id = ?         ");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());

		pstmt.setString(1, params.getMemName());
		pstmt.setString(2, params.getMemPw());
		pstmt.setString(3, params.getMemPhone());
		pstmt.setString(4, params.getMemEmail());
		pstmt.setString(5, params.getMemId());

		int result = pstmt.executeUpdate();

		return result;
	}

	public int deleteMemberitem(Connection conn, String memId) throws Exception {
		
		StringBuilder sql =new StringBuilder();
		
		sql.append("  DELETE FROM tb_member ");
		sql.append("  WHERE                 ");
		sql.append("      mem_id = ?        ");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1, memId);
			
		return pstmt.executeUpdate();

	}
}
