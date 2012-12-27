/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.noday.core.pagination;

import java.util.List;

/**
 * cat Page
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-27
 * @since 
 */
public class Page<M> {

	public static final int DEFAULTSIZE = 15;
	private List<M> rows;
	private int pageIndex = 1;
	private int pageCount = 0;
	private int size = 15;
	private int rowCount = 0;
	
	private int pageBegin = 1;
	private int pageEnd;
	
	/**
	 * 
	 */
	public Page() {
		super();
	}
	public Page(int size) {
		super();
		this.size = size;
	}
	public Page(int pageIndex, int size) {
		super();
		this.pageIndex = pageIndex;
		this.size = size;
	}
	public List<M> getRows() {
		return rows;
	}
	public void setRows(List<M> rows) {
		this.rows = rows;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		int _count = rowCount/size;
		pageCount = (rowCount%size == 0) ? _count : (_count + 1);
		if (pageIndex > pageCount && pageCount != 0) {
			pageIndex = pageCount;
		}
		// 计算 pageBegin pageEnd 前四后五 待测
		if(pageIndex < 6) {
			pageBegin = 1;
			pageEnd = pageCount<10?pageCount:10;
		} else {
			int _end = pageIndex + 5;
			if (pageCount > _end) {
				pageBegin = pageIndex - 4;
				pageEnd = _end;
			} else {
				int _begin = pageCount - 9;
				pageEnd = pageCount;
				pageBegin = _begin>1?_begin:1;
			}
		}
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
}
