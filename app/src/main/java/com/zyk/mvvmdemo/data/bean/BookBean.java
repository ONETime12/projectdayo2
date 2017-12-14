package com.zyk.mvvmdemo.data.bean;

public class BookBean {
	// ID
	public int id;

	// 标题
	public String title;

	// 描述
	public String description;

	// 图片
	public String picture;

	// 是否推荐
	public boolean isRecommend;

	// 创建时间
	public String dtCreated;

	@Override
	public String toString() {
		return "id: " + id + ", title: " + title + ", description: " + description + ", picture: " + picture
				+ ", isRecommend: " + isRecommend + ", dtCreated: " + dtCreated;
	}

}
