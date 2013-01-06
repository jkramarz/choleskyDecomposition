package net.lenwe.cholesky;

import static org.junit.Assert.*;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

import org.junit.Test;

public class CholeskyDecompositionTest {

	@Test
	public void testCholeskyDecomposition1() throws InvalidArgumentException {
		Complex[] c = {new Complex(1,0), new Complex(0,0), new Complex(0,0), new Complex(1, 0)};
		SquareMatrix m = new SquareMatrix(c);
		CholeskyDecomposition cholesky = new CholeskyDecomposition(
			m
		);
		cholesky.getResult().eq(m);
	}
	
	@Test
	public void testCholeskyDecomposition2() throws InvalidArgumentException {
		double[] c = {
				4, -2, 2,
				-2, 2, 2,
				2, 2, 14
		};
		double[] expected = {
				2, 0, 0,
				-1, 1, 0,
				1, 3, 2,
		};
		SquareMatrix m = new SquareMatrix(c);
		CholeskyDecomposition cholesky = new CholeskyDecomposition(
			m
		);
		System.out.println(cholesky.getResult().toString());
		assertTrue(new SquareMatrix(expected).eq(cholesky.getResult()));
		
	}

}
