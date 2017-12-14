package com.zyk.mvvmdemo.helper.recycler;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * GridItemDecoration class file
 * RecyclerView GridLayout StaggeredGrid ItemDecoration 类
 *
 * @author 宋欢 <trotri@yeah.net>
 * @version $Id: GridItemDecoration.java 1 2016-09-23 14:56:06Z huan.song $
 * @since 1.0
 */
public class GridItemDecoration extends BaseItemDecoration {
    /**
     * 绘制垂直分隔线
     *
     * @param divider 分隔线
     * @param c       a Canvas
     * @param parent  a RecyclerView
     */
    public void drawVerticalDivider(Drawable divider, Canvas c, RecyclerView parent) {
        int top, bottom, left, right;
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) v.getLayoutParams();
            top = v.getTop() - params.topMargin;
            bottom = v.getBottom() + params.bottomMargin;
            left = v.getRight() + params.rightMargin;
            right = left + divider.getIntrinsicWidth();
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
        int top, bottom, left, right;
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) v.getLayoutParams();
            left = v.getLeft() - params.leftMargin;
            right = v.getRight() + params.rightMargin + divider.getIntrinsicWidth();
            top = v.getBottom() + params.bottomMargin;
            bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

}
