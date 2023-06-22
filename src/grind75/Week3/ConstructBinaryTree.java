package grind75.Week3;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    static class Solver {
        int[] preorder;
        Map<Integer, Integer> inOrderIndexes;
        int preOrderCurrent=0;

        public Solver(int[] preorder, Map<Integer, Integer> inOrderIndexes) {
            this.preorder = preorder;
            this.inOrderIndexes = inOrderIndexes;
        }

        public TreeNode createTree(int inOrderStart, int inOrderEnd) {
            boolean generateRightChild=true, generateLeftChild=true;

            if(inOrderStart == inOrderEnd) {
                generateLeftChild = generateRightChild = false;
            }

            int currentNodeValue = preorder[preOrderCurrent++];
            int inOrderIndex=inOrderIndexes.get(currentNodeValue);

            if (inOrderStart == inOrderIndex) {
                generateLeftChild = false;
            } else if (inOrderEnd == inOrderIndex) {
                generateRightChild=false;
            }

            TreeNode leftChild = null, rightChild = null;


            if (generateLeftChild) {
                leftChild = createTree(inOrderStart, inOrderIndex-1);
            }

            if (generateRightChild) {
                rightChild = createTree(inOrderIndex+1, inOrderEnd);
            }

            return new TreeNode(currentNodeValue, leftChild, rightChild);
        }
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        return new Solver(preorder, indexes).createTree(0, inorder.length-1);
    }

    public static void main(String[] args) {

        int[] preOrder = new int[] {1,2,3};
        int[] inOrder = new int[] {3, 2, 1};

        //int[] preOrder = new int[] {1, 2};
        //int[] inOrder = new int[] {2, 1};
        TreeNode res = buildTree(preOrder, inOrder);
        int x = 5;
    }
}
