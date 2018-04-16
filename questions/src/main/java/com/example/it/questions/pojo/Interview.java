package com.example.it.questions.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interview{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    private String problem;
    private String answer;
    private String flag;
	private String func;//模块
	private String category;//类别

	public Interview() {
	}

	public Interview(String problem, String answer, String flag, String func, String category) {
		this.problem = problem;
		this.answer = answer;
		this.flag = flag;
		this.func = func;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Interview{" +
				"id=" + id +
				", problem='" + problem + '\'' +
				", answer='" + answer + '\'' +
				", flag='" + flag + '\'' +
				", func='" + func + '\'' +
				", category='" + category + '\'' +
				'}';
	}
}
