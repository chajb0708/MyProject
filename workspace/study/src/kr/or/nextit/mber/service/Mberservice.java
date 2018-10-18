package kr.or.nextit.mber.service;

public interface Mberservice {

	/**
	 * 회원 상세 정보
	 * 
	 * @param memId
	 * @return
	 */
	public MberVo getMemberItem(String memId);

	/**
	 * 회원정보 수정
	 * 
	 * @param memId
	 * @param memPw
	 * @param memName
	 * @param memPhone
	 * @param memEmail
	 * @return
	 */
	public MberVo updateMemberItem(String memId, String memPw, String memName, String memPhone, String memEmail);

	/**
	 * 회원 삭제
	 * 
	 * @param memId
	 * @return
	 */
	public boolean deleteMemberItem(String memId);
}
