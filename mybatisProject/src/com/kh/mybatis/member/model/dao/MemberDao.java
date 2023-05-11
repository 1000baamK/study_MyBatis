package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	//ȸ������ �޼ҵ�
	public int insertMember(SqlSession sqlSession, Member m) {
		
		/*
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("Ű");
		
		pstmt = conn.~~
		*/
		
		/*
		 * sqlSession ���� �����ϴ� �޼ҵ带 ���� sql���� ã�� �����ϰ� ����� �޾ƺ� �� �ִ�.
		 * �ش� sql���� �̿ϼ� ���°� �ƴ϶�� sql���� �ϼ���ų ��ü�� ��������
		 */
		
//		int result = sqlSession.insert("memberMapper.insertMember", m);
//		
//		return result;
		
		//���ٷ� ó���ع�����~
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	//�α��ο� �޼ҵ�
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

	//ȸ�� �������� �޼ҵ�
	public int updateMember(SqlSession sqlSession, Member m) {

		return sqlSession.update("memberMapper.updateMember", m);
	}

	//ȸ����ȣ�� ȸ������ ��ȸ �޼ҵ�
	public Member selectMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.selectMember", m);
	}

}
