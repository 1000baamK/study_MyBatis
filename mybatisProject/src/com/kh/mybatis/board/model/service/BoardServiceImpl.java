package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Template;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao = new BoardDao();
	
	
	//게시글 개수 조회
	@Override
	public int selectListCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return count;
	}

	//게시글 목록 조회
	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}

	//게시글 상세 조회
//	@Override
//	public Board selectBoard(Board b) {
//		
//		SqlSession sqlSession = Template.getSqlSession();
//		
//		//조회수 증가
//		int result = boardDao.countUp(sqlSession, b);
//		
//		Board board = null;
//		
//		if(result>0) {
//			sqlSession.commit();
//			
//			//증가가되면 게 상세 조회
//			board = boardDao.selectBoard(sqlSession, b);
//			
//		}else {
//			sqlSession.rollback();			
//		}
//		
//		sqlSession.close();
//		
//		return board;
//	}
	
	//게시글 조회수증가
	@Override
	public int increaseCount(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.increaseCount(sqlSession, boardNo);
		
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();			
		}
		sqlSession.close();
		
		return result;
	}
	
	//게시글 상세조회
	@Override
	public Board selectBoard(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Board b = boardDao.selectBoard(sqlSession, boardNo);
		
		sqlSession.close();
		
		return b;
	}

	//댓글 조회
	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {

		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Reply> rlist = boardDao.selectReplyList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return rlist;
	}

	//검색시 게시글 개수 조회
	@Override
	public int selectSearchCount(HashMap<String, String> map) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int count = boardDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		
		return count;
	}

	//검색 게시글목록 조회
	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		
		return list;
	}

	
	


}
