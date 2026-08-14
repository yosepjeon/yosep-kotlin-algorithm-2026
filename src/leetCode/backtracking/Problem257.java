package leetCode.backtracking;

// https://leetcode.com/problems/binary-tree-paths/?envType=problem-list-v2&envId=backtracking

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public List<String> findAll(TreeNode node, List<String> answer, String path) {
    path += node.val;

    if (node.left == null && node.right == null) {
      answer.add(path);
      return answer;
    }

    if(node.left != null) {
      findAll(node.left, answer, path + "->");
    }

    if (node.right != null) {
      findAll(node.right, answer, path + "->");
    }

    return answer;
  }
}

class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<>();

    return root.findAll(root, answer, "");
  }

}
