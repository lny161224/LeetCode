//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2017 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    HashMap<TreeNode, Integer> depth = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root, 0);
        // 调整pq位置，使得p比q深
        if (depth.get(p) < depth.get(q)) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        // 使p和q在同一深度
        while (depth.get(p) > depth.get(q)) {
            p = parent.get(p);
        }
        while (p.val != q.val) {
            p = parent.get(p);
            q = parent.get(q);
            System.out.println("p = " + p.val+", q = " + q.val);
        }
        return p;
    }
    public void dfs(TreeNode root,int deep){
        depth.put(root, deep);
        if(root.left != null){
            parent.put(root.left, root);
            dfs(root.left, deep + 1);
        }
        if(root.right != null){
            parent.put(root.right, root);
            dfs(root.right, deep + 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
