package kr.or.ddit.ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlmapClientFactory {
	
	private static SqlMapClient  sqlmap;
	
	static{
		
		String resource = "kr/or/ddit/ibatis/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlmap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			throw new RuntimeException("SqlMapClient 생성 실패" + e, e);
		}	
			
	}
	
    public static SqlMapClient getSqlMapClent(){
	   return sqlmap;
    }
}















