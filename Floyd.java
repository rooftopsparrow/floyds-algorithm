import java.util.Scanner;

public class Floyd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		};

		System.out.println("How many vertices?");

		// Number of vertices the graph has
		int vertices = sc.nextInt();
		// Matrix we need to fill
		int[][] matrix = new int[vertices][vertices];

		System.out.println("Enter weights between each vertex. One per line or separated by tabs.");
		System.out.println("Use -1 to indicate that there is no edge between two vertices.");

		sc.useDelimiter("[\\t\\n]");

		int row = 0, column = 0, count = 0;
		int maxCount = vertices * vertices;
		while(count < maxCount && sc.hasNext()) {

			int val = sc.nextInt();
			matrix[row][column] = val;
			// Increment count
			count++;
			// modify column and row
			column += 1;
			if (column == vertices) {
				column = 0;
				row += 1;
			}

		}

		for(int dimension = 0; dimension < vertices; dimension++) {

			System.out.println("D" + dimension + " matrix");
			System.out.println(printMatrix(matrix));

			Floyd.transform(dimension, matrix);

		};

		System.out.println("D" + vertices + " matrix");
		System.out.println(Floyd.printMatrix(matrix));

	}

	public static int calculateVertexScore (int v1, int v2) {
		if (v1 == -1 || v2 == -1) return -1;
		else return v1 + v2;
	}

	public static int compareScores(int current, int vertex) {

		boolean currentIsInfinity = current == -1;
		boolean vertexIsInfinity = vertex == -1;

		if ((!vertexIsInfinity && currentIsInfinity) || (!vertexIsInfinity && vertex < current)) 
			return vertex;

		return current;
	}

	public static int[][] transform(int dimension, int[][] matrix) {

		// Look at each row
		for (int row = 0; row < matrix.length; row++) {

			// Don't check the row of the vertex
			// now considering going through
			if ( row == dimension ) continue;

			// Look at each column in a row
			for (int column = 0; column < matrix[row].length; column++) {

				// Skip trying to evaluate
				// best path to vertex from
				// the same vertex
				if (row == column) continue;

				// Don't check the column of the
				// vertext now considering going through
				if (column == dimension) continue;

				// Get the current score of getting
				// to the current vertex...
				int currentScore = matrix[row][column];

				// and the scores of getting to
				// the vertex through another vertex
				int v1 = matrix[row][dimension];
				int v2 = matrix[dimension][column];
				int vertexScore = calculateVertexScore(v1, v2);

				// Calculate the minimum between the two
				// and update the matrix
				matrix[row][column] = compareScores(currentScore, vertexScore);

			};
		};

		return matrix;

	}

	public static String printMatrix(int[][] matrix) {
		
		String s = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int value = matrix[i][j];
				s += (value == -1) ? "-" : Integer.toString(value);
				s += (j < matrix[i].length - 1) ? "\t" : "";
			};
			s += (i < matrix.length - 1) ? "\n" : "";
		};

		return s;

	}

}

