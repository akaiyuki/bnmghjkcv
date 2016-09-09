package com.av.benzandroid.models.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.av.benzandroid.R;

import net.cachapa.expandablelayout.ExpandableLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaqFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_faq, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SimpleAdapter(recyclerView));

        return rootView;
    }

    private static class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
        private static final int UNSELECTED = -1;

        private RecyclerView recyclerView;
        private int selectedItem = UNSELECTED;


        public SimpleAdapter(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return 5;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private ExpandableLayout expandableLayout;
            private TextView expandButton;
            private int position;
            private TextView content;

            public ViewHolder(View itemView) {
                super(itemView);

                expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
                expandButton = (TextView) itemView.findViewById(R.id.expand_button);

                content = (TextView) itemView.findViewById(R.id.txtcontent);

                expandButton.setOnClickListener(this);
            }

            public void bind(int position) {
                this.position = position;

//                expandButton.setText(position + ". Tap to expand");

                if (this.position == 0){
                    expandButton.setText("Are we offering legal advice as well?");
                } else if (this.position == 1){
                    expandButton.setText("Should the debt be of certain amount before you can avail of the " +
                            "services of a Singapore debt collection agency?");
                } else if (this.position == 2){
                    expandButton.setText("When should you engage the services of a Singapore debt recovery agency?");
                } else if (this.position == 3){
                    expandButton.setText("Why should you choose Benz Recovery Pte Ltd?");
                } else if (this.position == 4){
                    expandButton.setText("What information is required for a successful debt recovery?");
                }

                Drawable img = recyclerView.getResources().getDrawable( R.drawable.down);
                img.setBounds( 0, 0, 60, 60 );
                expandButton.setCompoundDrawables( img, null, null, null );

                expandButton.setSelected(false);
                expandableLayout.collapse(false);
            }

            @Override
            public void onClick(View view) {
                ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);


                if (holder != null) {
                    holder.expandButton.setSelected(false);
                    holder.expandableLayout.collapse();


                }

                if (position == 0){
                    content.setText("No, Benz Recovery Pte Ltd does not provide legal advice since we are not " +
                            "funcioning as a law firm. However, when we devise our strategies for debt" +
                            " collection and when we discuss them with you, we have an in-house legal" +
                            " associate to advise you on the best and most economical strategy to collect the debt.");
                } else if (position == 1){
                    content.setText("You should engage the services of a debt collector as soon as possible. The longer " +
                            "the time is from the start of the arrears to the day an action was " +
                            "taken to collect the debt, the lesser the chance of recovering the funds.");
                } else if (position == 2){
                    content.setText("Having a reliable debt collection agency is a cheaper option compared to " +
                            "pursuing a legal remedy, that is, going to the courts and filing a claim. " +
                            "Moreover, hiring a debt collector will produce faster results because an " +
                            "agency gets intouch with your debtor as soon as you engage the service. " +
                            "Every minute from then on is spent collecting your funds.");
                } else if (position == 3){
                    content.setText("Benz Recovery Pte Ltd is the best agency to collect your funds because: " +
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
                } else if (position == 4){
                    content.setText("The information necessary to collect a debt differ in every case. However, we " +
                            "initially need the full name of the debtor, last known address, and copies " +
                            "of all prior communications with the debtor. Other additional requirements " +
                            "will be requested from you in the course of the collection.");
                }

                if (position == selectedItem) {
                    selectedItem = UNSELECTED;

                    Drawable img = recyclerView.getResources().getDrawable( R.drawable.down);
                    img.setBounds( 0, 0, 60, 60 );
                    expandButton.setCompoundDrawables( img, null, null, null );

                } else {
                    expandButton.setSelected(true);
                    expandableLayout.expand();
                    selectedItem = position;

                    Drawable img = recyclerView.getResources().getDrawable( R.drawable.up);
                    img.setBounds( 0, 0, 60, 60 );
                    expandButton.setCompoundDrawables( img, null, null, null );
                }
            }
        }
    }
}