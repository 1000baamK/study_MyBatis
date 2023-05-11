package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	//�Խñ� ������ȸ
	int selectListCount();
	
	//�Խñ� ��� ��ȸ
	ArrayList<Board> selectList(PageInfo pi);
	
	//�Խñ� �� ��ȸ
//	Board selectBoard(Board b);
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);

	//��� ��ȸ
	ArrayList<Reply> selectReplyList(int boardNo);

	//�Խñ� �˻��� �Խñ� ����
	int selectSearchCount(HashMap<String, String> map);

	//�Խñ� �˻���� ��ȸ
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

	
	//�Խñ� �˻�
	
}
