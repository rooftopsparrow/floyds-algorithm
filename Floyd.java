import java.util.Scanner;

public class Floyd {

	private static String[] subscripts = {
		"\u2080", "\u2081",
		"\u2082", "\u2083",
		"\u2084", "\u2085",
		"\u2086", "\u2087",
		"\u2088", "\u2089",
	};

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
		// Annotate vertex positions for transformed matrix
		int[][] annotate = new int[vertices][vertices];

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
			System.out.println(printMatrix(matrix, annotate));

			Floyd.transform(dimension, matrix, annotate);

		};

		System.out.println("D" + vertices + " matrix");
		System.out.println(Floyd.printMatrix(matrix, annotate));

	}

	public static int calculateVertexScore (int v1, int v2) {
		if (v1 == -1 || v2 == -1) return -1;
		else return v1 + v2;
	}

	public static boolean beatsCurrent (int current, int vertex) {

		boolean currentIsInfinity = current == -1;
		boolean vertexIsInfinity = vertex == -1;

		return ((!vertexIsInfinity && currentIsInfinity) || (!vertexIsInfinity && vertex < current));

	}

	public static int[][] transform(int dimension, int[][] matrix, int[][] annotate) {

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
				boolean wins = beatsCurrent(currentScore, vertexScore);

				if (wins) {
					matrix[row][column]	= vertexScore;
					annotate[row][column] = (dimension + 1);
				}

			};
		};

		return matrix;

	}

	public static String printMatrix(int[][] matrix, int[][] annotate) {
		
		String s = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int value = matrix[i][j];
				int vertex = annotate[i][j];
				if (value == -1) {
					s += "-";
				} else {
					s += Integer.toString(value);
					String digits = "";
					int v = vertex;
					while (v > 0) {
						int digit = v % 10;
						digits = Floyd.subscripts[digit] + digits;
						v = v / 10;
					}
					s += digits;
				}
				s += (j < matrix[i].length - 1) ? "\t" : "";
			};
			s += (i < matrix.length - 1) ? "\n" : "";
		};

		return s;

	}

}

