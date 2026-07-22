class Node{
    int val;
    Node left,right;

    Node(int val){
        this.val=val;
    }
}

public class BSTInsert{

    public static Node insert(Node node,int val){

        if(node==null){
            return new Node(val);
        }

        if(val<node.val){
            node.left=insert(node.left,val);
        }
        else if(val>node.val){
            node.right=insert(node.right,val);
        }

        return node;
    }

    public static void inorder(Node node){

        if(node==null){
            return;
        }

        inorder(node.left);
        System.out.print(node.val+" ");
        inorder(node.right);
    }

    public static void main(String[] args){

        Node root=new Node(50);
        insert(root,30);
        insert(root,70);
        insert(root,20);
        insert(root,40);

        inorder(root);
    }
}