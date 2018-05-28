package edu.zj.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.zj.pojo.Student;

public class StudentDaoImp implements StudentDao {
	/* (non-Javadoc)
	 * @see edu.zj.dao.StudentDao#insertStudent(edu.zj.pojo.Student)
	 */
	@Override
	public void insertStudent(Student student) throws IOException {
		String resource = "mybatis-config.xml";//���������ļ�
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//SqlSession������ݿ����� SqlSessionFactory ���ݿ����ӹ���  �ɻ�ȡ���ݿ����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//���ݿ����Ӷ���
		SqlSession session = sqlSessionFactory.openSession(true);
		session.insert("edu.zj.dao.StudentDao.insertStudent",student);
		//�ر�����
		session.close();
	}
}
