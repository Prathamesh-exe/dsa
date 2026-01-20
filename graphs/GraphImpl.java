
import java.util.ArrayList;
import java.util.List;


public class GraphImpl {
    public static void main(String[] args) {
        int v=3;//number of vertices
        int[][] matrix=new int[v][v]; //adjacency matrix initialized to 0
        
        List<List<Integer>> list=new ArrayList<>(); //adjacency list
        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }


        addEdgeMatrix(matrix,0,1);
        addEdgeMatrix(matrix,1,2);
        addEdgeMatrix(matrix, 2, 0);
        
        //print the adjacency matrix
        for(int i=0;i<v;i++) {
            for(int j=0;j<v;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


        addEdgeList(list, 0, 1);
        addEdgeList(list, 1, 2);
        addEdgeList(list, 2, 0);
        //print the adjacency list
        for(List<Integer> edges : list) {
            System.out.println(edges);
        }
    }
    private static void addEdgeMatrix(int[][] matrix, int i, int j) {
        matrix[i][j]=1;
        matrix[j][i]=1; //remove this line for directed graph
    }
    private static void addEdgeList(List<List<Integer>> list, int i, int j) {
             list.get(i).add(j);
             list.get(j).add(i); //remove this line for directed graph
}
}
