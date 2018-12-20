package com.xiedang.www.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <P>读取excel的时候,整个excel的返回结果</P>
 * @author 陶焕(13294175866)
 * @date 2016年7月23日 下午1:34:37
 */
public class ExcelReadTotalResult extends BaseObject {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * sheet的个数
	 */
	private int sheetCount;
	
	/**
	 * 每个sheet的数据
	 */
	private List<ExcelReadSheetResult> datas = new ArrayList<ExcelReadSheetResult>();

	public int getSheetCount() {
		return sheetCount;
	}

	public void setSheetCount(int sheetCount) {
		this.sheetCount = sheetCount;
	}

	public List<ExcelReadSheetResult> getDatas() {
		return datas;
	}

	public void setDatas(List<ExcelReadSheetResult> datas) {
		this.datas = datas;
	}
	
}
