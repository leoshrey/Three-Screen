package com.leoshrey.threescreen.ui.main;

import android.content.Context;

import com.leoshrey.threescreen.R;
import com.leoshrey.threescreen.Screen1Posts;
import com.leoshrey.threescreen.Screen2Messages;
import com.leoshrey.threescreen.Screen3Notifications;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Screen1Posts screen1 = new Screen1Posts();
                return screen1;
            case 1:
                Screen2Messages screen2 = new Screen2Messages();
                return screen2;
            case 2:
                Screen3Notifications screen3 = new Screen3Notifications();
                return screen3;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show as many tabs added
        return TAB_TITLES.length;
    }
}