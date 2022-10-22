package kr.or.ddit.multi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.multi.service.MultiService;
import kr.or.ddit.multi.service.MultiServiceImpl;
import kr.or.ddit.multi.vo.FileBoardVo;
import kr.or.ddit.multi.vo.FileInfoVo;


/**
 * Servlet implementation class MultiController
 */
@WebServlet("/MultiController")
@MultipartConfig(
	location = "D:\\file",
	maxFileSize = 1024*1024*50L, // 한개의 파일 저장가능한 크기 / 1024*1024*50L = 50MB
	maxRequestSize = -1, // 전체 파일 용량제한없음
	fileSizeThreshold = -1 // -1 == 크기에 제한을 받지않음 maxRequestSize보다 용량을 높게잡아야한다
)
public class MultiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
/*	//전역변수 선언
	int num = 0; // 파일 저장시 같은 이름이 있을경우 파일 이름에 번호를 붙힌다.
	long size = 0L;
	String fname;
	FileBoardVo vo = new FileBoardVo();
	FileInfoVo ivo = new FileInfoVo();
	String originalname;*/
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 멀티파일업로드
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		FileBoardVo vo = new FileBoardVo();
		System.out.println(req.getParameter("title"));
		System.out.println(req.getParameter("content"));
		System.out.println(req.getParameter("file"));
		System.out.println(req.getPart("file").toString()+"asdasda");
		
		try {
			BeanUtils.populate(vo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		MultiService service = MultiServiceImpl.getService();
		int num = service.insertFileBoard(vo); //DB에저장
		
		if(num > 0 )out.println("성공");
		else out.println("실패");
	/*	
		// 파일업로드(저장)		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		String contentType = req.getContentType();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		if(contentType != null 
				&& contentType.toLowerCase().startsWith("multipart/")){

			this.printFilInfo(req,res,out);
			//첨부파일 일경우 - 파일이름, 파일 사이즈, 파일이름 중복?
			//일반 타입일경우 - BeanUtils 를 이용해서
			//vo에 setting하는 메소드를 별도로 만들어 호출
			
			//Multiboard 테이블에 먼저 저장
			vo.setTitle(title);
			vo.setContent(content);
			
			MultiService service = MultiServiceImpl.getService();
			int num = service.insertFileBoard(vo); //DB에저장
						
			//printFileInfo가 끝나고 돌아와서 db에 저장

			if(num > 0 ) out.println("저장성공");
			else out.println("저장실패");

			RequestDispatcher disp =
					req.getRequestDispatcher("/FileList");
			disp.forward(req, res);
		}


	}

	private void printFilInfo(HttpServletRequest req, 
			HttpServletResponse res, PrintWriter out) throws ServletException, IOException{
		// 파일 첨부한 경우만 수행
		Collection<Part>  parts = req.getParts();
		System.out.println(vo.getBno()+"asdasdasd"); 
		for(Part part : parts){
			String type = part.getContentType();
			String name = part.getName();

			if(type != null){
				//파일사이즈
				size = part.getSize();
				//   true   false 
				size = size < 1024 ? size : size /1024;
				//첨부파일 구하기
				fname = this.getFileNmae(part);
				System.out.println("fname=" + fname);
				
				ivo.setFilesize(size);
				ivo.setOriginalname(fname);

				File file = new File("D:\\file\\" + fname);
				//파일중복체크
				if(file.exists()){ //aaa.txt
					//파일이름(1).확장자 aaa(1).txt
					int last = fname.lastIndexOf(".");
					String s1 = fname.substring(0,last); //aaa
					String s2 = fname.substring(last); //.txt

					fname = s1 + "("+ (++num) +")" + s2; //aaa(1).txt
					ivo.setFilename(fname);
					part.write(fname);
				}else{
					//파일중복 안되었을때
					ivo.setFilename(fname);
					part.write(fname);
				}
			}else{
				//일반 text파일일경우 - name, title, pass, cont, id, email
				try {
					BeanUtils.populate(vo, req.getParameterMap());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String getFileNmae(Part part) {
		//첨부파일 이름 구하기
		String ss[] = part.getHeader("Content-Disposition").split(";");

		for(String ssf : ss){
			System.out.println(ssf);
			if(ssf.trim().startsWith("filename")){
				int idx = ssf.indexOf("="); // = 의 위치를 찾고
				int idx2 = ssf.lastIndexOf("\""); // 마지막 " 의 위치를 찾고 , 특정문자를찾기위해서는 \ 기호를 붙여준다
				fname = ssf.substring(idx+2, idx2).trim();
				// =에서부터 2번째 위치를 증가한 곳에서부터
				// 마지막 " 사이의 문자열을 추출한다.
				return fname;
			}else{
				return null;
			}
		}

		return null;
	}
*/
	}
}