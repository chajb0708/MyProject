package kr.or.nextit.mber.service.impl;

import java.sql.Connection;

import kr.or.nextit.jdbc.ConnectionPool;
import kr.or.nextit.mber.service.MberVo;
import kr.or.nextit.mber.service.Mberservice;

public class MberServiceImpl implements Mberservice {

	ConnectionPool pool = ConnectionPool.getInstance();

	private MberServiceDao dao = MberServiceDao.getInstance();

	@Override
	public MberVo getMemberItem(String memId) {

		Connection conn = null;
		try {
			conn = pool.getConnection();

			MberVo result = dao.getMemberItem(conn, memId);

			result.setState(true);
			result.setMessage("정상처리");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MberVo result = new MberVo();
			result.setState(false);
			result.setMessage(e.getMessage());
			return result;
		} finally {
			if (conn != null) {
				try {
					pool.releaseconnection(conn);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	@Override
	public MberVo updateMemberItem(String memId, String memPw, String memName, String memPhone, String memEmail) {

		MberVo params = new MberVo();

		params.setMemId(memId);
		params.setMemPw(memPw);
		params.setMemName(memName);
		params.setMemPhone(memPhone);
		params.setMemEmail(memEmail);

		Connection conn = null;
		try {
			conn = pool.getConnection();

			int result = dao.updateMemberItem(conn, params);
			if (result > 0) {
				params.setState(true);
				params.setMessage(String.format("%d : 건이 처리되었음", result));
			} else {
				throw new Exception(String.format("%d : 처리된 결과 없음", result));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			params.setState(false);
			params.setMessage(ex.getMessage());
		} finally {
			if (conn != null) {
				try {
					pool.releaseconnection(conn);
				} catch (Exception ex) {
				}
			}
		}
		return params;
	}

	@Override
	public boolean deleteMemberItem(String memId) {

		Connection conn = null;

		try {
			conn = pool.getConnection();
			int result = dao.deleteMemberitem(conn, memId);
			System.out.println(result);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				pool.releaseconnection(conn);
			}
		}

	}
}


