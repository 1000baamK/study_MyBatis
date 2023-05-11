package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	//게시글 개수조회
	int selectListCount();
	
	//게시글 목록 조회
	ArrayList<Board> selectList(PageInfo pi);
	
	//게시글 상세 조회
//	Board selectBoard(Board b);
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);

	//댓글 조회
	ArrayList<Reply> selectReplyList(int boardNo);

	//게시글 검색시 게시글 개수
	int selectSearchCount(HashMap<String, String> map);

	//게시글 검색목록 조회
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

	
	//게시글 검색
	
}
