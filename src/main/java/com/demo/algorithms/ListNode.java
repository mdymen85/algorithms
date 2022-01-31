package com.demo.algorithms;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    @Override
    public String toString() {
    	ListNode it = this;
    	ListNode newNext = it.next;
    	System.out.print(val);
    	while (newNext != null) {    		
    		System.out.print(newNext.val);
    		newNext = newNext.next;
    		
    	}
    	return val + "";
    }

}