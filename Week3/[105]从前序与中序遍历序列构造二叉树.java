package leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 782 👎 0

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树{
 public static void main(String[] args) {
    Solution solution = new 从前序与中序遍历序列构造二叉树().new Solution();
 }
 //leetcode submit region begin(Prohibit modification and deletion)
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
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            //构建快速获取中序遍历的根节点下标
            map.put(inorder[i],i);
        }
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        //递归终止条件
        if (pre_start > pre_end){
            return null;
        }
        //处理逻辑
        //由前序遍历 获取根节点
        TreeNode treeNode = new TreeNode(preorder[pre_start]);
        //获取中序遍历根节点下标
        Integer in_index = map.get(preorder[pre_start]);
        //计算左子树节点数
        int i = in_index - in_start;
        //下探下一层
        //拆分计算左子树节点
        treeNode.left =  buildTree(preorder, inorder, pre_start + 1, pre_start + i , in_start, in_index - 1);
        //拆分计算右子树
        treeNode.right = buildTree(preorder, inorder, pre_start + i + 1, pre_end, in_index + 1, in_end);
        return treeNode;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}