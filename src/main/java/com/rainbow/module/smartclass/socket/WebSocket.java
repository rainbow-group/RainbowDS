package com.rainbow.module.smartclass.socket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint("/websocket")
public class WebSocket {

	private static int onlineCount = 0;
	private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
	private Session session;
	private String username;

	@OnOpen
	public void onOpen(Session session) throws IOException {

		this.session = session;

		session.getAsyncRemote().sendText("okokok");
	}

	@OnClose
	public void onClose() throws IOException {
		subOnlineCount();
	}

	@OnMessage
	public void onMessage(String message) throws IOException {

		System.out.println("message: " + message);
	}

	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}

	public void sendMessageTo(String message, String To) throws IOException {
		// session.getBasicRemote().sendText(message);
		// session.getAsyncRemote().sendText(message);
		for (WebSocket item : clients.values()) {
			if (item.username.equals(To))
				item.session.getAsyncRemote().sendText(message);
		}
	}

	public void sendMessageAll(String message) throws IOException {
		for (WebSocket item : clients.values()) {
			item.session.getAsyncRemote().sendText(message);
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocket.onlineCount--;
	}

	public static synchronized Map<String, WebSocket> getClients() {
		return clients;
	}

}
