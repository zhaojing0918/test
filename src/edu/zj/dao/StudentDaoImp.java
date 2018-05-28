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
		String resource = "mybatis-config.xml";//加载配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//SqlSession获得数据库连接 SqlSessionFactory 数据库连接工厂  可获取数据库对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//数据库连接对象
		SqlSession session = sqlSessionFactory.openSession(true);
		session.insert("edu.zj.dao.StudentDao.insertStudent",student);
		//关闭连接
		session.close();
	}
}
