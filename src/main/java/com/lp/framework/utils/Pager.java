package com.lp.framework.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Pager {
	private int start;				
	private int length;
	
	public static Map<String,Object>  getAoDataMap(String aoData){
		Map<String,Object> aoMap = null;
		JSONArray aoArr = JSONArray.parseArray(aoData);
		if(aoArr!=null&&aoArr.size()>0){
			aoMap = new HashMap<String,Object>();
			int size = aoArr.size();
			for(int i=0;i<size;i++){
				JSONObject obj = aoArr.getJSONObject(i);
				aoMap.put(obj.getString("name"), obj.get("value"));
			}
		}
		return aoMap;
	}
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}		
	
	
}
