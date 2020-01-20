package cn.yn.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。

返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。

 *输入：[3,2,4,1]
输出：[4,2,4,3]
解释：
我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
初始状态 A = [3, 2, 4, 1]
第一次翻转后 (k=4): A = [1, 4, 2, 3]
第二次翻转后 (k=2): A = [4, 1, 2, 3]
第三次翻转后 (k=4): A = [3, 2, 1, 4]
第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。 

1 <= A.length <= 100
A[i] 是 [1, 2, ..., A.length] 的排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pancake-sorting
 */
public class JianBingFanZuan {
	
	 public List<Integer> pancakeSort(int[] A) {
	        List<Integer> result = new ArrayList<Integer>();
	        sortFanZuan(result,A,getMax(A, A.length),A.length);
	        return result;
	    }
	 
	 private void sortFanZuan(List<Integer> result, int[] a, int max,int reMain) {
		 if (reMain<=1) {
			return;
		}
		if (max != reMain) {
			if (max!= 1) {
				result.add(max);
				fanzuan(a,max);
			}
			result.add(reMain);
			fanzuan(a, reMain);
		}
		sortFanZuan(result,a,getMax(a, reMain-1),reMain-1);
		
	}
	 /**
	  * 反转下标n之前的
	  * @param A
	  * @param n
	  */
	 private void fanzuan(int[] A,int n) {
		 for (int i = 0; i <= (n-1)/2; i++) {
			int temp = A[i];
			A[i] = A[n-1-i];
			A[n-1-i] = temp;
		}
		 print(A);
	 }
	 private void print(int[] a) {
		 System.out.println();
		 System.out.print("[");
		 for (int i : a) {
			System.out.print(i+" ");
		}
		 System.out.print("]");
		 System.out.println();
	 }

	public int getMax(int[] A,int n) {
		int max = A[0],index = 0;
		for (int i = 0; i < n; i++) {
			if(A[i]>=max) {
				max = A[i];
				index = i;
			}
		}
		return index+1;
	}
		
	/**
	 * 我们从数组 A 中的最大值向最小值依次进行枚举，每一次将枚举的元素放到正确的位置上。

每一步，对于在位置 i 的（从大到小枚举的）元素，我们会使用思路中提到的煎饼翻转组合操作将它移动到正确的位置上。 值得注意的是，执行一次煎饼翻转操作 f，会将位置在 i, i <= f 的元素翻转到位置 f+1 - i 上。

	 */
	   public List<Integer> pancakeSort2(int[] A) {
	        List<Integer> ans = new ArrayList();
	        int N = A.length;

	        Integer[] B = new Integer[N];
	        for (int i = 0; i < N; ++i)
	            B[i] = i+1;
	        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

	        for (int i: B) {
	            for (int f: ans)
	                if (i <= f)
	                    i = f+1 - i;
	            ans.add(i);
	            ans.add(N--);
	        }

	        return ans;
	    }

	 public static void main(String[] args) {
		 JianBingFanZuan zuan = new JianBingFanZuan();
		int[] a  =  {3,2,4,1};
		System.out.println(zuan.pancakeSort2(a));
		int[]  b =  {3,2,4,1};
		System.out.println(zuan.pancakeSort(b));
	}

}
