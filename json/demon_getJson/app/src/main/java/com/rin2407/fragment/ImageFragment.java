package com.rin2407.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.rin2407.demon_getjson.R;
import com.rin2407.models.Image;

public class ImageFragment extends Fragment {

    private ImageView img;
    private TextView textView;
    private String name;
    private String text;

    public static ImageFragment newInstance(Image image) {
        Bundle bundle = new Bundle();
        bundle.putString("name", image.getName());
        bundle.putString("description", image.getDescription());
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getActivity() != null) {
            name = getArguments().getString("name", "");
            text = getArguments().getString("description");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(getActivity()).load(name).into(img);
        textView.setText(text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        img = view.findViewById(R.id.imgImage);
        textView = view.findViewById(R.id.tvName);
        return view;
    }
}
