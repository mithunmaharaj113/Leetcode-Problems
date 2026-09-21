/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helperbuildtree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode helperbuildtree(int[]postorder,int poststart,int postend,int []inorder,int instart,int inend,HashMap<Integer,Integer> map){
        if(instart>inend||poststart>postend)return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inRoot=map.get(root.val);
        int numleft=inRoot-instart;
        root.left=helperbuildtree(postorder,poststart,poststart+numleft-1,inorder,instart,inRoot-1,map);
        root.right=helperbuildtree(postorder,poststart+numleft,postend-1,inorder,inRoot+1,inend,map);
        return root;
    }
}