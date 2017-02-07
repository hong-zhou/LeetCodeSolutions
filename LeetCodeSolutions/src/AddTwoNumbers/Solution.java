
/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Subscribe to see which companies asked this question
*/

/********************************************************************************************
   The pseudocode is as following:

Initialize current node to dummy head of the returning list.
Initialize carry to 00.
Initialize p and q to head of l1 and l2 respectively.
Loop through lists l1 and l2 until you reach both ends.
Set x to node pp's value. If p has reached the end of l1, set to 0.
Set y to node qq's value. If q has reached the end of l2, set to 0.
Set sum = x + y + carry.
Update carry = sum / 10.
Create a new node with the digit value of (sum mod 10 ) and set it to current node's next, then advance current node to next.
Advance both pp and qq.
Check if carry = 1, if so append a new node with digit 1 to the returning list.
Return dummy head's next node.
*******************************************************************************************/

package AddTwoNumbers;

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummyHead.next;
	}
	
	
	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}

 
