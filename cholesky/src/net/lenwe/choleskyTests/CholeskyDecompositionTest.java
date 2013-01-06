package net.lenwe.choleskyTests;

import static org.junit.Assert.assertTrue;
import net.lenwe.cholesky.CholeskyDecomposition;
import net.lenwe.cholesky.Complex;
import net.lenwe.cholesky.SquareMatrix;

import org.junit.Test;

public class CholeskyDecompositionTest {

	@Test
	public void testCholeskyDecomposition1() throws Exception {
		Complex[] c = {
				new Complex(1,0), new Complex(0,0),
				new Complex(0,0), new Complex(1,0)
		};
		SquareMatrix m = new SquareMatrix(c);
		CholeskyDecomposition cholesky = new CholeskyDecomposition(
			m
		);
		cholesky.getResult().eq(m);
	}
	
	@Test
	public void testCholeskyDecomposition2() throws Exception {
		double[] c = {
				1, 1, 1, 1, 1,
				1, 2, 3, 4, 5,
				1, 3, 6,10,15,
				1, 4,10,20,35,
				1, 5,15,35,70
		};
		double[] d = {
				1, 0, 0, 0, 0,
				1, 1, 0, 0, 0,
				1, 2, 1, 0, 0,
				1, 3, 3, 1, 0,
				1, 4, 6, 4, 1
		};
		SquareMatrix expected = new SquareMatrix(d);
		
		SquareMatrix m = new SquareMatrix(c);
		CholeskyDecomposition cholesky = new CholeskyDecomposition(
			m
		);
		
		assertTrue(expected.eq(cholesky.getResult()));
		
	}

}
