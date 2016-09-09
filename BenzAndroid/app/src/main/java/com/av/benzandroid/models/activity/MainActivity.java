package com.av.benzandroid.models.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.av.benzandroid.functions.BEngine;
import com.av.benzandroid.functions.BSingleton;
import com.av.benzandroid.functions.core.BaseActivity;
import com.av.benzandroid.models.fragments.BlogFragment;
import com.av.benzandroid.models.fragments.CompanyFragment;
import com.av.benzandroid.models.fragments.ContactUsFragment;
import com.av.benzandroid.R;
import com.av.benzandroid.models.fragments.FaqsFragment;
import com.av.benzandroid.models.fragments.RequestFragment;
import com.av.benzandroid.models.fragments.ServicesFragment;
import com.mikepenz.fastadapter.utils.RecyclerViewCacheUtil;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;


public class MainActivity extends BaseActivity {

    private static final int PROFILE_SETTING = 100000;
    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;
    public static MainActivity INSTANCE = null;

    private  Toolbar toolbar;
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        INSTANCE = this;

        // Handle Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set frame layout
        setFrameLayout(R.id.frame_container);


        BEngine.switchFragment(INSTANCE, new CompanyFragment(), getFrameLayout());


        // Create a few sample profile
        // NOTE you have to define the loader logic too. See the CustomApplication for more details

        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.benzlogo)
                .withSavedInstance(savedInstanceState)
                .build();


        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("The Company").withIdentifier(1).withIcon(R.drawable.ic_company_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight)),
                        new PrimaryDrawerItem().withName("Our Services").withIdentifier(2).withIcon(R.drawable.ic_services_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight)),
                        new PrimaryDrawerItem().withName("Request").withIdentifier(3).withIcon(R.drawable.ic_request_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight)),
                        new PrimaryDrawerItem().withName("Blog").withIdentifier(4).withIcon(R.drawable.ic_blog_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight)),
                        new PrimaryDrawerItem().withName("FAQs").withIdentifier(5).withIcon(R.drawable.ic_faqs_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight)),

                        new PrimaryDrawerItem().withName("Contact Us").withIdentifier(6).withIcon(R.drawable.ic_contact_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight)),
                        new PrimaryDrawerItem().withName("Online Payment").withIdentifier(7).withIcon(R.drawable.ic_services_selection).withSelectable(true).withSelectedTextColor(getResources().getColor(R.color.colorHighlight))

                ) // add the items we want to use with our Drawer


                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        if (drawerItem != null) {
                            if (drawerItem.getIdentifier() == 1) {
                                fragment = new CompanyFragment();
                               BEngine.switchFragment(INSTANCE, fragment, getFrameLayout());
                                BSingleton.setTextTitle("The Company");
                                toolbar.setTitle("The Company");
                            } else if (drawerItem.getIdentifier() == 2) {
                                fragment = new ServicesFragment();
                               BEngine.switchFragment(INSTANCE, fragment, getFrameLayout());
                                BSingleton.setTextTitle("Our Services");
                                toolbar.setTitle("Our Services");
                            } else if (drawerItem.getIdentifier() == 3) {
                                fragment = new RequestFragment();
                                BEngine.switchFragment(INSTANCE, fragment, getFrameLayout());
                                BSingleton.setTextTitle("Request");
                                toolbar.setTitle("Request");
                            } else if (drawerItem.getIdentifier() == 4){
                                fragment = new BlogFragment();
                                BEngine.switchFragment(INSTANCE, fragment, getFrameLayout());
                                BSingleton.setTextTitle("Blog");
                                toolbar.setTitle("Blog");
                            } else if (drawerItem.getIdentifier() == 5){
                                fragment = new FaqsFragment();
                                BEngine.switchFragment(INSTANCE, fragment, getFrameLayout());
                                BSingleton.setTextTitle("FAQs");
                                toolbar.setTitle("FAQs");
                            }
                            else if (drawerItem.getIdentifier() == 6) {
                               startActivity(new Intent(MainActivity.this, ContactUsFragment.class));
                                BSingleton.setTextTitle("Contact Us");
//                                BEngine.switchFragment(INSTANCE, new ContactUsFragment(), getFrameLayout());
                            } else if (drawerItem.getIdentifier() == 7){
                                startActivity(new Intent(MainActivity.this, OnlinePaymentActivity.class));
                            }

                        }



                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(false)
                .build();

        //if you have many different types of DrawerItems you can magically pre-cache those items to get a better scroll performance
        //make sure to init the cache after the DrawerBuilder was created as this will first clear the cache to make sure no old elements are in
        //RecyclerViewCacheUtil.getInstance().withCacheSize(2).init(result);
        //noinspection unchecked
        new RecyclerViewCacheUtil<IDrawerItem>().withCacheSize(2).apply(result.getRecyclerView(), result.getDrawerItems());

        //only set the active selection or active profile if we do not recreate the activity
        if (savedInstanceState == null) {
            // set the selection to the item with the identifier 11
            result.setSelection(21, false);
        }




    }


    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                Log.i("material-drawer", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
            } else {
                Log.i("material-drawer", "toggleChecked: " + isChecked);
            }
        }
    };


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();

        }
    }




}
