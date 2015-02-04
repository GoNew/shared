package jdbc.dao;

import java.util.List;

import jdbc.entity.ChatBoard;

public interface ChatBoardDao {
	List<ChatBoard> getChatList(int currChatId);
	int insertChat(ChatBoard newChatBoard);
}
