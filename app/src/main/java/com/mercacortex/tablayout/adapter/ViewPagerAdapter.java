package com.mercacortex.tablayout.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mercacortex.tablayout.R;
import com.mercacortex.tablayout.fragment.CustomFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, int tabCount, Context context) {
        super(fm);
        this.tabCount = tabCount;
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //super.getPageTitle(position);
        //Podemos devolver directamente el array de la memoria
        //porque no vamos a cambiar las pestañas en tiempo de ejecución
        return context.getResources().getStringArray(R.array.tabs)[position];
    }

    //Aquí también puedo hacer la gestión de todos los iconos,
    //botones flotantes, etc.
    @Override
    public Fragment getItem(int position) {
        //La gente se crea varias clases Fragment iguales
        //y aquí pone un switch con varios return

        CustomFragment fragment = null;
        Bundle arguments = new Bundle();

        //En este switch se selecciona qué fragment se carga
        switch (position) {
            case 0:
                arguments.putString(CustomFragment.KEY_REG_TEXT, "Tab 1");
                fragment = CustomFragment.newInstance(arguments);
                break;
            case 1:
                arguments.putString(CustomFragment.KEY_REG_TEXT, "Tab 2");
                fragment = CustomFragment.newInstance(arguments);
                break;
            case 3:
                arguments.putString(CustomFragment.KEY_REG_TEXT, "Tab 3");
                fragment = CustomFragment.newInstance(arguments);
                break;
            case 4:
                arguments.putString(CustomFragment.KEY_REG_TEXT, "Tab 4");
                fragment = CustomFragment.newInstance(arguments);
                break;
            case 5:
                arguments.putString(CustomFragment.KEY_REG_TEXT, "Tab 5");
                fragment = CustomFragment.newInstance(arguments);
                break;
        }
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
