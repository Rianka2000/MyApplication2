package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="com.example.myapplication2.extraMessage";
    private static final int REPLY_REQUEST= 1;
    private EditText editTextMessage;
    private TextView textViewReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMessage =findViewById(R.id.editTextMessage);
        textViewReply=findViewById(R.id.textViewReply);
    }

    public void openSecondActivity(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        String message =editTextMessage.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,REPLY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==REPLY_REQUEST){
            if (resultCode==RESULT_OK && data != null) {
              String reply = data.getStringExtra(SecondActivity.REPLY_EXTRA);
              if(reply!=null && !reply.isEmpty()){
                  textViewReply.setVisibility(View.VISIBLE);
                  textViewReply.setText(reply);
            }
            }
        }
    }
}