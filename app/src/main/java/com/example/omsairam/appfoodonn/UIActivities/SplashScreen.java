package com.example.omsairam.appfoodonn.UIActivities;

import android.app.Activity;

/**
 * Created by omsairam on 1/15/2016.
 */
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omsairam.appfoodonn.R;

public class SplashScreen extends Activity {
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splashscreen);
        StartAnimations();
    }
    private void StartAnimations() {
        /*Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);*/

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);//translate_to_top
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.bottom_img);
        iv.clearAnimation();
        iv.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.slide_out_up);//translate_to_bottom
        anim.reset();
        ImageView v = (ImageView) findViewById(R.id.top_img);
        v.clearAnimation();
        v.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter);
        anim.reset();
        ImageView vi = (ImageView) findViewById(R.id.logo);
        vi.clearAnimation();
        vi.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter);
        anim.reset();
        ImageView vii = (ImageView) findViewById(R.id.logo_launcher);
        vii.clearAnimation();
        vii.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter);
        anim.reset();
        TextView viii = (TextView) findViewById(R.id.textView);
        viii.clearAnimation();
        viii.startAnimation(anim);

       ;

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();

    }

}