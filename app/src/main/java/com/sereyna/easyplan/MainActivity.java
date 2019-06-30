package com.sereyna.easyplan;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.sereyna.easyplan.fragment.main.fragment_complete;
import com.sereyna.easyplan.fragment.main.fragment_main;
import com.sereyna.easyplan.fragment.main.fragment_me;
import com.sereyna.easyplan.fragment.main.fragment_tasklist;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

	private long mExitTime; //连续按两次后退键的时差
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
	/**
	 * switch fragment
	 * @param lastIndex
	 * @param index
	 */
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
*/
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
        getMenuInflater().inflate(R.menu.fragment_main_menu, menu);
        return true;
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

    //再按一次后退键退出
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//判断用户是否点击了“返回键”
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			//与上次点击返回键时刻作差
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				//大于2000ms则认为是误操作，使用Toast进行提示
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				//并记录下本次点击“返回键”的时刻，以便下次进行判断
				mExitTime = System.currentTimeMillis();
			} else {
				//小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
