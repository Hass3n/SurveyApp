package com.seniorsteps.seniorsurvey.API.Requests;

import com.google.gson.annotations.SerializedName;

public class AnswersItem{

	@SerializedName("answer")
	private int answer;

	@SerializedName("question_id")
	private int questionId;

	public void setAnswer(int answer){
		this.answer = answer;
	}

	public int getAnswer(){
		return answer;
	}

	public void setQuestionId(int questionId){
		this.questionId = questionId;
	}

	public int getQuestionId(){
		return questionId;
	}

	@Override
 	public String toString(){
		return 
			"AnswersItem{" + 
			"answer = '" + answer + '\'' + 
			",question_id = '" + questionId + '\'' + 
			"}";
		}
}