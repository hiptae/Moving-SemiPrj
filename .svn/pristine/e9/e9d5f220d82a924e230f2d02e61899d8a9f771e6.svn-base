package kr.co.mpago.controller.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/customer/chat/chatting")
public class Chats{
	private static List<Session> sessions = Collections.synchronizedList(new ArrayList<Session>());
	@OnOpen
	public void onOpen(Session session) {
		sessions.add(session);
		System.out.println("open " + session.getId() + "접속");
	}
	@OnMessage
	public void onMessage(String msg, Session session) {
		sessions.forEach(s -> {
			try {
				s.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("message : " + msg);
	}
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
		System.out.println("close");
	}
	
}