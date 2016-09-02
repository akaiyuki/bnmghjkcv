package com.av.benzandroid.models;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.av.benzandroid.R;

import java.util.ArrayList;

/**
 * Created by CodeSyaona on 9/1/16.
 */
public class ListAdapter extends ArrayAdapter<ListItem> {
    private ArrayList<ListItem> listItems;
    private Context context;

    public ListAdapter(Context context, int textViewResourceId, ArrayList<ListItem> listItems) {
        super(context, textViewResourceId, listItems);
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    @SuppressWarnings("deprecation")
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder holder = null;
        ListItem listItem = listItems.get(position);

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.custom_list_items, null);

            LinearLayout textViewWrap = (LinearLayout) convertView.findViewById(R.id.text_wrap);
            TextView text = (TextView) convertView.findViewById(R.id.text);

            holder = new ListViewHolder(text);

            // setViewWrap IS REQUIRED
            holder.setViewWrap(textViewWrap);

        } else {
            holder = (ListViewHolder) convertView.getTag();
        }

        // THIS IS REQUIRED
        holder.getViewWrap().setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, listItem.getCurrentHeight()));

        holder.getTextView().setText(listItem.getText());

        holder.getTextView().setCompoundDrawablesWithIntrinsicBounds(listItem.getDrawable(), 0, 0, 0);

        convertView.setTag(holder);

        // setHolder IS REQUIRED
        listItem.setHolder(holder);

        return convertView;
    }

}
