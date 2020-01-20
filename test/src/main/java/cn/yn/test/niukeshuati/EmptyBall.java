package cn.yn.test.niukeshuati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？
 * ”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 
 * @author wyn
 *
 */
public class EmptyBall {

	private static final int YU = 3; // 多少空瓶子余数

	/**
	 * 置换n个空瓶子
	 * 
	 * @param num
	 * @return
	 */
	public static int replace(int n) {
		int sum = n / YU; // 首次置换
		if (sum < 1) {
			if (n % YU == YU - 1) {
				return 1;
			} else {
				return 0;
			}
		}
		return sum + replace(sum + n % YU);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			List<Integer> list = new ArrayList<Integer>();
			while (scanner.hasNextInt()) {
				int n = scanner.nextInt();
				if (n == 0) {
					break;
				}
				list.add(n);
			}
			for (Integer m : list) {
				System.out.println(replace(m));
			}
		}
	}

}
