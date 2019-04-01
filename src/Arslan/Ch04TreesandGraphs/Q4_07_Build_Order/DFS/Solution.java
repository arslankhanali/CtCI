package Arslan.Ch04TreesandGraphs.Q4_07_Build_Order.DFS;

import java.util.*;

public class Solution {


    /* Build the graph, adding the edge (a, b) if b is dependent on a.
     * Assumes a pair is listed in “build order” (which is the reverse
     * of dependency order). The pair (a, b) in dependencies indicates
     * that b depends on a and a must be built before a. */
    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }


    public static Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<Project>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (doDFS(project, stack) == false) {
                    return null;
                }
            }
        }
        return stack;
    }

    public static boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; // Cycle
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (doDFS(child, stack) == false) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    static LinkedHashSet<String> hashSet=new LinkedHashSet<>();

    public static void traverse(ArrayList<Project> projects) {

        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                traverse_help(project);
            }
        }
    }



    public static void traverse_help(Project project) {
        if (project.getState() == Project.State.PARTIAL) return;

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                traverse_help(child);
            }
        }
        project.setState(Project.State.COMPLETE);
        System.out.print(project.getName());
        hashSet.add(project.getName());

    }


    public static String[] convertToStringList(Stack<Project> projects) {
        String[] buildOrder = new String[projects.size()];
        for (int i = 0; i < buildOrder.length; i++) {
            buildOrder[i] = projects.pop().getName();
        }
        return buildOrder;
    }

    public static void findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        traverse(graph.getNodes());
        System.out.println("END");

    }

    public static void buildOrderWrapper(String[] projects, String[][] dependencies) {
        findBuildOrder(projects, dependencies);

    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};//higjabdefc
        //aghbicdjef
        buildOrderWrapper(projects, dependencies);

        System.out.println(hashSet);
        System.out.println("start with reverse order");

    }

}
