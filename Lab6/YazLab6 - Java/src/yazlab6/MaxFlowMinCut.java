package yazlab6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
 
public class MaxFlowMinCut{
    
    private int nodeSize;
    private int[] parent;
    private Queue<Integer> queue;
    private boolean[] visited;
    private Set<Pair> cutSet;
    private ArrayList<Integer> accessible, inaccessible;
 
    public MaxFlowMinCut(int nodeSize){
        
        this.nodeSize = nodeSize;
        this.queue = new LinkedList<Integer>();
        parent = new int[nodeSize + 1];
        visited = new boolean[nodeSize + 1];
        cutSet = new HashSet<Pair>();
        accessible = new ArrayList<Integer>();
        inaccessible = new ArrayList<Integer>();
    }
    
    public int maxFlowMinCut(int graph[][], int source, int goal){
        
        int u, v; //1+1=2
        int maxFlow = 0; //1
        int pathFlow; //1
        int[][] residualGraph = new int[nodeSize+1][nodeSize+1]; //1
 
        //1+(N+1)+N=2N+2
        for(int sourceVertex=1; sourceVertex<=nodeSize; sourceVertex++){ 
            // 1+(N+1)+N=(2N+2)*N=2N^2+2N
            for(int destinationVertex=1; destinationVertex<=nodeSize; destinationVertex++){
                //N*N=N^2
                residualGraph[sourceVertex][destinationVertex] = graph[sourceVertex][destinationVertex];
            }
        }
        
        while(bfs(source, goal, residualGraph)){
            pathFlow = Integer.MAX_VALUE; //M
            
            //1+(K+1)+K=2K+2*M=2KM+2M
            for(v=goal; v!=source; v=parent[v]){
                
                u=parent[v]; //K*M=KM
                pathFlow=Math.min(pathFlow,residualGraph[u][v]); //K*M=KM
            }
            
            //1+(K+1)+K=2K+2*M=2KM+2M
            for(v=goal; v!=source; v=parent[v]){
                
                u=parent[v]; //K*M=KM
                residualGraph[u][v]-=pathFlow; //K*M=KM
                residualGraph[v][u]+=pathFlow; //K*M=KM
            }
            maxFlow+=pathFlow; //M
        }
 	
        //1+(N+1)+N=2N+2
        for(int vertex=1; vertex<=nodeSize; vertex++){
            
            //IF-ELSE YAPISI=N+N=2N
            if(bfs(source, vertex, residualGraph)){
                accessible.add(vertex);
            }else{
                inaccessible.add(vertex);
            }
        }
        
        //1+(X+1)+X=2X+2
        for(int i=0; i<accessible.size(); i++){
            //1+(Y+1)+Y=(2Y+2)*2X+2=4XY+4X+4Y+4
            for(int j=0; j<inaccessible.size(); j++){
                //X*Y=XY
                if(graph[accessible.get(i)][inaccessible.get(j)]>0){
                    //X*Y=XY
                    cutSet.add(new Pair(accessible.get(i), inaccessible.get(j)));
                }
            }
        }
        return maxFlow; //1
    }
 
    public boolean bfs(int source, int goal, int graph[][]){
        
        boolean pathFound = false;
        int destination, element;
        for (int vertex=1; vertex<=nodeSize; vertex++){
            parent[vertex] = -1;
            visited[vertex] = false;
        }
        queue.add(source);
        parent[source] = -1;
        visited[source] = true;
 
        while(!queue.isEmpty()){
            
            element = queue.remove();
            destination = 1;
            while(destination<=nodeSize){
                if(graph[element][destination]>0 && !visited[destination]){
                    parent[destination] = element;
                    queue.add(destination);
                    visited[destination] = true;
                }
                destination++;
            }
        }
 
        if (visited[goal]){
            pathFound = true;
        }
        return pathFound;
    }
 
    public String printCutSet(){
        
        String minCut = "";
        Iterator<Pair> iterator = cutSet.iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            minCut+=pair.source + "-" + pair.destination+"\n";
        }
        return minCut;
    }
}