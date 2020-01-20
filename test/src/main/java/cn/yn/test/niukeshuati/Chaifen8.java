package cn.yn.test.niukeshuati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 遇8换行,不足补0
 */
public class Chaifen8 {
	private static final int LENGTH = 8;
	private static final String CHAR = "0";
	public static void main(String[] args) {

		List<String> list  = new ArrayList<String>();
		
		for (int i = 0; i < 2; i++) {
			Scanner scanner2 = new Scanner(System.in);
			if (scanner2.hasNextLine()) {
				String s = scanner2.nextLine();
				if (s.length()<LENGTH) {
					StringBuilder sb = new StringBuilder(s);
					for (int j = s.length(); j < LENGTH; j++) {
						sb.append(CHAR);
					}
					list.add(sb.toString());
				}else {
					for (int j = 0; j < s.length()/LENGTH; j++) {
						StringBuilder temp = new StringBuilder();
						temp.append(s.substring(j*LENGTH,(j+1)*LENGTH));
						list.add(temp.toString());
					}
					if (s.length()%LENGTH!=0) {
						StringBuilder sb = new StringBuilder(s.substring(s.length()/LENGTH*LENGTH,s.length()));
						for (int j = s.length()%LENGTH; j < 8; j++) {
							sb.append(CHAR);
						}
						list.add(sb.toString());
					}
					
				}
			}
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	
	
}
