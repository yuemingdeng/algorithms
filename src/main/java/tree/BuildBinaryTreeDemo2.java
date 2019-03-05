package tree;


import java.util.*;

/**
 * url : https://blog.csdn.net/seagal890/article/details/79772657
 */

public class BuildBinaryTreeDemo2 {

    /*
     * 二叉树的层次遍历算法设计
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if (root == null) return wrapList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().leftChild != null) queue.offer(queue.peek().leftChild);
                if (queue.peek().rightChild != null) queue.offer(queue.peek().rightChild);
                 subList.add(queue.poll().data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    /*
     * 二叉树的前序遍历
     * */
    public static ArrayList<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.data);
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }

        }
        System.out.println(list);
        return list;
    }


    /*
     * 二叉树的中序遍历
     * */
    public static ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.add(current);
                current = current.leftChild;
            }
            current = stack.peek();
            stack.pop();
            list.add(current.data);
            current = current.rightChild;

        }
        System.out.println(list);
        return list;

    }

    /*
     * 二叉树的后续遍历
     * */

    public static ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        list.addAll(postOrder(root.leftChild));
        list.addAll(postOrder(root.rightChild));
        list.add(root.data);
        System.out.println(list);
        return list;
    }


    /*
     * 构造二叉树
     * */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildBinaryTreeProcess(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    /*
     * 根据二叉树中序遍历和后序遍历的结果构造二叉树
     * */
    public TreeNode buildBinaryTreeProcess(int[] inorder, int[] postorder, int ppos, int is, int ie) {
        if (ppos >= postorder.length || is > ie) return null;
        TreeNode node = new TreeNode(postorder[ppos]);
        int pii = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[ppos]) pii = i;
        }
        node.leftChild = buildBinaryTreeProcess(inorder, postorder, ppos - 1 - ie + pii, is, pii - 1);
        node.rightChild = buildBinaryTreeProcess(inorder, postorder, ppos - 1, pii + 1, ie);
        return node;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //int[] preorder = {62,15,12,46,35,57,68,65,79};
        int[] inorder = {12, 15, 35, 46, 57, 62, 65, 68, 79};
        int[] postorder = {12, 35, 57, 46, 15, 65, 79, 68, 62};

        BuildBinaryTreeDemo2 buildBT = new BuildBinaryTreeDemo2();
        TreeNode tree = buildBT.buildTree(inorder, postorder);

        buildBT.preOrder(tree);
        buildBT.inOrder(tree);
        buildBT.postOrder(tree);
        System.out.println("二叉树的层次遍历结果");
        List<List<Integer>> list = buildBT.levelOrder(tree);
        System.out.println(list.toString());


    }


}

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }
}

