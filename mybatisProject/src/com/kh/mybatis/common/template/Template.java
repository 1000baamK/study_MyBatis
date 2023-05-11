package com.kh.mybatis.common.template;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	/*
	 * ���� JDBC
	 *
	 * public static Connection get Connection(){
	 * 		//driver.properties ���� �о DB ������ ��ȯ
	 * }
	 * public static void close(JDBC�� ��ü){
	 * 		//�ݳ�����
	 * }
	 *
	 * public static void commit/rollback(Connection conn){
	 * 		//Ʈ������ ����
	 * }
	 *
	 * */
	
	//���̹�Ƽ��
	
	public static SqlSession getSqlSession() {
		
		//mybatis-config.xml ������ �о�ͼ� sqlSession ��ü ���� �� ��ȯ
		
		SqlSession sqlSession = null;
		
		//SqlSession ��ü�� �����ϱ� ���ؼ��� SqlSessionFactory ��ü�� �ʿ�
		//SqlSessionFactory ��ü�� �����ϱ� ���ؼ��� SqlSessionFactoryBuilder ��ü�� �ʿ�
		
		String resource = "/mybatis-config.xml"; //  /�� �ֻ��� �ҽ�����
		
		try {
			
			//�ڿ����κ��� ���(stream) ���
			InputStream stream = Resources.getResourceAsStream(resource);
			
			//1�ܰ� : new SqlSessionFactoryBuilder() : ��ü ����
			//2�ܰ� : .build(stream) : ��ηκ��� mybatis-config.xml ������ �о���� sqlSessionFactory ��ü ����
			//3�ܰ� : .openSession(false) : sqlSession ��ü ���� �� ������ Ʈ����� ó���� �ڵ� commit ���� ����
			// - openSession() ó�� �Ű������� �����ʾƵ� �⺻�� false
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}