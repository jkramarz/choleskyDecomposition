package net.lenwe.choleskyTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.lenwe.cholesky.Complex;
import net.lenwe.cholesky.SquareMatrix;

import org.junit.Test;

public class SquareMatrixTest {

	@Test
	public void testSquareMatrixSquareMatrix() throws Exception {
		double d[] = { 1, 2, 2, 0 };
		SquareMatrix s = new SquareMatrix(d);
		SquareMatrix t = new SquareMatrix(s);
		assertTrue(s.eq(t));
		assertTrue(s.dim() == t.dim());
		t.set(1, 1, new Complex(1,1));
		assertFalse(s.eq(t));
	}

	@Test
	public void testIsSymmetric1() throws Exception {
		double d[] = {
			1, 2,
			2, 0
		};
		SquareMatrix s = new SquareMatrix(d);
		assertTrue(s.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric2() throws Exception {
		double d[] = {
			1, 2,
			1, 2
		};
		SquareMatrix s = new SquareMatrix(d);
		assertFalse(s.isSymmetric());
	}

	@Test
	public void testIsHermitian1() throws Exception {
		Complex c[] = {
			new Complex(1, -1), new Complex(2, 1),
			new Complex(2, -1), new Complex(0, -1)
		};
		SquareMatrix s = new SquareMatrix(c);
		assertTrue(s.isHermitian());
	}

	@Test
	public void testIsHermitian2() throws Exception {
		Complex c[] = {
			new Complex(1, -1), new Complex(2, -1),
			new Complex(2, -1), new Complex(0, -1)
		};
		SquareMatrix s = new SquareMatrix(c);
		assertFalse(s.isHermitian());
	}
	
	@Test
	public void testDim() throws Exception {
		double d[] = { 1, 2, 2, 0 };
		SquareMatrix s = new SquareMatrix(d);
		assertTrue(s.dim() == 2);
	}

}
