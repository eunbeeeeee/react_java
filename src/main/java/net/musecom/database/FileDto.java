package net.musecom.database;

public class FileDto {
  private int num;
  private int blog_num;
  private String oldname;
  private String newname;
  private String ext;
  private long filesize;
  private int imname;
  
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBlog_num() {
		return blog_num;
	}
	public void setBlog_num(int blog_num) {
		this.blog_num = blog_num;
	}
	public String getOldname() {
		return oldname;
	}
	public void setOldname(String oldname) {
		this.oldname = oldname;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public int getImname() {
		return imname;
	}
	public void setImname(int imname) {
		this.imname = imname;
	}
	  
	  
}
