package kr.co.mpago.service;

import java.util.List;

import kr.co.mpago.domain.Favorite;
import kr.co.mpago.mapper.FavoriteMapper;
import kr.co.mpago.util.DBUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor(access = AccessLevel.PRIVATE) // 기본생성자
public class FavoriteService {
	@Getter 
	private static FavoriteService favoriteService = new FavoriteService(); // 생성자
	private FavoriteMapper favoritemapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(FavoriteMapper.class);
	
	public void register(Favorite favorite) {	// 등록
		favoritemapper.insert(favorite);
	}
	
//	public void get(Long fno) { // 단일 조회
//		 return favoritemapper.get(fno);
//	}
	
	public Favorite get(Long fno) {
	    return favoritemapper.get(fno);
	}

	
	public List<Favorite> getList(Long userno) { // 찜 전체 목록
		return favoritemapper.getList(userno);
	}
	
	public void delete(Long fno) { // 삭제
		favoritemapper.delete(fno);
	}

	public Favorite find(Favorite favorite) { // 찜한 fno, userno, mno
		return favoritemapper.find(favorite); 
	}

	public void toggle(Favorite favorite) { // 찜 클릭시
		Favorite f = find(favorite); 
		if(find(favorite) == null) { // 찜한 것이 없다면 등록
			register(favorite);
		}
		else {	
			delete(f.getFno()); // 이미 찜한 상태면 삭제
		}
	}
}
