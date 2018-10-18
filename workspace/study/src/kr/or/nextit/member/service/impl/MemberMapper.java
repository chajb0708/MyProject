package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;
import kr.or.nextit.member.service.MemberVo;

public interface MemberMapper {

	/**
	 * 데이터 회원정보 목록을 가져오는 기능
	 * @param membervo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(MemberVo membervo) throws Exception;
	
	/**
	 * 선택된 정보를 가지고 회원정보를 가져오는 기능
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberItem(String userId) throws Exception;
	
	public List<HashMap<String, Object>> selectMemberInfo(HashMap<String, Object> params) throws Exception;
}
