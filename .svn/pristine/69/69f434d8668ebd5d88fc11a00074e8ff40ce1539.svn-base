package kr.co.mpago.service;

import java.util.List;
import java.util.Map;

import kr.co.mpago.domain.Rate;
import kr.co.mpago.mapper.RateMapper;
import kr.co.mpago.util.DBUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RateService {
	@Getter
	private static RateService rateService = new RateService();
	private RateMapper rateMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(RateMapper.class);

//	원래
//	public void register(Rate rate) {
//		rateMapper.insert(rate);
//	}

	public int register(Rate rate) {
		return rateMapper.insert(rate);
	}
	
	public List<Rate> getList(Long mno, Long userno, Long lastTno) { // 전체조회
		if(lastTno == null) {
			lastTno = Long.MAX_VALUE;
		}
		return rateMapper.selectList(mno, userno, lastTno); 
	}
	
	public Rate getOne(Long tno) {
		return rateMapper.selectOne(tno);
	}
	
	public Map<String, Double> getCountAndAvg(Long mno) { // 영화에 따른 댓글 갯수, 평점
		return rateMapper.selectCountAndAvg(mno);
	}
	
	public int modify(Rate rate) {
		return rateMapper.update(rate);
	}
	
	public int delete(Long tno) {	// 댓글 삭제
		return rateMapper.delete(tno);
	}
	
	
}
