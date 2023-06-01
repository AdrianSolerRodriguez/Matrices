package Ejerciciomatriz;

public class MatrixMultiplier {
	public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
		int rowsMatrix1 = matrix1.length;
		int columnsMatrix1 = matrix1[0].length;
		int rowsMatrix2 = matrix2.length;
		int columnsMatrix2 = matrix2[0].length;

		if (columnsMatrix1 != rowsMatrix2) {
			throw new IllegalArgumentException(
					"Las matrices no pueden multiplicarse. El número de columnas de la matriz 1 debe ser igual al número de filas de la matriz 2.");
		}

		int[][] result = new int[rowsMatrix1][columnsMatrix2];

		for (int i = 0; i < rowsMatrix1; i++) {
			for (int j = 0; j < columnsMatrix2; j++) {
				for (int k = 0; k < columnsMatrix1; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}

		return result;
	}
}
