package assistant.genuinecoder.s_assistant;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import assistant.genuinecoder.s_assistant.main.AppBase;

public class SplashScreenActivity extends AppCompatActivity {

    private int SLEEP_TIMER = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, AppBase.class);
                startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        }, SLEEP_TIMER);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow() .setFlags (WindowManager.LayoutParams.FLAG_FULSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        setContentView(R.layout.activity_splash_screen);
//        getSupportActionBar().hide();
//        LogoLauncher logoLauncher = new LogoLauncher();
//        logoLauncher.start();

    }

//    private class LogoLauncher extends Thread{
//        public void run () {
//            try {
//                sleep(1000 * SLEEP_TIMER);
//            }catch(InterruptedException e) {
//                e.printStackTrace ();
//            }
//            Intent intent = new Intent (SplashScreenActivity.this, AppCompatActivity.class);
//            startActivity(intent);
//            SplashScreenActivity.this.finish();
//        }
//    }
}
