package cn.yn.test.niukeshuati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 * 
 * @author wyn
 *
 */
public class HexToTen {

	private static final int jinzhi = 16;

	/**
	 * 参数是否是十六进制
	 * 
	 * @param num
	 * @return
	 */
	private static boolean isHex(String num) {
		int i = 0;

		if (num.length() >= 2 && num.charAt(0) == '0' && (num.charAt(1) == 'x' || num.charAt(1) == 'X')) {
			i = 2;
		}
		for (; i < num.length(); i++) {
			char c = num.charAt(i);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f')) {
				continue;
			}
			return false;
		}
		return true;
	}

	/**
	 * 根据字符获取实际值
	 * 
	 * @param ch
	 * @return
	 */
	private static int getHex(char ch) {
		if (ch >= '0' && ch <= '9') {
			return ch - '0';
		}
		if (ch >= 'A' && ch <= 'F') {
			return ch - 'A' + 10;
		}
		if (ch >= 'a' && ch <= 'f') {
			return ch - 'f' + 10;
		}
		throw new RuntimeException("非法字符" + ch);
	}

	/**
	 * 
	 * @param count
	 * @return
	 */
	private static int mi(int count) {
		if (count <= 0) {
			throw new RuntimeException("位数不能小于等于0");
		}
		int num = 1;
		for (int i = 1; i < count; i++) {
			num = num * jinzhi;
		}
		return num;
	}

	public static void main(String[] args) {
		// 输入
//		Scanner scanner = new Scanner(System.in);
//		List<String> inList = new ArrayList<String>();
//		while (scanner.hasNextLine()) {
//			String num = scanner.nextLine();
//			if (!isHex(num)) {
//				System.out.println(num + "不是十六进制");
//			} else {
//				int legth = num.length();
//				if (num.charAt(0) == '0' && (num.charAt(1) == 'x' || num.charAt(1) == 'X')) {
//					legth = num.length() - 2;
//				}
//				int res = 0;
//				for (int i = 1; i <= legth; i++) { // 位数
//					char ch = num.charAt(num.length() - i); // 实际值
//					res += getHex(ch) * mi(i);
//				}
//				System.out.println(res);
//
//			}
//		}
		
		print();
	}
	
	public static void print() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String num = scanner.nextLine();
			num = num.startsWith("0x") || num.startsWith("0X")?num.substring(2):num;
			Integer n = Integer.parseInt(num, 16);
			System.out.println(n);
			
		}
		
	}
}
