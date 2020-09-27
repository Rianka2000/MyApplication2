package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
  public static final String REPLY_EXTRA=  "com.example.myapplication2.replyExtra";
  private TextView textView;
  private EditText editTextReply;
  private Button buttonReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.textView);
        editTextReply=findViewById(R.id.editTextReply);
        buttonReply=findViewById(R.id.buttonReply);

        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }


    public void openSecondActivity(View view) {
        String reply= editTextReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(REPLY_EXTRA,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}