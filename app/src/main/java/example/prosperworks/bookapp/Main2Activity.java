package example.prosperworks.bookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    EditText titleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Bundle b = getIntent().getExtras();
        final Book book = (Book)b.getSerializable("book");
        // Image
        titleTV = (EditText) findViewById(R.id.title);
        titleTV.setText(book.getTitle());
        Button saveBtn = (Button) findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean edit = !book.getTitle().equals(titleTV.getText().toString());
                Intent intentMessage=new Intent();
                book.setTitle(titleTV.getText().toString());

                intentMessage.putExtra("update",edit);
                intentMessage.putExtra("book",book);
                intentMessage.putExtra("pos",b.getInt("pos"));
                // Set The Result in Intent
                setResult(0,intentMessage);
                // finish The activity
                finish();
            }
        });
    }
}
