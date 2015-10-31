package com.example.task4;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment implements View.OnClickListener {
    private Button webBtn;
    private Button imageBtn;
    private Button firstTextButton;
    private Button secondTextButton;

    public static final int WEB_BUTTON = 1;
    public static final int IMAGE_BUTTON = 2;
    public static final int TEXT_BUTTON_1 = 3;
    public static final int TEXT_BUTTON_2 = 4;

    public interface OnBtnPress{
        public void btnPressed(int btn);
    }

    private OnBtnPress listener;
    public Main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        webBtn = (Button) rootView.findViewById(R.id.web);
        imageBtn = (Button) rootView.findViewById(R.id.image);
        firstTextButton = (Button) rootView.findViewById(R.id.firstText);
        secondTextButton = (Button) rootView.findViewById(R.id.secondText);
        setOnClickListener();
        return rootView;
    }
    private void setOnClickListener(){
        webBtn.setOnClickListener(this);
        imageBtn.setOnClickListener(this);
        firstTextButton.setOnClickListener(this);
        secondTextButton.setOnClickListener(this);
    }
    public void onClick(View view){
        if(listener != null){
            switch (view.getId()){
                case R.id.web:
                    listener.btnPressed(WEB_BUTTON);
                    break;
                case R.id.image:
                    listener.btnPressed(IMAGE_BUTTON);
                    break;
                case R.id.firstText:
                    listener.btnPressed(TEXT_BUTTON_1);
                    break;
                case R.id.secondText:
                    listener.btnPressed(TEXT_BUTTON_2);
                    break;
            }
        }
    }
    public void setBtnPressListener(OnBtnPress listener){
        this.listener = listener;
    }
    public void removeBtnPressListener(){
        this.listener = null;
    }

}
