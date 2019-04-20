package FindLargestValueInEachTreeRow;

import java.util.*;

public class FindLargestValueInEachTreeRow {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> maxElements = new ArrayList<>();

        if (root == null) {
            return maxElements;
        }
        int height = getHeight(root);
        Queue<Integer> elements = new ArrayDeque<>();
        for (int i = 1; i <= height; i++) {
            elements = getMaxElementOnLevel(root, elements, i);
            int max = Integer.MIN_VALUE;
            while (!elements.isEmpty()) {
                int elem = elements.poll();
                max = Integer.max(max, elem);
            }
            maxElements.add(max);
        }
        return maxElements;

    }

    private static Queue<Integer> getMaxElementOnLevel(TreeNode root, Queue<Integer> elementsOnLevel, int level) {
        if (root != null) {
            if (level == 1) {
                elementsOnLevel.add(root.val);
            } else {
                getMaxElementOnLevel(root.left, elementsOnLevel, level - 1);
                getMaxElementOnLevel(root.right, elementsOnLevel, level - 1);
            }
        }
        return elementsOnLevel;
    }

    private static int getHeight(TreeNode root) {
        if (root != null) {
            int leftHeight = getHeight(root.left) + 1;
            int rightHeight = getHeight(root.right) + 1;
            if (leftHeight >= rightHeight) {
                return leftHeight;
            } else {
                return rightHeight;
            }
        }
        return 0;
    }

    //     1
//        / \
//       3   2
//      / \   \
//     5   3   9
//
//    Output: [1, 3, 9]
//

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(9);

        List<Integer> maxElements = largestValues(node);
        System.out.print("[ ");
        for (Integer currentElement : maxElements) {
            System.out.print(currentElement + " ");
        }
        System.out.println("]");
    }
}