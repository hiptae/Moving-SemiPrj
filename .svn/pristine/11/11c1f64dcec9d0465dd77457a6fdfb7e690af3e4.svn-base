package kr.co.mpago.service;

import java.util.List;

import kr.co.mpago.domain.Chat;
import kr.co.mpago.mapper.ChatMapper;
import kr.co.mpago.util.DBUtils;

public class ChatService {

    private static final ChatService chatService = new ChatService();
    private ChatMapper chatMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(ChatMapper.class);
    private ChatService() {}

    public static ChatService getInstance() {
        return chatService;
    }
    public Chat get(Long chatno) {
        return chatMapper.get(chatno);
    }
	public List<Chat> getChats() {
		 return chatMapper.getList();
	}
    public int insertChat(Chat chat) {
        return chatMapper.insert(chat);
    }
	public void delete(Long bno) {
		chatMapper.delete(bno);
	}
    
}
