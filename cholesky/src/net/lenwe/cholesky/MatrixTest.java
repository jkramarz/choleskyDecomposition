package net.lenwe.cholesky;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testGet() {
		double d[][] = { {1} };
		Matrix m = new Matrix(d);
		assertTrue(m.get(0, 0).eq(new Complex(1,0)));
	}

	@Test
	public void testSet() {
		double d[][] = { {1} };
		Matrix m = new Matrix(d);
		m.set(0, 0, new Complex(2,1));
		assertTrue(m.get(0, 0).eq(new Complex(2,1)));
	}

}
