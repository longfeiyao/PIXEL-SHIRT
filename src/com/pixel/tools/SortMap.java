package com.pixel.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.pixel.entities.Article;

public class SortMap {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Article> sortMap(final Map map){
		List<Article> list = new ArrayList<>();
		
		TreeMap<Object,Object> set = new TreeMap<Object,Object>(new Comparator(){
			
			@Override
			public int compare(Object arg0, Object arg1) {
				Integer val1 = (Integer) map.get(arg0);
				Integer val2 = (Integer) map.get(arg1);
				if(val2.compareTo(val1)==0){
					return 1;
				}else{
					return val2.compareTo(val1);
				}
			}
		});
		
		//System.out.println("Map size : " +map.size());
		
		for(Object article : map.keySet()){
			Object val = map.get(article);
			//System.out.println("Val size : " + (Integer) val);
			set.put(article, val);
		}
		//System.out.println("set size : " +set.size());
		for(Object set2 : set.entrySet()){
			Map.Entry mapentry = (Map.Entry) set2;
			list.add((Article) mapentry.getKey());
		}
		return list;
	}

}
