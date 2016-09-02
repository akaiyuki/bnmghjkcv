package com.av.benzandroid.functions;

/**
 * Created by CodeSyaona on 9/2/16.
 */
public class BSingleton {

    public static String textTitle;

    public static String getTextTitle() {
        return textTitle;
    }

    public static void setTextTitle(String textTitle) {
        BSingleton.textTitle = textTitle;
    }
}
