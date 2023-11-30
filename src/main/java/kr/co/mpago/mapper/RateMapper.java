package kr.co.mpago.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.co.mpago.domain.Rate;

public interface RateMapper {

	// 평점 등록
	int insert(Rate rate);
	
	Rate selectOne(Long tno);
	
	// 영화별 조회
//	List<Rate> getRateByMovie(Long mno);
	
	// user별 조회
//	List<Rate> getRateByUser(@Param("userno") Long userno, @Param("lastTno") Long lastTno);
	
	// 전체 조회
//	List<Rate> getList();
	
	// 전체조회
	List<Rate> selectList(@Param("mno") Long mno, @Param("userno") Long userno, @Param("lastTno") Long lastTno);
	
	// 영화에 따른 댓글 갯수조회
//	Integer selectCount(Long mno);

	// 영화별 평점 평균
	Map<String, Double> selectCountAndAvg(Long mno);
	
	// 수정
//	boolean update(Rate rate);
	int update(Rate rate);
	
	// 삭제
	int delete(Long rno);




}
