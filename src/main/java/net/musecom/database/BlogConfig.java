package net.musecom.database;

import java.util.List;

public interface BlogConfig {

	public int bListCount();
	public List<BlogDto> bList(int page);
	public BlogDto bView(int num);
	public int bUpdate(BlogDto blogDto);
	public int bInsert(BlogDto blogDto);
	public int bDelete(int num);
}
