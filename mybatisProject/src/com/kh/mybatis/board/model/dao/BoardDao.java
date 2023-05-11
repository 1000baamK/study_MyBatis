package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	//게시글 개수 조회
	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	//게시글 목록 조회
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		//return (ArrayList)sqlSession.selectList("boardMapper.selectList", pi);
		
		//마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공한다.
		//offset : 몇개의 게시글을 건너뛰고 조회할 것인지에 대한 값
		//limit : boardLimit(한페이지에 표시할 게시글 개수)
		int limit = pi.getBoardLimit(); //5
		//currentPage : 1 일때 offset : 0 / currentPage : 2 일때 offset : 5 / currentPage : 3 일때  offset : 10
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		//RowBounds를 사용하려면 매개변수 3번째 자리에 넣어야한다. 이떄 2번째 자리에 들어갈 전달값이 없다면 null로 넣어주면 된다.
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}

	

//	//게시글 조회수증가
//	public int countUp(SqlSession sqlSession, Board b) {
//		
//		return sqlSession.update("boardMapper.countUp", b);
//	}
//	
//	//게시글 상세조회
//	public Board selectBoard(SqlSession sqlSession, Board b) {
//		
//		
//		return sqlSession.selectOne("boardMapper.selectBoard", b);
//	}

	//게시글 조회수증가
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	//게시글 상세조회
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}

	//댓글 조회
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}

	//검색시 게시글 개수
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}

	//검색게시글목록 조회
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

}
