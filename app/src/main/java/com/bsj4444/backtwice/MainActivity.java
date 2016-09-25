package com.bsj4444.backtwice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int flag=0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        initActionBar();
    }
    public void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tol);
        //toolbar.setOnCreateContextMenuListener(this);
        tv.setText("toolBar");
        toolbar.setTitle("瞄~~");
        toolbar.setSubtitle("miu~~");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(flag==0){
            flag=1;
            thread t=new thread();
            t.start();
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
        }
        else{
            super.onBackPressed();
        }
    }
    class thread extends Thread{
        public thread(){}
        public void run(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag=0;
        }
    }
}
