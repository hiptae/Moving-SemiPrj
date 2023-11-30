package kr.co.mpago.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.co.mpago.domain.Msg;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

@Log4j
public class MsgMapperTests {
	private MsgMapper mapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MsgMapper.class);
	
	// 쪽지발송
	@Test
	public void insert() {
		Msg msg = new Msg();
		msg.setTitle("제목");
		msg.setContent("내용");
		msg.setFromnick("보낸이");
		msg.setTonick("받는이");
		mapper.insert(msg);
		log.info(msg);
	}
	// 단일조회
	@Test
	public void read() {
		mapper.read(1L);
	}
	
	// 받은쪽지함
	@Test
	public void getReceiList() {
		List<Msg> list = mapper.getReceiList("kdb");
		log.info(list);
	}
	
	// 보낸쪽지함
	@Test
	public void getSendList() {
		List<Msg> list = mapper.getSendList("kdb");
		log.info(list);
	}
	
	// 선택삭제
	@Test
	public void getDelete() {
		List<Long> msgnos = new ArrayList<>();
		msgnos.add(7L);
		log.info(msgnos);
		mapper.read(7L);
//		mapper.delete(msgnos);
		mapper.read(7L);
	}
}
