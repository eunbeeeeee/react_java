package net.musecom.database;

import java.util.List;

public class BlogImpl implements BlogConfig, FileConfig {

	BlogDao dao = BlogDao.getInterface();
	
	@Override
	public int bListCount() {
		return dao.bListCount();
	}

	@Override
	public List<BlogDto> bList(int page) {
		return dao.bList(page);
	}

	@Override
	public BlogDto bView(int num) {
		return dao.bView(num);
	}

	@Override
	public int bUpdate(BlogDto blogDto) {
		return dao.bUpdate(blogDto);
	}

	@Override
	public int bInsert(BlogDto blogDto) {
		return dao.bInsert(blogDto);
	}

	@Override
	public int bDelete(int num) {
		return dao.bDelete(num);
	}

	@Override
	public int fileInsert(FileDto fileDto) {
		return dao.fileInsert(fileDto);
	}

	@Override
	public int fileUpdate(FileDto fileDto) {
		return dao.fileUpdate(fileDto);
	}

	@Override
	public int fileDelete(int num) {
		return dao.fileDelete(num);
	}

	@Override
	public List<FileDto> fileList(int blognum) {
		return dao.fileList(blognum);
	}

}
