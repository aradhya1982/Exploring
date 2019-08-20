package leet.easy;
//  Definition for singly-linked list.
// https://leetcode.com/problems/add-two-numbers/

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
 
public class ReverseListAddition {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		ListNode revL1 = this.reverseList(l1);
//		System.out.println("rev L1");
//		printList(revL1);
		
//		ListNode revL2 = this.reverseList(l2);
//		System.out.println("rev L2");
//		printList(revL2);

		ListNode revL1 = l1;
		ListNode revL2 = l2;

		int remainder = 0;
		ListNode result = null , prevNode= null;
		while (revL1 != null && revL2 != null) {
			int sum = revL1.val + revL2.val + remainder;
			ListNode newNode = new ListNode(sum%10);
			remainder = sum / 10;
			if ( result == null) {
				result = newNode;
				prevNode = newNode;
			} else {
				prevNode.next = newNode;
				prevNode = newNode;
			}
			revL1 = revL1.next;
			revL2 = revL2.next;
		}
		
		if (revL1 != null) {
			while (revL1 != null) {
				int sum = revL1.val + remainder;
				ListNode newNode = new ListNode(sum%10);
				remainder = sum / 10;
				if ( result == null) {
					result = newNode;
					prevNode = newNode;
				} else {
					prevNode.next = newNode;
					prevNode = newNode;
				}
				revL1 = revL1.next;
			}
		}
		
		if (revL2 != null) {
			while (revL2 != null) {
				int sum = revL2.val + remainder;
				ListNode newNode = new ListNode(sum%10);
				remainder = sum / 10;
				if ( result == null) {
					result = newNode;
					prevNode = newNode;
				} else {
					prevNode.next = newNode;
					prevNode = newNode;
				}
				revL2 = revL2.next;
			}
		}
		
		if (remainder != 0) {
			ListNode newNode = new ListNode(remainder);
			prevNode.next = newNode;
		}
		
//        return reverseList(result);
		return result;
    }
    
	/**
	 * 1 --> 2 --> 3 --> 4
	 * currNode = 1
	 * nextNode = 2
	 * loop
	 * 		tempNextNode = nextNode.next // tempNextNode = 3
	 * 		point nextNode.next = currNode // 2 --> 1
	 * 		currNode = nextNode // currNode = 2
	 * 		nextNode = tempNextNode // 3
	 * 
	 */
    public ListNode reverseList(ListNode l) {
        ListNode reverseList = l;
        ListNode currNode = l;
        ListNode nextNode = currNode.next;
        currNode.next = null;
        while (nextNode != null) {
        	ListNode tempNextNode = nextNode.next;
        	nextNode.next = currNode;
        	currNode = nextNode;
        	nextNode = tempNextNode;
        }
        return currNode;
    }
    
    
    
    public static void main(String[] args) {
    	ReverseListAddition r = new ReverseListAddition();
    	
		int[] a = {9,8,7,6,5,4};
		ListNode l1 = createList(a);
		r.printList(l1);
		
		int[] b = {7,6,5,4,3,2,1};
		ListNode l2 = createList(b);
		r.printList(l2);
		
		
		ListNode sum = r.addTwoNumbers(l1, l2);
		r.printList(sum);
		
//		ListNode revNode = r.reverseList(l1);
//		r.printList(revNode);
	}

	private static ListNode createList(int[] a) {
		ListNode l = new ListNode(a[0]);
		ListNode currenNode = l;
		for (int i = 1; i < a.length; i++) {
			ListNode newNode = new ListNode(a[i]);
			currenNode.next = newNode;
			currenNode = newNode;
		}
		return l;
	}

	private void printList(ListNode l) {
		ListNode currentNode = l;
		while (currentNode != null) {
			System.out.print(currentNode.val);
			currentNode = currentNode.next;
		}
		System.out.println();
		
	}

}
