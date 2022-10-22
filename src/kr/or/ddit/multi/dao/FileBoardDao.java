package kr.or.ddit.multi.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.multi.vo.FileBoardVo;

public interface FileBoardDao {
	
	//조회
	public List<FileBoardVo> selectFileBoard() throws SQLException;
	
	//상세보기
	public FileBoardVo selectFileBoard(int no) throws SQLException;
	
	//저장(파일업로드)
	public int insertFileBoard(FileBoardVo vo) throws SQLException;
}
