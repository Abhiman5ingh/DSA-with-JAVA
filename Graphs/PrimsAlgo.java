package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    static class Pair implements Comparable<Pair>{
        int v, cost;
        
        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Pair p2){
            return this.cost - p2.cost; // ascending
        }
    }

    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int minCost =0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                minCost += curr.cost;

                for(int i =0; i< graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("Minimum Cost of the MST: "+ minCost);
    }

    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V]; // initially null
        createGraph(graph);
        prims(graph);
    }
}
