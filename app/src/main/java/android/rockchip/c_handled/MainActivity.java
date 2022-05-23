package android.rockchip.c_handled;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    private CountDownTimer countDownTimer;
    private UiCountDownTimer uiCountDownTimer;
    private TextView tvTest;
    private boolean isStartAnimation;
    private int mTickCount = 0;
    private long millisInFuture = 10 * 1000;  //倒數多少秒
    private long countDownInterval = 1 * 1000; //多久間隔一次

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        tvTest = findViewById(R.id.tvTest);
        uiCountDownTimer(millisInFuture, countDownInterval);
    }

    private void uiCountDownTimer(long millisInFuture, long countDownInterval) {
        uiCountDownTimer = new UiCountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onFinish() {
                super.onFinish();
            }

            @Override
            public void onTick(long millisUntilFinished) {
                super.onTick(millisUntilFinished);
                i++;
                tvTest.setText(String.valueOf(i));
                Log.v("hank", "i:" + i + ", millisUntilFinished:" + millisUntilFinished / 1000);
            }
        };
    }


    public void Stop(View view) {
        uiCountDownTimer.uiCancel();
    }

    public void Start(View view) {
        uiCountDownTimer.uiStart();
    }
}