// https://leetcode.com/problems/course-schedule-ii/description/
import java.util.*;

//topo sort using BFS (Kahn's algorithm)
public class CourseSchedule2 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };

        int[] order = findOrder(numCourses, prerequisites);
        System.out.println("Course order: " + Arrays.toString(order));
        
    }
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adjList.get(prereq).add(course);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topoOrder = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topoOrder[index++] = node;

            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (index != numCourses) {
            return new int[0]; // Cycle detected, return empty array
        }

        return topoOrder;
    }
}