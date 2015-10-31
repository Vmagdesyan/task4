package com.example.task4;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondTextFragment extends Fragment {
    private SecondTextFragment instance;

    public static SecondTextFragment getInstance(String param2) {
        SecondTextFragment secondText= new SecondTextFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param2", param2);
        secondText.setArguments(bundle);
        return secondText;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second_text, container, false);
        Bundle bundle = getArguments();
        if(bundle != null){
            String param2 = bundle.getString("param2");
            TextView tvParam2 = (TextView)rootView.findViewById(R.id.param2);
            tvParam2.setText(param2);
        }
        else
            Toast.makeText(getActivity(), "no params", Toast.LENGTH_SHORT).show();
        return rootView;
    }


}
