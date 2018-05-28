package edu.zj.tool;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisJdbcTool {
 static	SqlSessionFactory sqlSessionFactory=null;
 //静态块，加载配置文件，初始化SqlSessionFactory
static {
	String resource = Constant.source_path;
	InputStream inputStream;
	try {
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

//静态方法，获取sqlSession
public SqlSession getsqlSession(boolean flag){
	
	return sqlSessionFactory.openSession(flag);
	
}
//静态方法，关闭资源
public void close(SqlSession sqlSession){
	sqlSession.close();
}
}
