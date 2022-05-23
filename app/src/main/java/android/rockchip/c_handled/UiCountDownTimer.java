package android.rockchip.c_handled;

import android.os.CountDownTimer;

/**
 * 防止重複執行續版本
 */
public class UiCountDownTimer extends CountDownTimer {
    private boolean isStatTimer = false; //是否正在執行Tick執行緒中,true:執行中

    public UiCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public void uiCancel() {
        isStatTimer = false;
        this.cancel();
    }

    public void uiStart() {
        if (isStatTimer) return;
        this.start();
    }

    public boolean isStatTimer() {
        return isStatTimer;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        isStatTimer = true;
    }

    @Override
    public void onFinish() {
        isStatTimer = false;
    }


}
