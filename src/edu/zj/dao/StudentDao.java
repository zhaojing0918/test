package edu.zj.dao;

import java.io.IOException;

import edu.zj.pojo.Student;

public interface StudentDao {

	public abstract void insertStudent(Student student) throws IOException;

}