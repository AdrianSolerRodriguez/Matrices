package Ejerciciomatriz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {
	public static void main(String[] args) {
		String matrix1File = "matriz1.txt";
		String matrix2File = "matriz2.txt";
		String resultFile = "resultado.txt";

		try {
			int[][] matrix1 = readMatrixFromFile(matrix1File);
			int[][] matrix2 = readMatrixFromFile(matrix2File);

			int[][] result = MatrixMultiplier.multiply(matrix1, matrix2);

			writeMatrixToFile(result, resultFile);

			System.out.println("La multiplicación de las matrices se ha realizado correctamente.");
		} catch (IOException e) {
			System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Error al multiplicar las matrices: " + e.getMessage());
		}
	}

	public static int[][] readMatrixFromFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		int[][] matrix;

		try {
			String[] dimensions = reader.readLine().split(" ");
			int rows = Integer.parseInt(dimensions[0]);
			int columns = Integer.parseInt(dimensions[1]);
			matrix = new int[rows][columns];

			int row = 0;
			while ((line = reader.readLine()) != null) {
				String[] numbers = line.split(" ");
				for (int col = 0; col < columns; col++) {
					matrix[row][col] = Integer.parseInt(numbers[col]);
				}
				row++;
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		return matrix;
	}

	public static void writeMatrixToFile(int[][] matrix, String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		try {
			int rows = matrix.length;
			int columns = matrix[0].length;

			writer.write(rows + " " + columns);
			writer.newLine();

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					writer.write(matrix[i][j] + " ");
				}
				writer.newLine();
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
