package com.mercacortex.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mercacortex.tablayout.adapter.ViewPagerAdapter;

//Recordar que estamos usando la librería support
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private int[] arrayIcons = {
            R.drawable.appnet,
            R.drawable.arrow_top_left,
            R.drawable.asterisk,
            R.drawable.backup_restore,
            R.drawable.battery_outline
    };

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

        for (String title: getResources().getStringArray(R.array.tabs)){
            tabLayout.addTab(tabLayout.newTab().setText(title));
            //De momento no estamos vinculando nada
        }

        //El ViewPager tiene que tener un adapter
        //Dentro de sí tendrá varios Fragment ->
        //Clase que herede (5 pestañas) de FragmentPagerAdapter
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Recordar que estamos usando la librería support
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                page.animate().rotation(360f);
            }
        });

        //Sincroniza los eventos de selección y arrastre
        //pero el adapter controlará los títulos también
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();

        /*
        //Eventos para hacerlo manualmente
        //Cuando se selecciona una pestaña
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

        //Cuando se arrastra la pestaña
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // Se invoca cuando se seleccione una nueva página (aunque no se complete la animación)
            @Override
            public void onPageSelected(int position) {
                //tabLayout.setScrollPosition(position, 0f, true); // Más suave que el select
                tabLayout.getTabAt(position).select();

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
    }

    //Instancia los iconos
    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(arrayIcons[0]);
        tabLayout.getTabAt(1).setIcon(arrayIcons[1]);
        tabLayout.getTabAt(2).setIcon(arrayIcons[2]);
        tabLayout.getTabAt(3).setIcon(arrayIcons[3]);
        tabLayout.getTabAt(4).setIcon(arrayIcons[4]);
    }
}
