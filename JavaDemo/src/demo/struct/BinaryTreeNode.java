package demo.struct;

/**
 * Created by wim on 2017/8/15.
 */
public class BinaryTreeNode {
    public String data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;


    public boolean isLeaf(){
        if (left == null && right == null) {
            return true;
        }
        return false;
    }
}
