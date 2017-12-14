package com.zyk.mvvmdemo.helper.recycler;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * BaseItemDecoration class file
 * RecyclerView BaseItemDecoration 类
 *
 *
 * @version $Id: BaseItemDecoration.java 1 2016-09-23 14:56:06Z huan.song $
 * @since 1.0
 */
public class BaseItemDecoration extends RecyclerView.ItemDecoration {
    /**
     * 是否水平滚动
     */
    private boolean mIsHorizontal;

    /**
     * 获取是否水平滚动
     *
     * @return Returns True, or False
     */
    public boolean isHorizontal() {
        return mIsHorizontal;
    }

    /**
     * 设置是否水平滚动
     *
     * @param isHorizontal 是否水平滚动
     */
    public void setHorizontal(boolean isHorizontal) {
        mIsHorizontal = isHorizontal;
    }

    /**
     * 检查当前item是否是最后一行
     *
     * @param pos     item位置
     * @param columns 列数
     * @param size    总记录数
     * @return Returns True, or False
     */
    public boolean isLastRow(int pos, int columns, int size) {
        return isLastRow(isHorizontal(), pos, columns, size);
    }

    /**
     * 检查当前item是否是最后一列
     *
     * @param pos     item位置
     * @param columns 列数
     * @param size    总记录数
     * @return Returns True, or False
     */
    public boolean isLastColumn(int pos, int columns, int size) {
        return isLastColumn(isHorizontal(), pos, columns, size);
    }

    /**
     * 检查当前item是否是最后一行
     *
     * @param isHorizontal 是否水平滚动
     * @param pos          item位置
     * @param columns      列数
     * @param size         总记录数
     * @return Returns True, or False
     */
    public boolean isLastRow(boolean isHorizontal, int pos, int columns, int size) {
        if (isHorizontal) {
            return isLastColumn(false, pos, columns, size);
        }

        size -= size % columns;
        return (pos >= size);
    }

    /**
     * 检查当前item是否是最后一列
     *
     * @param isHorizontal 是否水平滚动
     * @param pos          item位置
     * @param columns      列数
     * @param size         总记录数
     * @return Returns True, or False
     */
    public boolean isLastColumn(boolean isHorizontal, int pos, int columns, int size) {
        if (isHorizontal) {
            return isLastRow(false, pos, columns, size);
        }

        return ((pos + 1) % columns == 0);
    }

    /**
     * 获取列数
     *
     * @param view a RecyclerView
     * @return 列数
     */
    public int getColumns(RecyclerView view) {
        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();

        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }

        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }

        return 1;
    }

}
