package net.lenwe.cholesky;

public class Matrix {

	Complex[][] matrix;

	Matrix(Complex[][] m) {
		matrix = m;
	}

	Matrix(Matrix m) {
		matrix = new Complex[m.matrix.length][];
		for (int i = 0; i < m.matrix.length; i++) {
			matrix[i] = new Complex[m.matrix[i].length];
			for (int j = 0; j < m.matrix[i].length; j++) {
				matrix[i][j] = m.matrix[i][j];
			}
		}
	}

	protected Matrix() {
	}

	public Matrix(double[][] d) {
		matrix = new Complex[d.length][];
		for (int i = 0; i < d.length; i++) {
			matrix[i] = new Complex[d[i].length];
			for (int j = 0; j < d[i].length; j++) {
				matrix[i][j] = new Complex(d[i][j], 0);
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Complex[] row : matrix) {
			for (Complex cell : row) {
				sb.append(cell.toString());
				sb.append(" ");
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

	static class InvalidArgumentException extends Exception {
		private static final long serialVersionUID = -5024327897740646827L;

		public InvalidArgumentException(String string) {
			super(string);
		}
	}

	public Complex get(int x, int y) {
		return matrix[x][y];
	}

	public void set(int x, int y, Complex cell) {
		matrix[x][y] = cell;
	}

	public boolean eq(Matrix b) {
		return eq(this, b);
	}

	public static boolean eq(Matrix a, Matrix b) {
		if (a.matrix.length != b.matrix.length) {
			return false;
		}
		for (int i = 0; i < a.matrix.length; i++) {
			if (a.matrix[i].length != b.matrix[i].length) {
				return false;
			}
			for (int j = 0; j < a.matrix[i].length; j++) {
				if (!a.matrix[i][j].eq(b.matrix[i][j]))
					return false;
			}
		}
		return true;
	}
}
