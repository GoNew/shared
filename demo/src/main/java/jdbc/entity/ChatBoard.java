package jdbc.entity;

import java.sql.Date;


public class ChatBoard {
	private int chatId;
	private String chatContent;
	private Date chatTime;
	public ChatBoard() {
		super();
	}
	public ChatBoard(int chatId, String chatContent, Date chatTime) {
		super();
		this.chatId = chatId;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	@Override
	public String toString() {
		return "ChatBoard [chatId=" + chatId + ", chatContent=" + chatContent
				+ ", chatTime=" + chatTime + "]";
	}
}
