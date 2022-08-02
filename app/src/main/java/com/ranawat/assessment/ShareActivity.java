package com.ranawat.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShareActivity extends AppCompatActivity {

    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        share=findViewById(R.id.share);
        share.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Check out the cool Music");
            intent.putExtra(Intent.EXTRA_TEXT, "Your Application Link Here.  \n\n    http://pandora.yilstaging.com/writable/uploads/20210127/1611811599_2ac19cd41e8387119d7e.mp3"+getPackageName());
            startActivity(Intent.createChooser(intent, "Choose Me"));
        });

    }
}