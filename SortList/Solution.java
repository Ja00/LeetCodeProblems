//O(nlogn) indicates a merge-sort implementation, but this solution can't 
//achieve constant space complexity.

class Solution {
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}

    	ListNode slow = head, fast = head, prev = null;

    	while(fast != null && fast.next != null) {
    		prev = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	//divide the list into 2 halves
    	prev.next = null;

    	ListNode l1 = sortList(head);
    	ListNode l2 = sortList(slow);

    	return merge(l1, l2);


    }


    public ListNode merge(ListNode l1, ListNode l2) {

    	ListNode psu = new ListNode(0), cur = psu;

    	while(l1 != null && l2 != null) {
    		if(l1.val < l2.val) {
    			cur.next = l1;
    			l1 = l1.next;
    		} else {
    			cur.next = l2;
    			l2 = l2.next;
    		}
    		cur = cur.next;
    	}

    	if(l1 != null) {
    		cur.next = l1;
    	}

    	if(l2 != null) {
    		cur.next = l2;
    	}

    	return psu.next;

    }
}