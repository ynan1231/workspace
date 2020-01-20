package cn.yn.test.niukeshuati;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * @author wyn
 *
 */
public class CountString {
	
	public static void main(String[] args) {
		System.out.println("请输入字符串:");
		Scanner scan1 = new Scanner(System.in);
		String s1 = scan1.next();
		
		System.out.println("请输入要查找的字符:");
		Scanner scan2 = new Scanner(System.in);
		String s2 = scan2.next();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < s1.length(); i++) {
			String sIndex = s1.charAt(i) +"";
			if (map.containsKey(sIndex)) {
				map.put(sIndex, map.get(sIndex)+1);
			}else {
				map.put(sIndex, 1);
			}
		}
		
		System.out.println(map.get(s2));
	}

}
