package com.dale.particlesystem;

import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import java.util.Random;

/**
 * Created by Dale on 11/12/13.
 */
public class ParticleAnimator extends TranslateAnimation implements Animation.AnimationListener{
    public View view;
    private Point p;
    private Random r;
    private float s;
    public ParticleAnimator (View view, int tX,int tY, int d,Point p,float s,Random r)
    {
        // delta is how much it gets moved
        super(0, 0, tX, tY);
        this.setAnimationListener(this);
        this.setDuration(d);
        this.view = view;
        this.p = p;
        this.r = r;
        this.s = s;
    }
    public void onAnimationEnd(Animation animation) {
    }
    public void onAnimationRepeat(Animation animation) {
        int pX = (int) (r.nextInt(p.x) * s + 0.5f);
        view.setX(pX);
    }
    public void onAnimationStart(Animation animation) {
    }
}