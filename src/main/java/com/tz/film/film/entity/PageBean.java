package com.tz.film.film.entity;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5888862946459942403L;

	private final int MAX_PAGE_SIZE = 50; //最多每页显示50行
	public static final int DEFAULT_PAGE_SIZE = 8;
	//属性
	private int total; //总记录数
	private int pageSize; //每页显示的记录数，默认是8
	private int pageNum; //总页数
	
	private int first = 1; //第1页
	private int last; //最后1页
	private int previous; //上一页
	private int next; //下一页
	private int current = 1; //当前页,默认是1
	
	private List<T> datas; //存放分页的数据
	
	public PageBean(int total) {
		this(total, DEFAULT_PAGE_SIZE); //默认的每页行数是 8
	}
	
	public PageBean(int total, int pageSize) {
		//赋值
		this.total = total;
		if(pageSize > MAX_PAGE_SIZE) {
			this.pageSize = MAX_PAGE_SIZE;
		} else {
			this.pageSize = pageSize;
		}
		//更新受 pageSize影响的属性
		update();
		
		this.current = 1; //默认当前页就是1
		
		this.next = this.pageNum == 1 ? 1 : this.current + 1;
		this.previous = this.current == 1 ? 1 : this.current - 1;
	}

	public int getTotal() {
		return total;
	}

	public int getPageSize() {
		return pageSize;
	}

	//注意，会影响其它的属性值
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		update();
	}

	private void update() { //更新所有依赖 pageSize的其它属性值
		//根据总记录数和每页记录数，计算出 总页数
		this.pageNum = this.total / this.pageSize;
		if(this.total % this.pageSize != 0) {
			this.pageNum ++;
		}
				
		//给另外的属性赋值
		this.last = this.pageNum; //最后一页，就是总页数
		//此时 this.current的值有可能会大于 this.last
		if(this.current > this.last) {
			//当每页的行数增大后，当前的页码超过最后1页时，则当前页变为最后1页
			this.current = this.last; 
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getCurrent() {
		return current;
	}

	//这个方法会影响一些属性
	public void setCurrent(int current) {
		this.current = current;
		//修改 previous和next
		this.previous = this.current == 1 ? 1 : this.current - 1;
		this.next = this.pageNum == 1 ? 1 : this.current + 1;
		if(this.next > this.last) {
			this.next = this.last; //如果超过最后1行，则等于最后1行
		}
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [total=").append(total).append(", pageSize=").append(pageSize).append(", pageNum=")
				.append(pageNum).append(", first=").append(first).append(", last=").append(last).append(", previous=")
				.append(previous).append(", next=").append(next).append(", current=").append(current).append("]");
		return builder.toString();
	}
}
