import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return getBst(nums, 0, nums.length - 1);
    }

    public TreeNode getBst(int[] arr, int startIdx, int endIdx) {
        if(startIdx > endIdx) return null;
        int mid = (startIdx + endIdx) / 2;
        TreeNode bst = new TreeNode(arr[mid]);
        bst.left = getBst(arr, startIdx, mid - 1);
        bst.right = getBst(arr, mid + 1, endIdx);
        return bst;
    }

   
    public List<String> levelOrder(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.add("null");
            }
        }

       
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) {
            res.remove(i--);
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution sol = new Solution();
        TreeNode bst = sol.sortedArrayToBST(nums);
        List<String> output = sol.levelOrder(bst);
        System.out.println(output);
    }
}
