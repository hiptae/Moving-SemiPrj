package kr.co.mpago.service;

import java.util.List;

import kr.co.mpago.domain.Msg;
import kr.co.mpago.mapper.MsgMapper;
import kr.co.mpago.util.DBUtils;
import lombok.Getter;

public class MsgService {
	@Getter
	private static MsgService msgService = new MsgService();
	
	private MsgMapper msgMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MsgMapper.class);
	
	public void send(Msg msg) {
		msgMapper.insert(msg);
	}
	
	public Msg get(Long msgno) {
		return msgMapper.read(msgno);
	}
	
	public List<Msg> getReceiMsg(String tonick) {
		return msgMapper.getReceiList(tonick);
	}
	
	public List<Msg> getSendMsg(String fromnick) {
		return msgMapper.getSendList(fromnick);
	}
	
	public boolean remove(Long msgnos) {
		return msgMapper.delete(msgnos) > 0;
	}
}
