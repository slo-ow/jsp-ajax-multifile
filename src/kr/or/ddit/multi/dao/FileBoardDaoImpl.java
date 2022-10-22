package kr.or.ddit.multi.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.SqlmapClientFactory;
import kr.or.ddit.multi.vo.FileBoardVo;

public class FileBoardDaoImpl implements FileBoardDao{
	
	private static FileBoardDao dao = new FileBoardDaoImpl();
	private SqlMapClient sqlMap;
	
	//생성자 sqlMap 초기화
	private FileBoardDaoImpl(){
		sqlMap = SqlmapClientFactory.getSqlMapClent();
	}
	
	public static FileBoardDao get_fdao(){
		return dao;
	}
	
	// 조회
	@Override
	public List<FileBoardVo> selectFileBoard() throws SQLException {
		
		return sqlMap.queryForList("fileboard.selectFileBoard");
	}

	// 상세보기
	@Override
	public FileBoardVo selectFileBoard(int no) throws SQLException {
		
		return (FileBoardVo) sqlMap.queryForObject("fileboard.getInfo",no);
	}

	// 저장(파일업로드)
	@Override
	public int insertFileBoard(FileBoardVo vo) throws SQLException {
		
		return (int) sqlMap.insert("fileboard.insertFileBoard",vo);
	}

}
