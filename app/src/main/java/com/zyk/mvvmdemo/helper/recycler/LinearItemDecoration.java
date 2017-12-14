package com.zyk.mvvmdemo.helper.recycler;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * LinearItemDecoration class file
 * RecyclerView LinearLayout ItemDecoration 类
 *
 * @author 宋欢 <trotri@yeah.net>
 * @version $Id: LinearItemDecoration.java 1 2016-09-23 14:56:06Z huan.song $
 * @since 1.0
 */
public class LinearItemDecoration extends BaseItemDecoration {
    /**
     * 绘制垂直分隔线
     *
     * @param divider 分隔线
     * @param c       a Canvas
     * @param parent  a RecyclerView
     */
    public void drawVerticalDivider(Drawable divider, Canvas c, RecyclerView parent) {
        int top, bottom;
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) v.getLayoutParams();
            top = v.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(v));
            bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    /**
     * 绘制水平分隔线
     *
     * @param divider 分隔线
     * @param c       a Canvas
     * @param parent  a RecyclerView
     */
    public void drawHorizontalDivider(Drawable divider, Canvas c, RecyclerView parent) {
        int left, right;
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) v.getLayoutParams();
            left = v.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(v));
            right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

}
