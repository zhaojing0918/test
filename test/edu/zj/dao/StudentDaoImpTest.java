package edu.zj.dao;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import edu.zj.pojo.Student;

public class StudentDaoImpTest {

	@Test
	public void test() throws IOException {
		StudentDao studentDao = new StudentDaoImp();
		studentDao.insertStudent(new Student("уехЩ"));
	}

}
