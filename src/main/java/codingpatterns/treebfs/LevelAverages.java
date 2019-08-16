package codingpatterns.treebfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 */
public class LevelAverages {

    private static List<Double> calculateAverages(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double levelSum = 0;
            for (int i = 0; i < size ; i++) {
                TreeNode currentNode = queue.poll();

                levelSum += currentNode.value;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
            result.add(levelSum/size);

        }
        return result;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverages.calculateAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
