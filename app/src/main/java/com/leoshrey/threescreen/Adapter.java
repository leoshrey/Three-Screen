package com.leoshrey.threescreen;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Screen1Posts screen1Posts;

    public Adapter(List<Model> models, Screen1Posts screen1Posts) {
        this.models = models;
        this.screen1Posts = screen1Posts;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = layoutInflater.from(container.getContext());
        View view = layoutInflater.inflate(R.layout.screen1posts, container, false);
        ImageView imageView;
        TextView title, desc;
        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aastik.in/six-healthy-breakfast-family/"));
                    screen1Posts.startActivity(browserIntent);
                } else if (position == 1) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aastik.in/who-is-the-father-of-yoga-and-when-did-yoga-started/"));
                    screen1Posts.startActivity(browserIntent);
                } else if (position == 2) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aastik.in/mahabharata-powerful-weapons/"));
                    screen1Posts.startActivity(browserIntent);
                } else if (position == 3) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aastik.in/unknown-facts-adolf-hitler/"));
                    screen1Posts.startActivity(browserIntent);
                }
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
