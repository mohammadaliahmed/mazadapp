package com.appsinventiv.mazad.Utils;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * Created by AliAh on 02/03/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {

//        if (position == 0) {
//            return new LoginFragment();
//        } else {
//            return new RegisterFragment();
//        }

//        else {
//            return new InActiveAds();
//        }
        return  null;
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Login";
            case 1:
                return "Register";

            default:
                return null;
        }
    }

}
