package leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 448 👎 0

import java.util.ArrayList;
import java.util.List;

public class 组合{
 public static void main(String[] args) {
    Solution solution = new 组合().new Solution();
 }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        getCombine(n,k,1,new ArrayList<>());
        return lists;
    }

     private void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
         for (int i = start; i <=  n - k + 1 ; i++) {
              list.add(i);
             getCombine(n, k - 1, i + 1, list);
             list.remove(list.size() - 1);
         }
     }
 }
//leetcode submit region end(Prohibit modification and deletion)

}