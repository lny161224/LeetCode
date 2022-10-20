//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 623 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null)return ans;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while (!que.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = que.size();
            while(len>0){
                TreeNode temp = que.poll();
                itemList.add(temp.val);
                if (temp.left!=null) que.offer(temp.left);
                if (temp.right!=null) que.offer(temp.right);
                len--;
            }
            ans.add(itemList);
        }
        List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
        for(int i=0;i<ans.size();i++)ans2.add(ans.get(ans.size()-i-1));
        return ans2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
