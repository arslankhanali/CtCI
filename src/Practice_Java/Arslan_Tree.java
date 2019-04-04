package Practice_Java;

public class Arslan_Tree {
    int data;
    Arslan_Tree right,left,parent;
    int elements;


    public Arslan_Tree(int data) {
        this.data = data;
        elements=1;
    }

    public void addtoleft(int d) {
        if (left==null){
            left=new Arslan_Tree(d); }
        else{
            left.addlikeBST(d);
        }
    }

    public void addtoright(int d) {
        if (right==null){
            right=new Arslan_Tree(d); }
        else{
            right.addlikeBST(d);
        }
    }


    public void addlikeBST(int d){
        if(data==d){
            System.out.println(d+" already in BST");
            return;
        }
        else if(d<data){
            addtoleft(d);
        }
        else if(d>data){
            addtoright(d);
        }
    }

    @Override
    public String toString() {
        String s=""+data+"|\n" +
                "         V";
        if(this.right!=null){
            s=s+right.toString();
        }
        if(this.left!=null){
            s=s+left.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Arslan_Tree bst= new Arslan_Tree(5);
        bst.addlikeBST(1);
        bst.addlikeBST(2);
        bst.addlikeBST(3);
        bst.addlikeBST(6);
        bst.addlikeBST(4);
        bst.addlikeBST(8);
        bst.addlikeBST(10);
        bst.addlikeBST(9);

        System.out.println(bst.toString());




    }
}
