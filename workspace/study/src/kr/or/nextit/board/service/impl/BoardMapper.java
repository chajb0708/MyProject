package kr.or.nextit.board.service.impl;

import java.util.List;

import kr.or.nextit.board.service.BoardVo;

public interface BoardMapper {

	/**
	 * @param boardVo
	 * @throws Exception
	 */
	public void insertBoardItem(BoardVo boardVo) throws Exception;

	public List<BoardVo> selectBoardList(BoardVo boardVo) throws Exception;
	
	public BoardVo selectBoardItem(BoardVo boardVo) throws Exception;
	
	/**
	 * 조회수
	 * @param boardVo
	 * @throws Exception
	 */
	public void updateBoardCountItem(BoardVo boardVo) throws Exception;

	/**
	 * seqNo 값으로 삭제
	 * @param seqNo
	 * @throws Exception
	 */
	public void deleteBoardItem(String seqNo) throws Exception;
	
	/**
	 * 글 수정
	 * @param params
	 * @throws Exception
	 */
	public void updateBoardItem(BoardVo params) throws Exception;

}
