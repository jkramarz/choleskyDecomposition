package net.lenwe.cholesky;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

public class Complex {
	private double im;
	private double re;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/*
	 * sum
	 */
	public Complex sum(Complex b) {
		return sum(this, b);
	}

	public static Complex sum(Complex a, Complex b) {
		return new Complex(a.re() + b.re(), a.im() + b.im());
	}

	/*
	 * substract
	 */
	public Complex sub(Complex b) {
		return sub(this, b);
	}

	public static Complex sub(Complex a, Complex b) {
		return new Complex(a.re() - b.re(), a.im() - b.im());
	}

	/*
	 * product
	 */
	public Complex prod(double b) {
		return prod(this, b);
	}

	public static Complex prod(Complex a, double b) {
		return new Complex(a.re() * b, a.im() * b);
	}

	public Complex prod(Complex b) {
		return prod(this, b);
	}

	public static Complex prod(Complex a, Complex b) {
		return new Complex(
			a.re() * b.re() - a.im() * b.im(), //Re
			a.im() * b.re() + a.re() * b.im()  //Im
		);
	}

	/*
	 * division
	 */
	public Complex div(double b) {
		return div(this, b);
	}

	public static Complex div(Complex a, double b) {
		return new Complex(a.re() / b, a.im() / b);
	}

	public Complex div(Complex divider) throws InvalidArgumentException {
		return div(this, divider);
	}

	public static Complex div(Complex a, Complex b) throws InvalidArgumentException {
		// based on G. W. Stewart's JamPack
		double avi, tre, tim;
        avi = abs(b);
        if (avi == 0){
           throw new InvalidArgumentException("Division by zero.");
        }
        avi = 1./avi;
        tre = b.re()*avi;
        tim = -b.im()*avi;
        return new Complex(
        	(a.re()*tre - a.im()*tim)*avi, //Re
        	(a.im()*tre + a.re()*tim)*avi  //Im
        );
	}

	/*
	 * square root
	 */
	public Complex sqrt() {
		return sqrt(this);
	}

	public static Complex sqrt(Complex a) {
		// based on G. W. Stewart's JamPack
		double t, re, im;
		t = a.abs();
		if (Math.abs(a.re()) <= Math.abs(a.im())) {
			// No cancellation in these formulas
			re = Math.sqrt(0.5 * (t + a.re()));
			im = Math.sqrt(0.5 * (t - a.re()));
		} else {
			// Stable computation of the above formulas
			if (a.re() > 0) {
				re = t + a.re();
				im = Math.abs(a.im()) * Math.sqrt(0.5 / re);
				re = Math.sqrt(0.5 * re);
			} else {
				im = t - a.re();
				re = Math.abs(a.im()) * Math.sqrt(0.5 / im);
				im = Math.sqrt(0.5 * im);
			}
		}
		if (a.im() < 0) {
			return new Complex(re, -im);
		} else {
			return new Complex(re, im);
		}
	}

	/*
	 * absolute value
	 */
	public double abs() {
		return abs(this);
	}

	public static double abs(Complex a) {
		// based on G. W. Stewart's JamPack
		double re = Math.abs(a.re());
		double im = Math.abs(a.im());
		if (re == 0 && im == 0) {
			return 0;
		} else if (re >= im) {
			return re * Math.sqrt(1 + Math.pow(im / re, 2));
		} else {
			return im * Math.sqrt(1 + Math.pow(re / im, 2));
		}
	}

	/*
	 * conjungtion
	 */
	public Complex conj() {
		return conj(this);
	}

	public static Complex conj(Complex a) {
		return new Complex(a.re(), -a.im());
	}

	/*
	 * accessors
	 */
	public double im() {
		return im;
	}

	public double re() {
		return re;
	}

	/*
	 * Printable format of complex number (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + re + ";" + im + "]";
	}

	public boolean eq(Complex c) {
		return equals(this, c);
	}

	public static boolean equals(Complex a, Complex b) {
		return a.re() == b.re() && a.im() == b.im();
	}

}
