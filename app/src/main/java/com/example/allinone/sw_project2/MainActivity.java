package com.example.allinone.sw_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    Animation anim;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        anim=AnimationUtils.loadAnimation(this,R.anim.anim);
        b1.setAnimation(anim);
        b2.setAnimation(anim);


    }
    public void goTouser(View view) {
        Intent intent = new Intent(this, general.class);
        startActivity(intent);
    }
    public void goTomanger(View view) {
        Intent intent = new Intent(this, sign_manger.class);
        startActivity(intent);
    }
}
