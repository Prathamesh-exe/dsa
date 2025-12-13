// https://leetcode.com/problems/simplify-path/

import java.util.*;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));
    }
    private static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            switch (component) {
                case "", "." -> {
                    continue;
                }
                case ".." -> {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                default -> stack.push(component);
            }
        }
        
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }
        
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
