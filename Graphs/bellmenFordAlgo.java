package Graphs;
import java.util.*;

public class bellmenFordAlgo {
    // Dijkstra can not found right solution for negative weights graph
    // We use BellmonFord to run the relaxation for V-1 times
    // so after V-1 time we get the most optimal paths
    // This algo does not work for Negative Weight Cycle 
    
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

     public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // vertex '0'
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i=0; i< graph.length; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // O(V*E)
        // algo - O(V)
        for(int i=0; i < V-1; i++){
            // edge - O(E)
            for(int j=0; j< graph.length; j++){
                for(int k =0; k< graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // on special condi.
                    // relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print all shorest distance
        for(int i=0; i< dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V]; // initially null
        createGraph(graph);
        int src =0;
        bellmanFord(graph, src);
    }
}
