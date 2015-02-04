package jdbc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import jdbc.entity.ChatBoard;

public class ChatBoardDaoImpl implements ChatBoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	private String namespace = "com.mybatis.mapper.chatBoard";
	
	@Override
	public List<ChatBoard> getChatList(int currChatId) {
		String stmt = namespace + ".";
		return null;
	}

	@Override
	public int insertChat(ChatBoard newChatBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

}
