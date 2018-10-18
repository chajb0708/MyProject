package kr.or.nextit.function.service.impl;

import java.util.List;

import kr.or.nextit.function.service.CommCodeVo;

public interface ComMapper {
	
	/**
	 * 아이피 목록 조회
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CommCodeVo> getIpList(CommCodeVo params) throws Exception;

}
