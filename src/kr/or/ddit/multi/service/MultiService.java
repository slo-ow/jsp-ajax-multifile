package kr.or.ddit.multi.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.multi.vo.FileBoardVo;

public interface MultiService {
	
		//조회
		public List<FileBoardVo> selectFileBoard();
		
		//상세보기
		public FileBoardVo selectFileBoard(int no);
		
		//저장(파일업로드)
		public int insertFileBoard(FileBoardVo vo);
		
		//멀티 파일업로드
		public int insertFileinfo(Map<String, Object> map);
			
}
