package com.example.zoo88115.imageswitchview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewAnimator;
import android.widget.ViewSwitcher;


public class MainActivity extends ActionBarActivity {
    private ImageSwitcher is_imageSwitcher;
    private Integer[] images={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9};
    private Button btn_next,btn_last;
    private Button btn_next2,btn_last2;
    private Button btn_ChangeActivity,btn2_ChangeActivity,btn3_ChangeActivity;
    private int index=0;
    private ViewAnimator viewAnimator;
    private Animation slide_in_left, slide_out_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        is_imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher);
        btn_last=(Button)findViewById(R.id.button);
        btn_next=(Button)findViewById(R.id.button2);
        btn_last2=(Button)findViewById(R.id.button4);
        btn_next2=(Button)findViewById(R.id.button5);
        btn_ChangeActivity=(Button)findViewById(R.id.button3);
        btn2_ChangeActivity=(Button)findViewById(R.id.button6);
        btn3_ChangeActivity=(Button)findViewById(R.id.button7);
        is_imageSwitcher.setFactory(new ImageViewFactory(this));
        is_imageSwitcher.setImageResource(images[index]);
        viewAnimator = (ViewAnimator)findViewById(R.id.viewAnimator);
        slide_in_left = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        viewAnimator.setInAnimation(slide_in_left);
        viewAnimator.setOutAnimation(slide_out_right);
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAnimator.showPrevious();
            }
        });
        btn_last2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAnimator.showNext();
            }
        });
        btn_ChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2Activity.class);
                startActivity(intent);
            }
        });
        btn2_ChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });
        btn3_ChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickLast(View v){
        is_imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
       // is_imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        if(index>=0&&index<images.length){
            index--;
            if (index<0)
                index=images.length-1;
            is_imageSwitcher.setImageResource(images[index]);
        }
    }
    public void onClickNext(View v){
        //is_imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
        is_imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
       // is_imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
        if(index>=0&&index<images.length-1){
            index++;
            is_imageSwitcher.setImageResource(images[index]);
        }else{
            index=0;
            is_imageSwitcher.setImageResource(images[index]);
        }
    }

    class ImageViewFactory implements ViewSwitcher.ViewFactory{
        private Context context;
        public ImageViewFactory(Context context){
            this.context=context;
        }
        @Override
        public View makeView(){
            ImageView iv=new ImageView(this.context);
            return iv;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
