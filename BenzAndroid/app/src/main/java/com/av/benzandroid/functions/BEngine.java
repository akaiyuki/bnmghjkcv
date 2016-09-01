package com.av.benzandroid.functions;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.av.benzandroid.functions.core.BaseActivity;

/**
 * Created by CodeSyaona on 8/30/16.
 */
public class BEngine {

    public static void switchFragment(BaseActivity baseActivity, Fragment fragment, int frame) {

        FragmentManager fm = baseActivity.getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(frame, fragment);
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.commit();
    }

}
