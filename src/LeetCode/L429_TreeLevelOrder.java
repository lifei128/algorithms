package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L429_TreeLevelOrder {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)return new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                Node cur = queue.pop();
                list.add(cur.val);
                if(cur.children != null){
                    for(Node n : cur.children){
                        queue.add(n);
                    }
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
