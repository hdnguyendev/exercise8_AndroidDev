package hdn.dev.exercise9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText tfCourseName, tfCourseDesc, tfCourseDuration;
    private Button btnAddCourse, btnReadCourses;

    CourseRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init all our variables

        tfCourseName = findViewById(R.id.tf_courseName);
        tfCourseDesc = findViewById(R.id.tf_courseDescription);
        tfCourseDuration = findViewById(R.id.tf_courseDuration);
        btnAddCourse = findViewById(R.id.btn_addCourse);
        btnReadCourses = findViewById(R.id.btn_readCourse);

        res = new CourseRepository(getApplication());
        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse();
            }
        });
        btnReadCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayDataActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addCourse() {
        String courseName = tfCourseName.getText().toString();
        String courseDesc = tfCourseDesc.getText().toString();
        String courseDuration = tfCourseDuration.getText().toString();
        Course course = new Course(courseName,courseDesc, courseDuration);
        res.insert(course);


        Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
        tfCourseName.setText("");
        tfCourseDesc.setText("");
        tfCourseDuration.setText("");
    }
}
