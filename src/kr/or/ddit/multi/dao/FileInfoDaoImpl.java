package kr.or.ddit.multi.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.SqlmapClientFactory;

public class FileInfoDaoImpl implements FileInfoDao{
	
	private static FileInfoDao dao = new FileInfoDaoImpl();
	private SqlMapClient sqlMap;
	
	//생성자 sqlMap 초기화
	private FileInfoDaoImpl(){
		sqlMap = SqlmapClientFactory.getSqlMapClent();
	}
	
	public static FileInfoDao get_idao(){
		return dao;
	}

	// 멀티파일업로드
	@Override
	public int insertFileinfo(Map<String, Object> map) throws SQLException {
		return 0;
	}

}
