package com.zyk.mvvmdemo.data.bean;

import java.util.List;

public class RequestAdapter {

	public static class ResultList<T> extends Result<DataList<T>> {
	}

	public static class Result<T> {
		// 错误码
		public int errNo;

		// 错误消息
		public String errMsg;

		// 数据
		public T data;

		@Override
		public String toString() {
			return "errNo: " + errNo + ", errMsg: " + errMsg + ", data: { " + ((data == null) ? "" : data.toString())
					+ " }";
		}

	}

	public static class DataList<T> {
		// 总记录数
		public long total;

		// 查询记录数 SELECT * FROM table LIMIT offset, [limit];
		public int limit;

		// 查询起始位置 SELECT * FROM table LIMIT [offset], limit;
		public int offset;

		// 列表
		public List<T> rows;

		@Override
		public String toString() {
			return "total: " + total + ", limit: " + limit + ", offset: " + offset + ", size: "
					+ (rows == null ? 0 : rows.size());
		}

	}

}
