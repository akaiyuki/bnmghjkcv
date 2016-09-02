package com.av.benzandroid.models;

import android.widget.TextView;

import com.leocardz.aelv.library.AelvListViewHolder;

/**
 * Created by CodeSyaona on 9/1/16.
 */
public class ListViewHolder extends AelvListViewHolder {
    private TextView textView;

    public ListViewHolder(TextView textView) {
        super();
        this.textView = textView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
