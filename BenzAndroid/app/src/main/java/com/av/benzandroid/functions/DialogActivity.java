package com.av.benzandroid.functions;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.av.benzandroid.R;
import com.av.benzandroid.functions.core.BaseActivity;

/**
 * Created by CodeSyaona on 9/2/16.
 */
public class DialogActivity {


    public static void showDialogEstimate(BaseActivity baseActivity){
        final Dialog dialog = new Dialog(baseActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_pop_up);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));






        dialog.show();

    }


}
