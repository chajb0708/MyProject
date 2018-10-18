package kr.or.nextit.board.service;

import java.util.List;

public interface BoardService {

	/**
	 * 보드의 글 등록
	 * 
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public boolean insertBoardItem(BoardVo boardVo) throws Exception;

	/**
	 * Board List 구현
	 * 
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public List<BoardVo> getBoardList(BoardVo boardVo) throws Exception;

	/**
	 * 1건을 가지고오기
	 * 
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public BoardVo getBoardItem(BoardVo boardVo) throws Exception;

	/**
	 * 삭제하기
	 * 
	 * @param seqNo
	 * @throws Exception
	 */
	public void deleteBoardItem(String seqNo) throws Exception;

	/**
	 * 수정하기
	 * 
	 * @param params
	 * @throws Exception
	 */
	public void updateBoardItem(BoardVo params) throws Exception;
}
