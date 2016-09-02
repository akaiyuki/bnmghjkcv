package com.av.benzandroid.models.fragments;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.av.benzandroid.R;
import com.av.benzandroid.functions.BEngine;
import com.av.benzandroid.functions.core.BaseActivity;
import com.av.benzandroid.models.activity.BlogOneActivity;
import com.av.benzandroid.models.activity.BlogTwoActivity;
import com.av.benzandroid.models.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {

    private TextView mTextBlog1;
    private TextView mTextBlog2;


    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        mTextBlog1 = (TextView) view.findViewById(R.id.txtblog1);
        mTextBlog2 = (TextView) view.findViewById(R.id.txtblog2);

        SpannableString spanString = new SpannableString(mTextBlog1.getText());
        spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
        spanString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanString.length(), 0);
        mTextBlog1.setText(spanString);


        SpannableString spanString2 = new SpannableString(mTextBlog2.getText());
        spanString2.setSpan(new UnderlineSpan(), 0, spanString2.length(), 0);
        spanString2.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString2.length(), 0);
        spanString2.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanString2.length(), 0);
        mTextBlog2.setText(spanString2);


        mTextBlog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BEngine.switchFragment((BaseActivity) getActivity(), new BlogOneFragment(), MainActivity.INSTANCE.getFrameLayout());

            startActivity(new Intent(getActivity(), BlogOneActivity.class));

            }
        });

        mTextBlog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BEngine.switchFragment((BaseActivity) getActivity(), new BlogTwoFragment(), MainActivity.INSTANCE.getFrameLayout());

                startActivity(new Intent(getActivity(), BlogTwoActivity.class));

            }
        });


        return view;
    }

}
