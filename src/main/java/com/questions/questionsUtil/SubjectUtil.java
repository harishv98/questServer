package com.questions.questionsUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.questions.dbInitializer.DbManager;
import com.questions.test.bean.SubjectBean;

public class SubjectUtil {
	public SubjectBean getSubjectNames(DbManager db,String dept,String sem) throws SQLException {
		ArrayList<String> al = new ArrayList<String>() ;
		SubjectBean sb = new SubjectBean();
		String query = "SELECT subject_name FROM (subject INNER JOIN department ON department.dept_id = subject.Department_dept_id INNER JOIN semester ON semester.semester_id = subject.Semester_semester_id) where semester.semester_num=\""+sem+"\" and department.dept_name=\""+dept+"\"";
		ResultSet rs = db.runSql(query);
		while(rs.next()) {
			al.add(rs.getString(1)); 
		}
		sb.setId(2);
		sb.setSubjectNames(al);
		return sb;
	}
}
