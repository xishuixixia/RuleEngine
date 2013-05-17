package com.hxrainbow.rule.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
public class StringKit {

	/**
	 * 字符串为 null 或者为  "" 时返回 true
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim()) ? true : false;
	}
	
	/**
	 * 字符串不为 null 而且不为  "" 时返回 true
	 */
	public static boolean isNotEmpty(String str) {
		return str == null || "".equals(str.trim()) ? false : true;
	}
	/**
	 * 截取两个$之间的内容
	 */
	
	public static List<String> getParamId(String str){
		
		Matcher m=Pattern.compile("\\$(.*?)\\$").matcher(str);
		List<String> list = new ArrayList<String>();
		while(m.find()){
			list.add(m.group(1));
		}
		return list;
	}
	/**
	 * 截取两个@之间的内容
	 */
	
	public static List<String> getStaticVariableId(String str){
		Matcher m=Pattern.compile("\\#(.*?)\\#").matcher(str);
		List<String> list = new ArrayList<String>();
		while(m.find()){
			list.add(m.group(1));
		}
		return list;
	}
	
	/**
	 * 截取两个#之间的内容
	 */
	
	public static List<String> getDynamicVariableId(String str){
		Matcher m=Pattern.compile("\\@(.*?)\\@").matcher(str);
		List<String> list = new ArrayList<String>();
		while(m.find()){
			list.add(m.group(1));
		}
		return list;
	}
	/**
	 * 如果是整数或者小数，则返回true，否则返回false
	 * 
	 * @param str
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-22
	 */
	public static boolean checkStyleOfString(String str){
		return str.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$");
	}
	
	/**
	 * 得到> >= < <= == !=后面的字符串
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-22
	 */
	public static String getConditionOfVariable(String str){
		
		String [] arr = str.split(">(=)?|<(=)?|={1,2}|!=");
		if(arr.length < 2){
			return "";
		}
		return arr[1];
	}
	/**
	 * 检查是否包含+ - × / % 如果包含返回true
	 * 
	 * @param str
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-22
	 */
	public static boolean checkContainOfOperator(String str){
		if(str.indexOf("+") != -1 || str.indexOf("-") != -1|| str.indexOf("*") != -1|| str.indexOf("/") != -1|| str.indexOf("%") != -1){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		String name = "0500";
		System.out.println(checkStyleOfString(name));
	}
}