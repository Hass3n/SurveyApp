package com.seniorsteps.seniorsurvey.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse.Course;
import com.seniorsteps.seniorsurvey.R;

import java.util.List;

public class CoursesRecyclerAdapter extends
        RecyclerView.Adapter<CoursesRecyclerAdapter.ViewHolder> {

    List<Course> courses;//date source
    OnItemClick onItemClickListener;

    public void setOnItemClickListener(OnItemClick onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CoursesRecyclerAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= ( LayoutInflater.from(parent.getContext()))//get layout inflater object
                .inflate(R.layout.course_item_view,parent,false);//call inflate to create view in run time

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Course item = courses.get(position);
        holder.name.setText(item.getName());
        holder.desc.setText(item.getDescription());
        if(onItemClickListener!=null){
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,item);
                }
            });
        }

}

    public void SetData(List<Course> courses){
        this.courses= courses;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(courses==null) return 0;
        return courses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView desc;
        View card;

        ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.course_name);
            desc = view.findViewById(R.id.course_desc);
            card = view;
        }
    }

  public   interface OnItemClick{
        void onClick(int pos,Course course);
    }
}
