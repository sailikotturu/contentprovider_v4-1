package com.example.sailik.contentprovidertask_20_feb;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;


public class MainActivity extends TabActivity {


    TabHost TabHostWindow;
    FloatingActionButton mfabButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHostWindow = (TabHost) findViewById(android.R.id.tabhost);

        //Creating tab menu.
        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec("First tab");
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec("Second Tab");
        TabHost.TabSpec TabMenu3 = TabHostWindow.newTabSpec("Third Tab");


        //Setting up tab 1 name.
        TabMenu1.setIndicator("Saili");
        //Set tab 1 activity to tab 1 menu.
        TabMenu1.setContent(new Intent(this, FragmentTab.class));


        TabMenu2.setIndicator("Vinay");

        TabMenu2.setContent(new Intent(this, FragmentTab2.class));

        TabMenu3.setIndicator("Manasa");

        TabMenu3.setContent(new Intent(this, FragmentTab3.class));



        //Adding tab1, tab2 to tabhost view.

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);

    }



}
