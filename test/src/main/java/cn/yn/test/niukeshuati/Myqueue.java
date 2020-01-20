package cn.yn.test.niukeshuati;
/**
 * 使用statck(先进先出)实现queue(先进后出)
 * 实现queue的push（压）、pop（出）、empty（是否空）
 * @author wyn
 *
 */

import java.util.Stack;

public class Myqueue<T> {
	
	//先进入的statck
	private Stack<T> inStack = new Stack<T>();	
	//输出的stack
	private Stack<T> outStack = new Stack<T>();
	
	public void push(T t) {
		synchronized (this) {
			inStack.push(t);
		}
	}
	
	public T pop() {
		
		synchronized (this) {
			if (inStack.isEmpty()) {
				return null;
			}
			//如果输入stack不空,则清空
			if (!outStack.isEmpty()) {
				outStack.clear();
			}
			while (!inStack.isEmpty()) {
				T t = inStack.pop();
				outStack.push(t);
			}
			T result = outStack.pop();
			while (!outStack.isEmpty()) {
				inStack.push(outStack.pop());
			}
			return result;
		}
	}
	
	public boolean isEmpty() {
		return inStack.isEmpty();
	}
	
	public static void main(String[] args) {
		Myqueue<Integer> myqueue = new Myqueue<Integer>();
		myqueue.push(1);
		myqueue.push(2);
		myqueue.push(3);
		myqueue.push(4);
		System.out.println(myqueue.isEmpty());
		System.out.println(myqueue.pop());
		System.out.println(myqueue.pop());
		System.out.println(myqueue.pop());
		System.out.println(myqueue.pop());
		System.out.println(myqueue.pop());
		System.out.println(myqueue.isEmpty());
		
		myqueue.push(5);
		myqueue.push(6);
		
		System.out.println(myqueue.pop());
		System.out.println(myqueue.pop());
		
	}
}
