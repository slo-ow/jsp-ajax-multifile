package kr.or.ddit.multi.vo;

import java.util.List;

import javax.servlet.http.Part;

public class FileBoardVo {
	private int bno;
	private String title;
	private String content;
	private Part[]  file;
	private List<FileInfoVo> filelist;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Part[] getFile() {
		return file;
	}
	public void setFile(Part[] file) {
		this.file = file;
	}
	public List<FileInfoVo> getFilelist() {
		return filelist;
	}
	public void setFilelist(List<FileInfoVo> filelist) {
		this.filelist = filelist;
	}
	
	
	
}
