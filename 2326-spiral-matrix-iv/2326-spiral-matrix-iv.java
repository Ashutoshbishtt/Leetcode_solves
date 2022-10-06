/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];
        for(int[] i : ans){
            Arrays.fill(i,-1);
        }
        
        ListNode temp = head;
        
        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol = n-1;
        
        while(temp!=null){
            for(int i = startCol ; i <= endCol ; i++ ){
                if(temp==null)break;
                ans[startRow][i] = temp.val;
                temp=temp.next;
            }
            
            for(int i = startRow+1 ; i <= endRow ; i++){
                if(temp==null)break;
                ans[i][endCol]=temp.val;
                temp=temp.next;
            }
            
            for(int i = endCol-1 ; i>=startCol ; i--){
                if(temp==null)break;
                ans[endRow][i] = temp.val;
                temp=temp.next;
            }

            for(int i = endRow-1 ; i>startRow ; i--){
                if(temp==null)break;
                ans[i][startCol] = temp.val;
                temp = temp.next;
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return ans;
    }
}