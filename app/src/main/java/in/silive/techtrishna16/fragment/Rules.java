package in.silive.techtrishna16.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.silive.techtrishna16.R;
import in.silive.techtrishna16.fragment.FragmentFour_Rules;
import in.silive.techtrishna16.fragment.FragmentOne_Rules;
import in.silive.techtrishna16.fragment.FragmentThree_Rules;
import in.silive.techtrishna16.fragment.FragmentTwo_Rules;


public class Rules extends android.support.v4.app.Fragment{


    ViewPager viewPager;
    TabLayout tabs;
    PagerAdapter viewPagerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rules,container,false);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabs=(TabLayout)view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void setupViewPager(ViewPager viewPager){
        viewPagerAdapter=new PagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new FragmentOne_Rules(),"Accomodation");
        viewPagerAdapter.addFragment(new FragmentTwo_Rules(),"Registration");
        viewPagerAdapter.addFragment(new FragmentThree_Rules(), "Transportation");
        viewPagerAdapter.addFragment(new FragmentFour_Rules(), "Miscellaneous");
        viewPager.setAdapter(viewPagerAdapter);
    }
    class PagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentList=new ArrayList<>();
        private final List<String> title_list= new ArrayList<>();
        public PagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            title_list.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title_list.get(position);
        }
    }




}
