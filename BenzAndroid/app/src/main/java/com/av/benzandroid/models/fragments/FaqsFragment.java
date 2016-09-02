package com.av.benzandroid.models.fragments;


import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.av.benzandroid.R;
import com.av.benzandroid.models.ListAdapter;
import com.av.benzandroid.models.ListItem;
import com.leocardz.aelv.library.Aelv;
import com.leocardz.aelv.library.AelvCustomAction;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaqsFragment extends Fragment {

    private ListView mListView;
    private ArrayList<ListItem> listItems;


    public FaqsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faqs, container, false);

        mListView = (ListView) view.findViewById(R.id.list);



        listItems = new ArrayList<ListItem>();
        mockItems();

        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.custom_list_items, listItems);
        mListView.setAdapter(adapter);


        final Aelv aelv = new Aelv(true, 200, listItems, mListView, adapter, new AelvCustomAction() {
            @Override
            public void onEndAnimation(int position) {
                listItems.get(position).setDrawable(listItems.get(position).isOpen() ? R.drawable.up : R.drawable.down);
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                aelv.toggle(view, position);
            }
        });

        return view;
    }

    private void mockItems() {
        final int COLLAPSED_HEIGHT_1 = 150, COLLAPSED_HEIGHT_2 = 250, COLLAPSED_HEIGHT_3 = 300;
        final int EXPANDED_HEIGHT_1 = 250, EXPANDED_HEIGHT_2 = 300, EXPANDED_HEIGHT_3 = 350, EXPANDED_HEIGHT_4 = 700, EXPANDED_HEIGHT_5 = 1100;

        ListItem listItem = new ListItem("" +
                "Are we offering legal advice as well?" +
                "\r\n" +
                "\r\n" +
                "No, Benz Recovery Pte Ltd does not provide legal advice since we are not " +
                "funcioning as a law firm. However, when we devise our strategies for debt " +
                "collection and when we discuss them with you, we have an in-house legal " +
                "associate to advise you on the best and most economical strategy to collect the debt.");


        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_1, EXPANDED_HEIGHT_5, false);
        listItems.add(listItem);

        listItem = new ListItem("Should the debt be of certain amount before you can avail of the" +
                "services of a Singapore debt collection agency?" +
                "\n" +
                "\n" +
                "You should engage the services of a debt collector as soon as possible. The longer " +
                "the time is from the start of the arrears to the day an action was " +
                "taken to collect the debt, the lesser the chance of recovering the funds.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_3, EXPANDED_HEIGHT_5, false);
        listItems.add(listItem);

        listItem = new ListItem("When should you engage the services of a Singapore debt recovery agency?" +
                "\n" +
                "\n" +
                "Having a reliable debt collection agency is a cheaper option compared to " +
                "pursuing a legal remedy, that is, going to the courts and filing a claim. " +
                "Moreover, hiring a debt collector will produce faster results because an " +
                "agency gets intouch with your debtor as soon as you engage the service. " +
                "Every minute from then on is spent collecting your funds.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_3, EXPANDED_HEIGHT_5, false);
        listItems.add(listItem);

        listItem = new ListItem("Why should you choose Benz Recovery Pte Ltd?" +
                "\n" +
                "\n" +
                "Benz Recovery Pte Ltd is the best agency to collect your funds because: " +
                "\n" +
                "- We have professional and highly competent staff, " +
                "\n" +
                "- We try to reduce your operating expenses as much as possible, " +
                "\n" +
                "- Our services have excellent success rates, " +
                "\n" +
                "- Our incomparable reputation precedes us, and " +
                "\n" +
                "- Our services are available in the entire Singapore.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_1, EXPANDED_HEIGHT_5, false);
        listItems.add(listItem);

        listItem = new ListItem("What information is required for a successful debt recovery?" +
                "\n" +
                "\n" +
                "The information necessary to collect a debt differ in every case. However, we " +
                "initially need the full name of the debtor, last known address, and copies " +
                "of all prior communications with the debtor. Other additional requirements " +
                "will be requested from you in the course of the collection.");
        // setUp IS REQUIRED
        listItem.setUp(COLLAPSED_HEIGHT_1, EXPANDED_HEIGHT_5, false);
        listItems.add(listItem);

    }

}
