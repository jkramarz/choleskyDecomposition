package net.lenwe.cholesky;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

public class CholeskyDecomposition {
	SquareMatrix result;
	SquareMatrix input;
	
	public CholeskyDecomposition(SquareMatrix input) throws InvalidArgumentException{
		this.input = input;
		result = new SquareMatrix(input);
		decompose();
		input = null;
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
		result.set(i, j, input.get(i, j).sub(sum).prod(new Complex(1, 0).div(result.get(j, j))));
	}
	private void computeDiagonal(int i) {
		Complex sum = new Complex(0, 0);
		for(int k = 0; k < i; k++)
			sum = sum.sum(Complex.prod(result.get(i, k), result.get(i, k).conj()));
		result.set(i, i, input.get(i, i).sub(sum).sqrt());
	}
}
