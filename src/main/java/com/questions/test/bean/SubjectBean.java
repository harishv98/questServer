package com.questions.test.bean;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

@JsonTypeName("subject")
@JsonTypeInfo(
    include = As.WRAPPER_OBJECT,
    use = Id.NAME
)
public class SubjectBean {
	private int id;
	private ArrayList<String> subjectNames = new ArrayList<String>();

	public ArrayList<String> getSubjectNames() {
		return subjectNames;
	}

	public void setSubjectNames(ArrayList<String> subjectNames) {
		this.subjectNames = subjectNames;
	}

	public int getId() {	return id;	}

	public void setId(int id) {	this.id = id;}
	
	
}
