import java.util.LinkedList;
import java.util.List;

public class Graph {
	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		adj = new List[V];
		for(int v=0; v<V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		int E=0;
		for(List<Integer> list : adj) {
			E += list.size();
		}
		return E/2;
	}
	
	public static int degree(Graph G, int v) {
		int degree = 0;
		for(int w : G.adj(v)) degree++;
		return degree;
	}
	
	public static int maxDegree(Graph G) {
		int max = 0;
		for(int v=0; v<G.V(); v++) {
			if(degree(G, v) > max) {
				max = degree(G, v);
			}
		}
		return max;
	}
	
	public static double averageDgree(Graph G) {
		return 2.0*G.E() / G.V();
	}
	
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for(int v=0; v<G.V(); v++) {
			for(int w : G.adj(v)) {
				if(v==w) count++;
			}
		}
		
		return count/2;
	}
	
	@Override
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for(int v=0; v<V; v++) {
			s += v + ": ";
			for(int w : this.adj(v)) 
				s += w + " ";
			s += "\n";
		}
		return s;
	}
}
