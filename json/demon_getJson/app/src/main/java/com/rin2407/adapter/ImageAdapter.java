package com.rin2407.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.rin2407.fragment.ImageFragment;
import com.rin2407.models.Image;

import java.util.List;

public class ImageAdapter extends FragmentStatePagerAdapter {

    private List<Image> list;

    public ImageAdapter(@NonNull FragmentManager fm, int behavior, List<Image> images) {
        super(fm, behavior);
        list = images;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ImageFragment fragment = ImageFragment.newInstance(list.get(position));


        return fragment;
    }

    @Override
    public int getCount() {
        if (list == null)
            return 0;
        return list.size();
    }
}
