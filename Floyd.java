public class Floyd {

	public static int size = 5;

	public static int[][] d = {
		{ 0,	1,	-1,	1,	5 },
		{ 9,	0,	3,	2,	-1 },
		{ -1,	-1,	0,	4,	-1 },
		{ -1,	-1,	2,	0,	3 },
		{ 3,	-1,	-1,	-1,	0 }
	};

	public static void main(String[] args) {
		
		for(int dimension = 0; dimension < size; dimension++) {

			System.out.println("D" + dimension + " matrix");
			System.out.println(printMatrix(d));

			nextMatrix(dimension, d);

		};

		System.out.println("D" + size + " matrix");
		System.out.println(printMatrix(d));

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

	public static void nextMatrix(int dimension, int[][] matrix) {

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
				int currentScore = d[row][column];

				// and the scores of getting to
				// the vertex through another vertex
				int v1 = d[row][dimension];
				int v2 = d[dimension][column];
				int vertexScore = calculateVertexScore(v1, v2);

				// Calculate the minimum between the two
				// and update the matrix
				d[row][column] = compareScores(currentScore, vertexScore);

			};
		};

	};

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
