package net.lenwe.cholesky;

import static org.junit.Assert.*;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

import org.junit.Test;

public class ComplexTest {

	@Test
	public void testComplex() {
		Complex c = new Complex(0., 0.);
		assertTrue(c instanceof Complex);
	}

	@Test
	public void testEquals() {
		Complex c = new Complex(0., 0.);
		assertTrue(c.eq(c));
	}
	@Test
	public void testSumComplex() {
		Complex c = new Complex(1.23, -1.23);
		assertTrue(c.sum(new Complex(1.27, -1.27)).eq(new Complex(2.5, -2.5)));
	}

	@Test
	public void testSumComplexComplex() {
		assertTrue(Complex.sum(new Complex(1.23, -1.23), new Complex(1.27, -1.27)).eq(new Complex(2.5, -2.5)));
	}

	@Test
	public void testSubComplex() {
		Complex c = new Complex(1., 1.);
		assertTrue(c.sub(new Complex(1., -1.)).eq(new Complex(0., 2.)));
	}

	@Test
	public void testSubComplexComplex() {
		assertTrue(Complex.sub(new Complex(1., 1.), new Complex(1., -1.)).eq(new Complex(0., 2.)));
	}

	@Test
	public void testProdDouble() {
		Complex c = new Complex(1., 1.);
		assertTrue(c.prod(2).eq(new Complex(2., 2.)));
	}

	@Test
	public void testProdComplexDouble() {
		assertTrue(Complex.prod(new Complex(1., 1.), 2).eq(new Complex(2., 2.)));
	}

	@Test
	public void testProdComplex() {
		Complex c = new Complex(1, 2);
		assertTrue(c.prod(new Complex(3, -4)).eq(new Complex(11, 2)));
	}

	@Test
	public void testProdComplexComplex() {
		assertTrue(Complex.prod(new Complex(1, 2), new Complex(3, -4)).eq(new Complex(11, 2)));
	}

	@Test
	public void testDivDouble() {
		Complex c = new Complex(1., 1.);
		assertTrue(c.div(2).eq(new Complex(0.5, 0.5)));
	}

	@Test
	public void testDivComplexDouble() {
		assertTrue(Complex.div(new Complex(1., 1.), 2).eq(new Complex(0.5, 0.5)));
	}

	@Test
	public void testDivComplex() throws InvalidArgumentException {
		Complex c = new Complex(1, 2);
		assertTrue(c.div(new Complex(3, -4)).eq(new Complex(-0.2, 0.4)));
	}

	@Test
	public void testDivComplexComplex() throws InvalidArgumentException {
		assertTrue(Complex.div(new Complex(1, 2), new Complex(3, -4)).eq(new Complex(-0.2, 0.4)));
	}

	@Test
	public void testSqrt() {
		Complex c = new Complex(3, -4);
		assertTrue(c.sqrt().eq(new Complex(2, -1)));
	}

	@Test
	public void testSqrtComplex() {
		assertTrue(Complex.sqrt(new Complex(3, -4)).eq(new Complex(2, -1)));
	}

	@Test
	public void testAbs() {
		Complex c = new Complex(3, -4);
		assertTrue(c.abs() == 5);
	}

	@Test
	public void testAbsComplex() {
		assertTrue(Complex.abs(new Complex(3, -4)) == 5);
	}

	@Test
	public void testConj() {
		Complex c = new Complex(1., 1.);
		assertTrue(c.conj().eq(new Complex(1., -1.)));
	}

	@Test
	public void testConjComplex() {
		assertTrue(Complex.conj(new Complex(1., 1.)).eq(new Complex(1., -1.)));
	}

	@Test
	public void testIm() {
		Complex c = new Complex(1., 2.);
		assertTrue(c.im() == 2.);
	}

	@Test
	public void testRe() {
		Complex c = new Complex(1., 2.);
		assertTrue(c.re() == 1.);
	}

	@Test
	public void testToString() {
		Complex c = new Complex(1., 2.);
		assertEquals("[1.0;2.0]", c.toString()); 
	}

}
