package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {

	//ȸ�����Կ� �޼ҵ�
	public abstract int insertMember(Member m);
	//�α��ο� �޼ҵ�
	Member loginMember(Member m);
	//�������� �޼ҵ�
	Member updateMember(Member m);
	//ȸ��Ż�� �޼ҵ�
	
	//�α׾ƿ��� �޼ҵ�
}
