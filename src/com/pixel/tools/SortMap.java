package com.pixel.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import com.pixel.entities.Article;

public class SortMap {
	
	public static List<Article> sortMap(Map map){
		List<Article> list = new ArrayList<>();
		TreeSet<?> set = new TreeSet<Object>(new Comparator(){
			
			@Override
			public int compare(Object arg0, Object arg1) {
				Integer val1 = (Integer) ((Map.Entry) arg0).getValue();
				Integer val2 = (Integer) ((Map.Entry) arg1).getValue();
				
				return val2.compareTo(val1);
			}
		});
		
		System.out.println("Map size : " +map.size());
		set.addAll(map.entrySet());
		System.out.println("set size : " +set.size());
		for(Object set2 : set){
			Map.Entry mapentry = (Map.Entry) set2;
			list.add((Article) mapentry.getKey());
		}
		return list;
	}

}
