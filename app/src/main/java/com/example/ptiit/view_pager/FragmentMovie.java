package com.example.ptiit.view_pager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptiit.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentMovie extends Fragment {

    private ViewPager pager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        addControl(v);

        return v;
    }

    void addControl(View view) {
        pager = (ViewPager) view.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        FragmentManager manager = getChildFragmentManager();
        PagerAdapter adapter = new ViewPagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.setPageTransformer(true, new HorizontalFlipTransformation());
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);//deprecated
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_fastfood_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_mode_of_travel_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_local_movies_24);
//        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }
}