package hdn.dev.exercise9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    private EditText ed_name, ed_desc, ed_duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaiil);

        ed_name = findViewById(R.id.ed_name);
        ed_desc = findViewById(R.id.ed_desc);
        ed_duration = findViewById(R.id.ed_duration);


        Intent intent = getIntent();
        Bundle data  = intent.getBundleExtra("data");
        ed_name.setText(data.getString("name"));
        ed_desc.setText(data.getString("desc"));
        ed_duration.setText(data.getString("duration"));


    }
}