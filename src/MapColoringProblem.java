
public class MapColoringProblem {

	public static void main(String[] args) {

		// Number states in Australian map
		int states = 7;
		
		// Total number of colors
		int colors = 3;
		
		// Adjacent matrix for Australian map
		int graph[][] = {
				{0, 1, 1, 0, 0, 0, 0},
				{1, 0, 1, 1, 0, 0, 0},
				{1, 1, 0, 1, 1, 1, 0},
				{0, 1, 1, 0, 1, 0, 0},
				{0, 0, 1, 1, 0, 1, 0},
				{0, 0, 1, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0}
		};
		
		// An array to store the total number of adjacent states for each state
		int highestAdjacentStates [] = new int[states];
		
		// Total adjacent states counter
		int totalAdjacents = 0;
		
		int hihestStateIndex = 0;
		
		// Temporary graph
		int tempGraph[][] = new int[1][];
		
		/*
		 * Calculating the total number of adjacent states for each state
		 * and storing the value in the corresponding states index in the 
		 * highestAdjacentStates array
		 */
		for(int i=0; i<states; i++){
			
			for(int j=0; j<states; j++){
				
				if(graph[i][j] == 1){
					
					totalAdjacents++;
				}
				
				highestAdjacentStates[i] = totalAdjacents;
				totalAdjacents = 0;
			}
		}
		
		/*
		 *  Storing the index value of the state that has highest number 
		 *  of adjacent states
		 */
		hihestStateIndex = highestAdjacentStates[0];
		
		for(int i=1; i<states; i++){
			
			if(highestAdjacentStates[i] > hihestStateIndex){
				
				hihestStateIndex = highestAdjacentStates[i];
			}
		}
		
		/*
		 * Swapping the index values between first state and 
		 * highest state
		 */
		if(hihestStateIndex != 0){
			
			for(int i=0; i<states; i++){
				
				tempGraph[0][i] = graph[hihestStateIndex][i];
				graph[hihestStateIndex][i] = graph[0][i];
				graph[0][i] = tempGraph[0][i];
			}
		}
		
		ColoringMap coloring = new ColoringMap();
		coloring.graphColoring(graph, colors);
	}
}
