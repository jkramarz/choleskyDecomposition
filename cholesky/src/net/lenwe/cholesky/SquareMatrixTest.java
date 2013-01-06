package net.lenwe.cholesky;

import static org.junit.Assert.*;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

import org.junit.Test;

public class SquareMatrixTest {

	@Test
	public void testSquareMatrixSquareMatrix() throws InvalidArgumentException {
		double d[] = { 1, 2, 2, 0 };
		SquareMatrix s = new SquareMatrix(d);
		SquareMatrix t = new SquareMatrix(s);
		assertTrue(s.eq(t));
		t.set(1, 1, new Complex(1,1));
		assertFalse(s.eq(t));
	}

	@Test
	public void testIsSymmetric1() throws InvalidArgumentException {
		double d[] = { 1, 2, 2, 0 };
		SquareMatrix s = new SquareMatrix(d);
		assertTrue(s.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric2() throws InvalidArgumentException {
		double d[] = { 1, 2, 1, 2 };
		SquareMatrix s = new SquareMatrix(d);
		assertFalse(s.isSymmetric());
	}

	@Test
	public void testIsHermitian1() throws InvalidArgumentException {
		Complex c[] = { new Complex(1, -1), new Complex(2, 1), new Complex(2, 1), new Complex(0, -1) };
		SquareMatrix s = new SquareMatrix(c);
		assertTrue(s.isHermitian());
	}

	@Test
	public void testIsHermitian2() throws InvalidArgumentException {
		Complex c[] = { new Complex(1, -1), new Complex(2, -1), new Complex(2, 1), new Complex(0, -1) };
		SquareMatrix s = new SquareMatrix(c);
		assertFalse(s.isHermitian());
	}
	
	@Test
	public void testDim() throws InvalidArgumentException {
		double d[] = { 1, 2, 2, 0 };
		SquareMatrix s = new SquareMatrix(d);
		assertTrue(s.dim() == 2);
	}

}
