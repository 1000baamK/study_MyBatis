package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{

	/*
	 * ����
	 * Connection conn = JDBCTemplate.getConnection();
	 * 
	 */
	private MemberDao memberDao = new MemberDao();
	
	//ȸ�����Կ� �޼ҵ� ����
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

	//�α��ο� �޼ҵ� ����
	@Override
	public Member loginMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginUser = new MemberDao().loginMember(sqlSession, m);
		
		sqlSession.close();
		
		return loginUser;
	}

	//ȸ������ ���� �޼ҵ�
	@Override
	public Member updateMember(Member m) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.updateMember(sqlSession, m);
		
		Member updateUser = null;
		
		if(result>0) { //���� ������ �����Ͽ��ٸ�
			//Ŀ���� ������ ȸ�� ���� ��ȸ�ؼ� ������
			sqlSession.commit();
			
			updateUser = memberDao.selectMember(sqlSession, m);			
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updateUser;
	}
	
	
}
