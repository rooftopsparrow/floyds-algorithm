import static org.junit.Assert.*;

import org.junit.*;

import java.util.Arrays;

public class FloydTest {

	@Test
	public void calculateVertexScore_shouldReturnTheSum() {
		assertTrue(Floyd.calculateVertexScore(1, 4) == 5);
		assertTrue(Floyd.calculateVertexScore(7, 2) == 9);
	}

	@Test
	public void calculateVertexScore_shouldReturnNegativeOneIfGivenNegativeOne() {
		assertTrue(Floyd.calculateVertexScore(2, -1) == -1);
		assertTrue(Floyd.calculateVertexScore(-1, 9) == -1);
	}

	@Test
	public void compareScores_shouldReturnFalseForLargerAndTies() {
		assertFalse(Floyd.beatsCurrent(1, 2));
		assertFalse(Floyd.beatsCurrent(2, 2));
		assertFalse(Floyd.beatsCurrent(-1, -1));
	}

	@Test
	public void compareScores_shouldReturnTrueForLessValues() {
		assertTrue(Floyd.beatsCurrent(4, 2));
		assertTrue(Floyd.beatsCurrent(-1, 3));
		assertTrue(Floyd.beatsCurrent(-1, 0));
	}

	@Test
	public void nextMatrix_shouldCorrectlyCreateTheNextMatrix() {

		int[][] annotate = new int[5][5];

		int[][] matrix = {
			{ 0,	1,	-1,	1,	5 },
			{ 9,	0,	3,	2,	-1},
			{ -1,	-1,	0,	4,	-1},
			{ -1,	-1,	2,	0,	3},
			{ 3,	-1,	-1,	-1,	0}
		};

		int [][] result = {
			{ 0,	1,	-1,	1,	5 },
			{ 9,	0,	3,	2,	14},
			{ -1,	-1,	0,	4,	-1},
			{ -1,	-1,	2,	0,	3},
			{ 3,	4,	-1,	4,	0}
		};

		Floyd.transform(0, matrix, annotate);
		assertTrue(Arrays.deepEquals(matrix, result));
		assertTrue(annotate[1][4] == 1);
		assertTrue(annotate[4][1] == 1);
		assertTrue(annotate[4][3] == 1);

	}

}