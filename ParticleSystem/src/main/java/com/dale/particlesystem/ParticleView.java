package com.dale.particlesystem;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dale on 11/12/13.
 */
public class ParticleView extends RelativeLayout {
    List<View> particles=new ArrayList<View>();
    Random r = new Random();
    public ParticleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (10 * scale + 0.5f);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        Display display = wm.getDefaultDisplay();
        display.getSize(size);

        for(int i =0; i < 200; i++){
            View v = new View(context);
            v.setLayoutParams(new GridView.LayoutParams(pixels, pixels));
            int pX = (int) (r.nextInt(size.x) * scale + 0.5f);
            int heightDiff =(int)  (r.nextInt(size.y)* scale + 0.5f);
            int pY = -heightDiff;
            v.setX(pX);
            v.setY(pY);
            v.setBackgroundColor(getResources().getColor(android.R.color.white));
            particles.add(i,v);
            this.addView(v);

            ParticleAnimator anim = new ParticleAnimator(v, 0, size.y+heightDiff,10000+heightDiff,size,scale,r);
            anim.setRepeatCount(Animation.INFINITE);
            anim.setRepeatMode(Animation.INFINITE);

            v.startAnimation(anim);
        }
    }
}
