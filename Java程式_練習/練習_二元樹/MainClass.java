// 周孝倫
// 這個程式是用java寫的樹狀圖練習，能夠輸入任何節點到任何節點的子集，
// 並且能查詢節點的子集與父集，
// 但有個缺點就是增加節點的數量有上限，
// 並且宣告了好幾個節點儲存格，太冗長了，有人知道怎麼改嗎
// https://www.facebook.com/groups/1403852566495675/posts/3493333910880853/

// http://alrightchiu.github.io/SecondRound/binary-tree-jian-li-yi-ke-binary-tree.html
// https://web.ntnu.edu.tw/~algo/BinaryTree.html
package com.test5;

import java.util.Random;

// 定義二元樹的節點類別.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// 定義二元樹的類別.
class BinaryTree {
    TreeNode root; // 二元樹的根節點.

    public BinaryTree() {
        this.root = null;
    }

    // 二元樹的新增資料方法，從根節點開始遞迴插入.
    public void insert(int data) {
        this.root = insertRec(this.root, data);
    }

    // 二元樹的 遞迴插入方法，根據資料大小決定插入位置.
    public TreeNode insertRec(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
            return node;
        }

        if (data < node.data) {
            // 如果資料小於節點的資料，則插入到左子樹.
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            // 如果資料大於節點的資料，則插入到右子樹.
            node.right = insertRec(node.right, data);
        }

        return node;
    }

    // 二元樹的 中序遍歷(Inordern Traversal) 方法.
    public void inOrder() {
        inOrderRec(this.root);
        System.out.println();
    }

    // 二元樹的 遞迴 中序遍歷(Inordern Traversal) 方法.
    public void inOrderRec(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderRec(node.left); // 先遍歷左子樹.
        System.out.printf("%02d, ", node.data); // 再訪問根節點，輸出其資料.
        inOrderRec(node.right); // 最後遍歷右子樹.
    }
}

public class MainClass {

    public static void main(String[] args) {
        // 建立一個空的二元樹.
        BinaryTree binaryTree = new BinaryTree();

        Random random = new Random();
        for (int i = 0; i <= 100; ++i) {
            // 新增一些資料進二元樹.
            int num = random.nextInt(50); // 0 ~ (50 - 1)
            binaryTree.insert(num);
        }

        // 用中序遍歷走訪二元樹.
        binaryTree.inOrder();
    }
}