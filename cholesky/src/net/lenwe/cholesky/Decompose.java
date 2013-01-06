package net.lenwe.cholesky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import net.lenwe.cholesky.Matrix.InvalidArgumentException;

public class Decompose {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws InvalidArgumentException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, InvalidArgumentException {
		if(args.length != 1){
			usage();
			return;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Complex> list = new ArrayList<>();
		int dim = Integer.parseInt(args[0]);
		for(int i = 0; i < dim; i++){
			for(int j = 0; j < dim; j++){
				double num[] = new double[2];
				for(int k = 0; k < 2; k++){
					num[k] = Double.parseDouble(in.readLine());
				}
				list.add(new Complex(num[0], num[1]));
			}
		}
		CholeskyDecomposition cholesky = new CholeskyDecomposition(new SquareMatrix((Complex[]) list.toArray()));
		System.out.println(cholesky.getResult().toString());
	}

	private static void usage() {
		System.out.println("Program takes 1 argument - Dim of input matrix - and 2*Dim^2 numbers on standard input one per line:");
		System.out.println("A(1,1).Re A(1,1).Im, ..., A(1,Dim).Re A(1,Dim).Im");
		System.out.println("A(2,1).Re A(2,1).Im, ..., A(2,Dim).Re A(2,Dim).Im");
		System.out.println("...");
		System.out.println("A(Dim,1).Re A(Dim,1).Im, ..., A(Dim,Dim).Re A(Dim,Dim).Im");
	}

}
