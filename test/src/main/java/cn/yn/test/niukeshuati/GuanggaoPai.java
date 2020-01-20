package cn.yn.test.niukeshuati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 有三种广告牌，A、B和C，其中A占一块，B占两块，C占三块；并且A不能与A相邻，B、C没有限制。

输入广告区域总长度n，求有几种放置广告牌的方案。
.
回溯法
回溯法（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。
但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
 */
public class GuanggaoPai {
	
	private static int[] le = {1,2,3};
	public static void sum(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] nums = new int[n];
		add(result, n, nums, 0);
		System.out.println(result.size());
		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(i+"  ");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param result	存放结果
	 * @param remain 还剩多少长度
	 * @param nums 方案存储
	 * @param numCount	当前第几块 下标
	 */
	public static void add(List<List<Integer>> result,int remain,int[] nums,int numCount) {
		if (remain==0) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < numCount; i++) {
				temp.add(nums[i]);
			}
			result.add(temp);
		}else if (remain>0) {
			for (int i = 0; i < le.length; i++) {
				//过滤 
				if (!(numCount>0 && le[i]==1 && nums[numCount-1]==1)) {
					nums[numCount] = le[i];
					add(result, remain-le[i], nums, numCount+1);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			sum(scanner.nextInt());
		}
	}
	
	
	/**
	 * 网上方法
	 */
	 public static List<List<Integer>> combinationSum( int target){
	        int[] cans={1,2,3};
	        List<List<Integer>> result = new ArrayList<>();
	        int[] length = new int[target];
	        backtrack(result,length,cans,target,0);
	        System.out.println(result.size());
	        return result;
	    }
	 
	    /**
	     * @param result 存放结果的list
	     * @param nums 当前遍历的结果
	     * @param cans 代表三种广告牌的长度
	     * @param remain 放置广告牌后的剩余长度
	     * @param numcount 当前为放置的第几块
	     */
	    public static void backtrack(List<List<Integer>> result,int[] nums,int[] cans,int remain,int numcount){
	        if(remain == 0){
	            List<Integer> list = new ArrayList<>();
	            for (int i = 0; i < numcount; i++) {
	                list.add(nums[i]);
	            }
	            result.add(list);
	        }else if(remain < 0){
	        }else {
	            for (int i = 0; i < 3; i++) {
	                if(i!=0||numcount==0||nums[numcount-1]!=cans[0]){
	                    nums[numcount] =cans[i];
	                    backtrack(result,nums,cans,remain-cans[i],numcount+1);
	                }
	            }
	        }
	    }
	    
	    
}
	    
