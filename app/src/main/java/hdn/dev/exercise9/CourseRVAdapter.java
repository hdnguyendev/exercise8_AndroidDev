package hdn.dev.exercise9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {
    private ArrayList<Course> courses;
    private Context context;
    CourseRepository res;

    public CourseRVAdapter(ArrayList<Course> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvCourseName.setText(course.getName());
        holder.tvCourseDesc.setText(course.getDescription());
        holder.tvCourseDuration.setText(course.getDuration());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // update, delete here
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle data = new Bundle();
                data.putString("name", course.getName());
                data.putString("desc", course.getDescription());
                data.putString("duration", course.getDuration());
                intent.putExtra("data", data);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCourseName, tvCourseDesc, tvCourseDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tv_courseName);
            tvCourseDesc = itemView.findViewById(R.id.tv_courseDescription);
            tvCourseDuration = itemView.findViewById(R.id.tv_courseDuration);
        }
    }
}
