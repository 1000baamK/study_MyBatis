package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{

	/*
	 * 기존
	 * Connection conn = JDBCTemplate.getConnection();
	 * 
	 */
	private MemberDao memberDao = new MemberDao();
	
	//회원가입용 메소드 구현
	@Override
	public int insertMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new MemberDao().insertMember(sqlSession, m);
		
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	//로그인용 메소드 구현
	@Override
	public Member loginMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginUser = new MemberDao().loginMember(sqlSession, m);
		
		sqlSession.close();
		
		return loginUser;
	}

	//회원정보 수정 메소드
	@Override
	public Member updateMember(Member m) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.updateMember(sqlSession, m);
		
		Member updateUser = null;
		
		if(result>0) { //정보 수정이 성공하였다면
			//커밋후 수정된 회원 정보 조회해서 들고오기
			sqlSession.commit();
			
			updateUser = memberDao.selectMember(sqlSession, m);			
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updateUser;
	}
	
	
}
