package kr.or.ddit.multi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.multi.vo.FileInfoVo;

public interface FileInfoDao {
	
	//조회
	/*public List<FileInfoVo> selectFileinfo(int bno);*/
	
	//저장(멀티파일업로드)
	public int insertFileinfo(Map<String,Object> map) throws SQLException;
	
	
}
