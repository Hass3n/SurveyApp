package com.seniorsteps.seniorsurvey.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.seniorsteps.seniorsurvey.API.Requests.AnswersItem;
import com.seniorsteps.seniorsurvey.API.Requests.SurveyRequestParameter;
import com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse.Question;
import com.seniorsteps.seniorsurvey.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecyclerAdapter extends
        RecyclerView.Adapter<QuestionsRecyclerAdapter.ViewHolder> {

    List<Question> questions;//date source
    OnItemClick onItemClickListener;
    int AnswersArray [];
    public void setOnItemClickListener(OnItemClick onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public QuestionsRecyclerAdapter(List<Question> questions) {

        this.questions = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= ( LayoutInflater.from(parent.getContext()))//get layout inflater object
                .inflate(R.layout.question_item_view,parent,false);//call inflate to create view in run time

        return new ViewHolder(view);
    }

    public boolean AnsweredAllQuestions(){
        for(int i=0;i<AnswersArray.length;i++){
            if(AnswersArray[i]==-1){
                return false;
            }
        }
        return true;
    }

    public SurveyRequestParameter PrepareData(){
        SurveyRequestParameter data = new SurveyRequestParameter();
       // data.setAnswers();
        List<AnswersItem> answersItems = new ArrayList<>();
        for(int i =0 ;i<AnswersArray.length;i++){

            AnswersItem item = new AnswersItem();
            item.setQuestionId(questions.get(i).getId());
            if(AnswersArray[i]==R.id.a1)
                item.setAnswer(1);
            if(AnswersArray[i]==R.id.a2)
                item.setAnswer(2);
            if(AnswersArray[i]==R.id.a3)
                item.setAnswer(3);
            if(AnswersArray[i]==R.id.a4)
                item.setAnswer(4);

            answersItems.add(item);


        }
        data.setAnswers(answersItems);
        return data;


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Question item = questions.get(position);
        holder.name.setText(item.getName());
        holder.a1.setText(item.getAnswer1());
        holder.a2.setText(item.getAnswer2());
        holder.a3.setText(item.getAnswer3());
        holder.a4.setText(item.getAnswer4());

        holder.answers.setOnCheckedChangeListener(null);

        if(AnswersArray[position]==-1){
            holder.answers.clearCheck();
        }else {
            holder.answers.check(AnswersArray[position]);
        }

        holder.answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                AnswersArray[position]= checkedId;
            }
        });
        if(onItemClickListener!=null){
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,item);
                }
            });
        }

}

    public void SetData(List<Question> questions){
        this.questions= questions;
        AnswersArray = new int[questions.size()];
        for(int i=0;i<AnswersArray.length;i++)
            AnswersArray[i] = -1;

        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(questions==null) return 0;
        return questions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        RadioButton a1;
        RadioButton a2;
        RadioButton a3;
        RadioButton a4;
        RadioGroup answers;
        View card;

        ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
            a1 = view.findViewById(R.id.a1);
            a2 = view.findViewById(R.id.a2);
            a3 = view.findViewById(R.id.a3);
            a4 = view.findViewById(R.id.a4);
            answers = view.findViewById(R.id.answers);
            card = view;
        }
    }

  public   interface OnItemClick{
        void onClick(int pos, Question question);
    }
}
