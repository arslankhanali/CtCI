package Arslan.Ch04TreesandGraphs.Q4_07_Build_Order.EdgeRemoval;

import java.util.HashMap;

public class Solution {


    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        HashMap<String, Solution_nodes> hashMap = new HashMap<>();

        for (String project : projects) {
            hashMap.put(project, new Solution_nodes(project));
        }

        for (int i = 0; i < dependencies.length; i++) {

            Solution_nodes p = hashMap.get(dependencies[i][0]);
            Solution_nodes c = hashMap.get(dependencies[i][1]);
            c.addparent(hashMap.get(dependencies[i][0]));
            p.addchildren(hashMap.get(dependencies[i][1]));
        }

        String[] answer = new String[projects.length];
        int index = 0;

        while (!hashMap.isEmpty()) {

            for (String keys : projects) {
                Solution_nodes solution_nodes = hashMap.get(keys);

                if (solution_nodes!=null && solution_nodes.isparentempty()) {
                    answer[index] = solution_nodes.name;
                    solution_nodes.setparentempty();
                    hashMap.remove(keys);
                    index++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"},
                {"g", "e"}};
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        System.out.println("SOLUTION");
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }
}
