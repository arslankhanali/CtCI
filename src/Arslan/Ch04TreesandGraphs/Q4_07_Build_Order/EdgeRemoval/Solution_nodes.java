package Arslan.Ch04TreesandGraphs.Q4_07_Build_Order.EdgeRemoval;

import java.util.HashSet;

public class Solution_nodes {

    String name;

    public String getName() {
        return name;
    }

    HashSet<Solution_nodes> parent = new HashSet<>();
    HashSet<Solution_nodes> children = new HashSet<>();
    boolean flag = false;


    public Solution_nodes(String name) {
        this.name = name;

    }

    public void addparent(Solution_nodes node) {
        parent.add(node);
    }

    public void addchildren(Solution_nodes node) {
        children.add(node);
    }


    public void removeparent(Solution_nodes node) {
        if (parent.contains(node)) parent.remove(node);
    }

    public void removechildren(Solution_nodes node) {
        if (children.contains(node)) children.remove(node);
    }

    public boolean isparentempty() {
        if(parent.isEmpty())return true;
        else{
            for (Solution_nodes nodes : parent) {
                if(nodes.flag==false)return false;
            }
            return true;
        }
    }

    public void setparentempty() {
        flag = true;
    }


}
