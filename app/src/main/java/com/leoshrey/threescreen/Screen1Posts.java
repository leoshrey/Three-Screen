package com.leoshrey.threescreen;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class Screen1Posts extends Fragment {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.screen1posts, container, false);


        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "SIX HEALTHY BREAKFAST FOR YOUR FAMILY", "Greek Yogurt, Oatmeal, Wheat Germ, Banana, Watermelon, Strawberries"));
        models.add(new Model(R.drawable.sticker, "WHO IS THE FATHER OF YOGA? AND WHEN DID YOGA STARTED?", "Yoga originated from India is famous all around the world. It has been proved by many Yoga gurus that any disease can be cured by practicing Yoga regularly."));
        models.add(new Model(R.drawable.poster, "MAHABHARATA WEAPONS – TOP 10 MOST POWERFUL WEAPONS USED IN HINDU EPIC MAHABHARATA", "Vasavi Shakti, Vajra, Narayanastra, Brahmastra, Brahmashirsha, Pashupatastra, Brahmadanda"));
        models.add(new Model(R.drawable.namecard, "10 UNKNOWN FACTS ABOUT ADOLF HITLER THAT YOU DON’T KNOW", "Spying on the Nazis, A messenger in WWI, Looting Artworks, The Nobel Prank, Austrian by birth, Photographing speech practices"));

        adapter = new Adapter(models, this);

        viewPager = root.findViewById(R.id.tu);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                    getActivity().findViewById(R.id.view_pager).setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                    getActivity().findViewById(R.id.view_pager).setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return root;
    }
}
