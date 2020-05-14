package test;
import model.Matrix;

public class TestMatrix
{

	public static void main(String[] args)
	{
		
		Matrix m = new Matrix(5);
//		System.out.println(m.getKnoten()+" Knoten");
		

		
//		m.startMatrix();
		m.randomMatrix(6, 4);
		m.printMatrix();
//		m.showEdge(1, 0);
//		m.changeEdge(1, 0, 0);
//		m.showEdge(1, 0);
//		m.printMatrix();
//		m.zeroMatrix();
//		m.changeEdge(3, 3, 1);
//		m.printMatrix();
//		m.addEdge(6, 3);
//		m.addEdge(3, 3);
//		m.addEdge(3, 3);
//		m.addEdge(0, 0); // Fehlermeldung 0 bis negative Eingabe
//		m.addEdge(3, 3);
//		m.printMatrix();
	}

}
