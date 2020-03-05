package com.potato.entity;

import java.util.List;
/**
 * 业务对象分页类
 * @author ghw
 *
 */
public class SPage {
	public Integer offset;						//起始条目数
	public Integer pageSize;					//查询条目数
	public List<?> aaData;					//数据集合
	public Integer iTotalDisplayRecords;	//总条目数
	public Integer iTotalRecords;			//显示条目数
	
	public Integer curPage;
	
	
	public List<?> getAaData() {
		return aaData;
	}
	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getOffset() {
		if(offset==null) {
			return 0;
		}
		return offset;
	}
	public int getOffsetAddOne() {
		if(offset==null) {
			return 1;
		}
		return offset+1;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		if(pageSize==null) {
			return 10;
		}
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurPage() {
		if(offset==null||offset<=0) {
			curPage=1;
		}else{
			curPage = offset/pageSize+1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
}
