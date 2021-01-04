import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class GraphMain {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./tinyG.txt");
		Scanner scanner = new Scanner(file);
		
		Graph graph = new Graph(Integer.parseInt(scanner.nextLine()), 
				Integer.parseInt(scanner.nextLine()));
		
		while(scanner.hasNext()) {
			StringTokenizer st = 
					new StringTokenizer(scanner.nextLine(), " ");
			
			graph.addEdge(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(graph.toString());
		
		DepthFirstPaths dfs = new DepthFirstPaths(graph, 0);		
		
		System.out.println(); //줄바꿈
		
		for(int i=1; i<graph.V(); i++) {
			/* pathTo() 메소드가 Stack을 반환하게 되어있어
			 * 경로가 역순으로 나타나게 구현되어 있다.
			 * 따라서, 이해하기 쉽게 하기 위해
			 * stack에서 pop한 요소들을 queue에 삽입하고,
			 * queue의 toString()메소드를 이용하여 출력하면
			 * path가 왼쪽에서 오른쪽으로 나타난다.*/
			Queue<Integer> pathQueue = new LinkedList<Integer>();
			Stack<Integer> pathStack = (Stack<Integer>) dfs.pathTo(i);
			while(!pathStack.empty()) {
				pathQueue.add(pathStack.pop());
			}
			String path = pathQueue.toString();
			
			if(path==null)
				continue;
			System.out.println("path 0 to "+i+" is "+ path);
		}
		
		scanner.close();


	}
}
