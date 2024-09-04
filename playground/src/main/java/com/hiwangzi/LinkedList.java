package com.hiwangzi;


class Node {
    private String data; //保存数据
    private Node next; // 保存下一个节点的引用

    public Node(String data) { // 节点的构造函数
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }
}

public class LinkedList {
    public static void main(String args[]) {
        //设置数据
        Node root = new Node("头");
        Node n1 = new Node("节点1");
        Node n2 = new Node("节点2");

        root.setNext(n1);
        n1.setNext(n2);

        //循环取出数据
        // Node currentNode=root;
        // int i=1;
        // while(currentNode!=null){
        //     System.out.println(i+++"\t"+currentNode.getData());
        //     currentNode=currentNode.getNext();
        // }

        //递归取出数据
        Node currentNode = root;
        print(currentNode);

    }

    public static void print(Node node) {
        if (node == null) { // 递归的结束条件
            return;
        }
        System.out.println(node.getData());
        print(node.getNext());
    }
}