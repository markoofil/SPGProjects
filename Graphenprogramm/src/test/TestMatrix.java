package test;
import model.Matrix;

public class TestMatrix
{

	public static void main(String[] args)
	{
		
		Matrix m = new Matrix(3);
//		System.out.println(m.getKnoten()+" Knoten");
		

		
		m.startMatrixNew();
//		m.printMatrix();
//		m.randomMatrix(6, 4);
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
		
//		m.changeEdge(0, 0, 1);
//		m.changeEdge(1, 0, 0);
//		m.changeEdge(2, 0, 1);
//		m.changeEdge(0, 1, 0);
//		m.changeEdge(1, 1, 1);
//		m.changeEdge(2, 1, 1);
//		m.changeEdge(0, 2, 0);
//		m.changeEdge(1, 2, 1);
//		m.changeEdge(2, 2, 1);
//----------------------------------
		m.changeEdge(0, 0, 1);
		m.changeEdge(0, 1, 0);
		m.changeEdge(0, 2, 1);
		m.changeEdge(1, 0, 0);
		m.changeEdge(1, 1, 1);
		m.changeEdge(1, 2, 1);
		m.changeEdge(2, 0, 0);
		m.changeEdge(2, 1, 1);
		m.changeEdge(2, 2, 1);
		m.printMatrix();
		System.out.println("------------");
		
		
	}

}
