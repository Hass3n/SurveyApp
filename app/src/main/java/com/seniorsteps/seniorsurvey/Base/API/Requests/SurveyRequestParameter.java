package com.seniorsteps.seniorsurvey.API.Requests;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurveyRequestParameter{

	@SerializedName("answers")
	private List<AnswersItem> answers;

	@SerializedName("opinion")
	private String opinion;

	public void setAnswers(List<AnswersItem> answers){
		this.answers = answers;
	}

	public List<AnswersItem> getAnswers(){
		return answers;
	}

	public void setOpinion(String opinion){
		this.opinion = opinion;
	}

	public String getOpinion(){
		return opinion;
	}

	@Override
 	public String toString(){
		return 
			"SurveyRequestParameter{" + 
			"answers = '" + answers + '\'' + 
			",opinion = '" + opinion + '\'' + 
			"}";
		}
}