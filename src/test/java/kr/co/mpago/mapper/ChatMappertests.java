package kr.co.mpago.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.Chat;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

@Log4j
public class ChatMappertests {
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private ChatMapper mapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(ChatMapper.class);

	// DB연결 테스트
	@Test
	public void testMapper() {
		System.out.println(mapper);
		System.out.println(factory.getConfiguration());
	}

	// 단일 조회 테스트	
	@Test public void testGet() {
	Chat chat = mapper.get(1L);
	log.info(chat);
}
	 

}
