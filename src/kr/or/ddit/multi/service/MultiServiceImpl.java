package kr.or.ddit.multi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import kr.or.ddit.multi.dao.FileBoardDao;
import kr.or.ddit.multi.dao.FileBoardDaoImpl;
import kr.or.ddit.multi.dao.FileInfoDao;
import kr.or.ddit.multi.dao.FileInfoDaoImpl;
import kr.or.ddit.multi.vo.FileBoardVo;

public class MultiServiceImpl implements MultiService{

	private static MultiService service = new MultiServiceImpl();
	private FileBoardDao f_dao;
	private FileInfoDao i_dao;
	
	//생성자 dao초기화
	private MultiServiceImpl(){
		f_dao = FileBoardDaoImpl.get_fdao();
		i_dao = FileInfoDaoImpl.get_idao();
	} 
	
	public static MultiService getService(){
		if(service == null){
			service = new MultiServiceImpl();
		}
		return service;
	}
	
	// 목록조회
	@Override
	public List<FileBoardVo> selectFileBoard() {
		return null;
	}

	// 상세보기
	@Override
	public FileBoardVo selectFileBoard(int no) {
		return null;
	}

	// 파일업로드 
	@Override
	public int insertFileBoard(FileBoardVo vo) {
		Part[] files = vo.getFile();
		for(Part part : files){
			FileBoardVo fvo = new FileBoardVo();			
			System.out.println(fvo.getFile());
		}
		int res = 0;
		/*try {
			res = f_dao.insertFileBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return res;
	}

	//멀티 파일업로드
	@Override
	public int insertFileinfo(Map<String, Object> map) {
		int res = 0;
		try {
			res = i_dao.insertFileinfo(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
}
