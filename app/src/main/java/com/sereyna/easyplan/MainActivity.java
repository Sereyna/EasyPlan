package com.sereyna.easyplan;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import java.util.ArrayList;


import com.sereyna.easyplan.bean.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

	private fragment_main fragment1 = new fragment_main();
	private fragment_tasklist fragment2 = new fragment_tasklist();
	private fragment_complete fragment3 = new fragment_complete();
	private fragment_me fragment4 = new fragment_me();
	private Fragment[] fragments;
	private int lastShowFragment = 0;

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_today:
					if (lastShowFragment != 0) {
						switchFrament(lastShowFragment, 0);
						lastShowFragment = 0;
					}
					return true;
				case R.id.navigation_tasklist:
					if (lastShowFragment != 1) {
						switchFrament(lastShowFragment, 1);
						lastShowFragment = 1;
					}
					return true;
				case R.id.navigation_complete:
					if (lastShowFragment != 2) {
						switchFrament(lastShowFragment, 2);
						lastShowFragment = 2;
					}
					return true;
				case R.id.navigation_me:
					if (lastShowFragment != 3) {
						switchFrament(lastShowFragment, 3);
						lastShowFragment = 3;
					}
					return true;
			}

			return false;
		}
	};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        
		BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
		bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		initFragments();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_today) {
            // Handle the camera action

        } else if (id == R.id.nav_studyplan) {

        } else if (id == R.id.nav_complete) {
			//mTextMessage.setText(R.string.title_today);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


	public void switchFrament(int lastIndex, int index) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.hide(fragments[lastIndex]);
		if (!fragments[index].isAdded()) {
			transaction.add(R.id.lay_container, fragments[index]);
		}
		transaction.show(fragments[index]).commitAllowingStateLoss();
	}

	private void initFragments() {
		fragments = new Fragment[]{fragment1, fragment2, fragment3, fragment4};
		lastShowFragment = 0;
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.lay_container, fragment1)
				.show(fragment1)
				.commit();
	}

}
