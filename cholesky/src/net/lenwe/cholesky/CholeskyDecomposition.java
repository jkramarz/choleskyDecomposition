package net.lenwe.cholesky;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

public class CholeskyDecomposition {
	SquareMatrix result;
	SquareMatrix input;
	
	public CholeskyDecomposition(SquareMatrix input) throws InvalidArgumentException{
		this.input = input;
		result = new SquareMatrix(this.input);
		result.blank();
		decompose();
		this.input = null;
	}
	public SquareMatrix getResult(){
		return result;
	}
	private void decompose() throws InvalidArgumentException{
		for(int i = 0; i < result.dim(); i++){
			for(int j = 0; j <= i; j++){
				if(i == j){
					computeDiagonal(i);
				}else{
					computeOther(i, j);
				}
			}
		}
	}
	private void computeOther(int i, int j) throws InvalidArgumentException {
		Complex sum = new Complex(0, 0);
		for(int k = 0; k < i; k++)
			sum = sum.sum(Complex.prod(result.get(i, k), result.get(j, k).conj()) );
		sum = input.get(i, j).sub(sum);
		Complex prod = new Complex(1, 0).div(result.get(j, j));
		result.set(i, j, sum.prod(prod));
	}
	private void computeDiagonal(int j) {
		Complex sum = new Complex(0, 0);
		for(int k = 0; k < j; k++)
			sum = sum.sum(Complex.prod(result.get(j, k), result.get(j, k).conj()));
		result.set(j, j, input.get(j, j).sub(sum).sqrt());
	}
}


