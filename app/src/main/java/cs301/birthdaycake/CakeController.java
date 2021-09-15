package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

public class CakeController implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {
    private CakeView myCakeView;
    private CakeModel myCakeModel;

    public CakeController(CakeView cv) {
        myCakeView = cv;
        myCakeModel = myCakeView.getCakeModel();
    }

    @Override
    public void onClick(View v) {
        Log.d("CakeController", "Click received");

        switch (v.getId()) {
            case R.id.blowOutButton:
                myCakeModel.candlesLit = !myCakeModel.candlesLit;
                break;

        }

        myCakeView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.candleSwitch:
                myCakeModel.hasCandles = isChecked;
        }

        myCakeView.invalidate();
    }
}
