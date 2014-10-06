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
	public void compareScores_shouldReturnTheSmallerOfTheTwo() {
		assertTrue(Floyd.compareScores(1, 2) == 1);
		assertTrue(Floyd.compareScores(2, 2) == 2);
		assertTrue(Floyd.compareScores(-1, -1) == -1);
	}

	@Test
	public void compareScores_shouldReturnTheNonInfinityOfTheTwo() {
		assertTrue(Floyd.compareScores(3, -1) == 3);
		assertTrue(Floyd.compareScores(-1, 12) == 12);
	}

	public void nextMatrix_shouldCorrectlyCreateTheNextMatrix() {

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

		Floyd.transform(0, matrix);
		assertTrue(Arrays.deepEquals(matrix, result));

	}

}