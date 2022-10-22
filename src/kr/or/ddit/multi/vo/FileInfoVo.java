package kr.or.ddit.multi.vo;

public class FileInfoVo {
	private int ino;
	private int bno;
	private String filename;
	private String originalname;
	private long filesize;
	
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOriginalname() {
		return originalname;
	}
	public void setOriginalname(String originalname) {
		this.originalname = originalname;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long size) {
		this.filesize = size;
	}
	
	
}
