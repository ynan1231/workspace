package cn.yn.test.niukeshuati;

import java.util.Scanner;

/**
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * @author wyn
 *
 */
public class Ziyinshu {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			
			int num = scanner.nextInt();
			if (num ==0) {
				System.out.println("退出");
				break;
			}
			if (num == 1) {
				System.out.println(num+"---"+1);
			}else {
				StringBuilder sb = new StringBuilder(num+"---");
				for (int i = 2; i < num; i++) {
					if (num % i == 0) {
						 num = num /i ;
						 sb.append(i+"---");
						 i--;
						
					}
				}
				System.out.println(sb.toString()+num);
			}
			
			
		}
	}
}
