package com.example.sanjaya.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SmartFragmentStatePagerAdapter smartFragmentStatePagerAdapter;
    TextView xmlMainTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xmlMainTV=(TextView) findViewById(R.id.xmlMainTV);

        ViewPager viewPager=(ViewPager)findViewById(R.id.xmlMainVP);
        smartFragmentStatePagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(smartFragmentStatePagerAdapter);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.xmlMainTL);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this, "Selected page position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void passingItem (String kata){
        xmlMainTV.setText(kata);
    }


    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentLinker.newInstance(0, "Page #1");
                case 1:
                    return FragmentLinker.newInstance(1, "Page #2");
                default:
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page #" + position;
        }
    }
}
