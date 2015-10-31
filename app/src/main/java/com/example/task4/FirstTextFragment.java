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
public class FirstTextFragment extends Fragment {
    private FirstTextFragment instance;

    public static FirstTextFragment getInstance(String param1) {
       FirstTextFragment firstText= new FirstTextFragment();
       Bundle bundle = new Bundle();
        bundle.putString("param1", param1);
        firstText.setArguments(bundle);
        return firstText;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_text, container, false);
        Bundle bundle = getArguments();
        if(bundle != null){
            String param1 = bundle.getString("param1");
            TextView tvParam = (TextView)rootView.findViewById(R.id.param1);
            tvParam.setText(param1);
        }
        else{
            Toast.makeText(getActivity(), "no params", Toast.LENGTH_SHORT).show();
        }
        return rootView;
    }


}
