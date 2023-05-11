package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	//�Խñ� ���� ��ȸ
	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	//�Խñ� ��� ��ȸ
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		//return (ArrayList)sqlSession.selectList("boardMapper.selectList", pi);
		
		//���̹�Ƽ�������� ����¡ ó���� ���� RowBounds��� Ŭ������ �����Ѵ�.
		//offset : ��� �Խñ��� �ǳʶٰ� ��ȸ�� �������� ���� ��
		//limit : boardLimit(���������� ǥ���� �Խñ� ����)
		int limit = pi.getBoardLimit(); //5
		//currentPage : 1 �϶� offset : 0 / currentPage : 2 �϶� offset : 5 / currentPage : 3 �϶�  offset : 10
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		//RowBounds�� ����Ϸ��� �Ű����� 3��° �ڸ��� �־���Ѵ�. �̋� 2��° �ڸ��� �� ���ް��� ���ٸ� null�� �־��ָ� �ȴ�.
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}

	

//	//�Խñ� ��ȸ������
//	public int countUp(SqlSession sqlSession, Board b) {
//		
//		return sqlSession.update("boardMapper.countUp", b);
//	}
//	
//	//�Խñ� ����ȸ
//	public Board selectBoard(SqlSession sqlSession, Board b) {
//		
//		
//		return sqlSession.selectOne("boardMapper.selectBoard", b);
//	}

	//�Խñ� ��ȸ������
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	//�Խñ� ����ȸ
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}

	//��� ��ȸ
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}

	//�˻��� �Խñ� ����
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}

	//�˻��Խñ۸�� ��ȸ
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

}
