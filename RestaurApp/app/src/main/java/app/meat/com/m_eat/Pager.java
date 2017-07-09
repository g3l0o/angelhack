package app.meat.com.m_eat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by EduardoYair on 08/07/2017.
 */

public class Pager extends FragmentStatePagerAdapter {
    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }
    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                menuFragmentScreen menu = new menuFragmentScreen();
                return menu;
            case 1:
                MapFragment map = new MapFragment();
                return map;
            default:
                return null;
        }
    }
    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        //return the number of tabs you want in your tabLayout
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //this is where you set the titles
        switch(position) {
            case 0:
                return "Menu";
            case 1:
                return "Mapa";
        }
        return null;
    }

}
