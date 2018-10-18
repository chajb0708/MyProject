package kr.or.nextit.function.service;

import java.util.List;

import kr.or.nextit.common.error.BizException;

public interface ComCodeService {

	/**
	 * groupId 를 가지고서 비즈니스 플로우를 처리하는 기능으로 공통 코드 리스트를 반환(List<CommcodeVo>)
	 * 
	 * @param groupId
	 * @return List<CommCodeVo>
	 */
	public List<CommCodeVo> getCodeList(String groupId);

	/**
	 * key 값을 넘겨서 CommCodeVo 객체를 반환
	 * 
	 * @param codeKey
	 * @return
	 */
	public CommCodeVo getCodeName(String codeKey);

	public void getErrorTest(String testValue) throws Exception;

	public void getErrorTest2(String testValue) throws Exception;

	public void getBizErrorTest(String testValue) throws BizException;
	
	public List<CommCodeVo> getIpList() throws Exception;

}
