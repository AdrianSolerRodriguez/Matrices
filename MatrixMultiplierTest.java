package Ejerciciomatriz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixMultiplierTest {
	public void testMultiply() {
		int[][] matrix1 = { { 1, 2 }, { 3, 4 } };

		int[][] matrix2 = { { 5, 6 }, { 7, 8 } };

		int[][] expectedResult = { { 19, 22 }, { 43, 50 } };

		int[][] result = MatrixMultiplier.multiply(matrix1, matrix2);

		Assertions.assertArrayEquals(expectedResult, result);
	}
}
