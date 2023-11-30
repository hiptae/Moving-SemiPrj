package kr.co.mpago.service;

import java.util.List;

import kr.co.mpago.domain.BoardCategory;
import kr.co.mpago.mapper.BoardCategoryMapper;
import kr.co.mpago.util.DBUtils;

public class BoardCategoryService {
	private BoardCategoryMapper categoryMapper = DBUtils.sqlSessionFactory().openSession().getMapper(BoardCategoryMapper.class);
	
	public List<BoardCategory> getList() {
		return categoryMapper.getList();
	}
}
