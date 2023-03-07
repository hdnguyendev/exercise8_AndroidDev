package hdn.dev.exercise9;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class DisplayDataActivity extends AppCompatActivity {
    private ArrayList<Course> courses;
    private CourseRVAdapter adapter;
    private RecyclerView rvCourses;
    CourseRepository res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        // getting

        res = new CourseRepository(getApplication());
        courses = new ArrayList<Course>();
        List<Course> data = res.getAllCourse();
        for (int i = 0; i < data.size(); i++) {
            String name = data.get(i).getName();
            String desc = data.get(i).getDescription();
            String duration = data.get(i).getDuration();

            courses.add(new Course(name, desc, duration));
            Log.i(TAG, "onCreate: COURSE...");
        }
        adapter = new CourseRVAdapter(courses, DisplayDataActivity.this);
        rvCourses = findViewById(R.id.rv_courses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DisplayDataActivity.this, RecyclerView.VERTICAL, false);
        rvCourses.setLayoutManager(linearLayoutManager);
        rvCourses.setAdapter(adapter);
    }

}