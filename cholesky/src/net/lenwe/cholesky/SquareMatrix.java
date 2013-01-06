package net.lenwe.cholesky;

public class SquareMatrix extends Matrix {
	int dim;
	SquareMatrix(Complex[] num) throws InvalidArgumentException {
		fill(num);
	}

	private void fill(Complex[] num) throws InvalidArgumentException {
		dim = (int) Math.sqrt(num.length);
		if (Math.pow(dim, 2) != num.length) {
			throw new InvalidArgumentException("Not a square matrix!");
		}
		matrix = new Complex[dim][dim];
		for (int row = 0, col = 0, i = 0; i < num.length; i++) {
			matrix[row][col] = num[i];
			if (col == dim - 1) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
	}	
	
	public SquareMatrix(SquareMatrix input) {
		super((Matrix) input);
	}

	public SquareMatrix(double[] c) throws InvalidArgumentException {
		Complex[] cmp = new Complex[c.length];
		for(int i = 0; i < c.length; i++){
			cmp[i] = new Complex(c[i], 0);
		}
		fill(cmp);
	}

	boolean isSymmetric(){
		for(int i = 0; i < dim; i++){
			for(int j = i+1; j < dim; j++){
				if(get(i, j) != get(j, i)){
					return false;
				}
			}
		}
		return true;
	}
	boolean isHermitian(){
		for(int i = 0; i < dim; i++){
			for(int j = i+1; j < dim; j++){
				if(get(i, j) != get(j, i).conj()){
					return false;
				}
			}
		}
		return true;
	}

	public int dim() {
		return dim;
	}
	

}
