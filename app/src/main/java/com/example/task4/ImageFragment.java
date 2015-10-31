package com.example.task4;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image,container,false);
        ImageView image = (ImageView)rootView.findViewById(R.id.image);
        Glide.with(getActivity())
                .load("http://cs4.pikabu.ru/images/big_size_comm/2015-05_3/14313819838881.jpg")
                .into(image);
        return rootView;
    }


}
