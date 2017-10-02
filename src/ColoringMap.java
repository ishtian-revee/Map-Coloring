
public class ColoringMap {

	final int states = 7;	// Number states in Australian map
	int color[];			// Array that holds the color sequence of the states
	
	/*
	 * This method solves the coloring problem using Backtracking by 
	 * using graphColoringUtil().
	 * 
	 * @param graph[][]		The adjacent matrix of the map
	 * @param colors		Number of total colors
	 * 
	 * @return false		If the colors can not be assigned
	 * @return true			Prints assignments of colors to all vertices			
	 */
	public boolean graphColoring(int graph[][], int colors){
		
		// Initialize all color values as 0
		color = new int[states];
		for(int i=0; i<states; i++){
			
			color[i] = 0;
		}
		
		// Calling graphColoringUtil() for vertex 0
		if(!graphColoringUtil(graph, colors, color, 0)){
			
			System.out.println("Solution does not exist...!!!");
			return false;
		}
		
		// Prints the solution
		printSolution(color);
		return true;
	}
	
	/*
	 * This is a recursive utility method to solve the map coloring problem
	 * 
	 * @param graph[][]		The adjacent matrix of the map
	 * @param colors		Number of total colors
	 * @param color[]		Array that holds the color sequence of the states		
	 * @param vertex		The current vertex
	 * 
	 * @return true			If all vertices are assigned
	 * @return false		If no color can be assigned to the current vertex
	 */
	public boolean graphColoringUtil(int graph[][], int colors, int color[], int vertex){
		
		// Base case: If all vertices are assigned a color then return true
		if(vertex == states){
			
			return true;
		}
		
		// Considering the current vertex and try a different color
		for(int c=1; c<=colors; c++){
			
			// Check if assignment of color c to vertex is fine or not
			if(isSafe(vertex, graph, color, c)){
				
				// Storing the color of the current vertex
				color[vertex] = c;		
				
				// Recursion to assign colors to rest of the vertices
				if(graphColoringUtil(graph, colors, color, vertex + 1)){
					
					return true;
				}
				
				// If assigning color c doesn't lead to a solution then removing it
				color[vertex] = 0;
			}
		}
		
		return false;
	}
	
	/*
	 * This is a utility method to check if the current color assignment 
	 * is safe for the current vertex
	 * 
	 * @param vertex		The current vertex/state
	 * @param graph[][]		The adjacent matrix of the map
	 * @param color[]		Array that holds the color sequence of the states
	 * @param c				A particular color for the vertex
	 * 
	 * @return true			If assignment of color c to the vertex is safe
	 * @return false		If assignment of color c to the vertex is not safe
	 */
	public boolean isSafe(int vertex, int graph[][], int color[], int c){
		
		for(int i=0; i<states; i++){
			
			// Checking if the adjacent vertices of the current vertex has the same color or not
			if(graph[vertex][i] == 1 && c == color[i]){
				
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * This method prints the solution of colors to each states
	 * 
	 * @param color[]		Array that holds the color sequence of the states
	 */
	public void printSolution(int color[]){
		
		System.out.println("\nSolution Exists");
		System.out.println("\nFollowing are the assigned colors: ");
		
		for(int i=0; i<states; i++){
			
			System.out.print(color[i] + " ");
		}
	}
}
