// Creation and deletion of binary search trees

import java.io.*;
import java.util.*;

public class BST {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for(int i=1;i<=a;i++){
            System.out.println("Case #"+i+":");
            Node root=null;
            int b=sc.nextInt();
            while(b-->0){
                int m=sc.nextInt();
                 if(m!=4){
                int n=sc.nextInt();
                switch(m){
                    case 1: root=insert(root,n);
                            break;
                    case 2: root=delete(root,n);
                        break;
                    case 3: check(root,n);
                        break;
                }
            }
                else{
                    preOrder(root);
                    System.out.println();
                }
        }
    }
    }
        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static Node insert(Node root,int data) {
          if(root==null) {
           Node n=new Node(data);
           return n;
          }
          if(root.data<data){
             root.right=insert(root.right,data); 
          }
          else
          root.left=insert(root.left,data);
        return root;
    }
        public static void check(Node root,int data){
            if(root==null){
                System.out.println("No");
                return;
            }
            if(root.data==data){
                System.out.println("Yes");
                return;
            }
            if(root.data>data){
                 check(root.left,data);
            }
            else{
                 check(root.right,data);
            }
        }
        public static Node delete(Node root,int data){
            if(root==null){
                return null;
            }
            if(root.data<data){
                root.right=delete(root.right,data);
            }
            else if(root.data>data){
                root.left=delete(root.left,data);
            }
            else{
                if(root.left==null&&root.right==null){
                    return null;
                }
                if(root.left==null){
                    return root.right;
                }
                if(root.right==null){
                    return root.left;
                }
                int M=findMax(root.right);
                root.data=M;
                root.right=delete(root.right,M);
            }
            return root;
        }
        public static int findMax(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root.data;
        }
        static class Node{
            int data;
            Node left,right;
            Node(int key){
                this.data=key;
            }
        }
    
}
