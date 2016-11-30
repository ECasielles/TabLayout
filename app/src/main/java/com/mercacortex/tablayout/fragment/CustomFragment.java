package com.mercacortex.tablayout.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mercacortex.tablayout.R;

public class CustomFragment extends Fragment {
    public static final String KEY_REG_TEXT = "text";
    private TextView textView;

    public CustomFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflo la vista
        View rootView = inflater.inflate(R.layout.fragment_custom, container, false);
        //Inicializo el TextView
        textView = (TextView) rootView.findViewById(R.id.txvFrgText);
        //Asigno el valor del paquete
        textView.setText(getArguments().getString(KEY_REG_TEXT));
        return rootView;
    }

    //
    public static Fragment newInstance(Bundle arguments) {
        CustomFragment customFragment = new CustomFragment();
        if(arguments != null) {
            customFragment.setArguments(arguments);
        }
        return customFragment;
    }
}
