package com.mercacortex.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mercacortex.tablayout.adapter.ViewPagerAdapter;

//Recordar que estamos usando la librería support
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Inicializa la Toolbar como ActionBar
        setSupportActionBar(toolbar);

        //Se debe inicializar el TabLayout y crear las pestañas
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // Si voy a crear varias pestañas estáticas no se hace así
        //tabLayout.addTab(tabLayout.newTab().setText("Tab1"));

        for (String title : getResources().getStringArray(R.array.tabs)){
            tabLayout.addTab(tabLayout.newTab().setText(title));
            //De momento no estamos vinculando nada
        }

        //El ViewPager tiene que tener un adapter
        //Dentro de sí tendrá varios Fragment ->
        //Clase que herede (5 pestañas) de FragmentPagerAdapter

        viewPager = (ViewPager) findViewById(R.id.pager);

        //Recordar que estamos usando la librería support
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());    //Viva el ctrlshiftspace

        /*TODO: MIRAR EN CASA
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // Se invoca cuando se seleccione una nueva página (aunque no se complete la animación)
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
