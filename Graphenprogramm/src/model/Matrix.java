package model;

import java.util.ArrayList;
import java.util.Random;

/*
 * This Graphprogram creates only undirected graphs, without self-referring nodes.
 * It's created by myself(Marko Filipovic) for a schoolproject. (HTL-SPG)
 * 
 * TO-DO: 
 * Exceptionhandling
 * Multiplication
 * 
 */
public class Matrix
{

	private int node;
	private ArrayList<ArrayList> outer;

	public Matrix(int node)
	{
		setNode(node);
		outer = new ArrayList<ArrayList>();

	}

	public void setNode(int node)
	{
		this.node = node;
	}

	public int getNode()
	{
		return node;
	}

	public void startMatrix()
	{
		ArrayList<Integer> inner;

		for (int h = 0; h < getNode(); h++)
		{
			inner = new ArrayList<Integer>();

			for (int i = 0; i < getNode(); i++)
			{

				inner.add(0);
			}
			outer.add(inner);
		}

	}

//	probably if i make it return an arraylist it's gonna be easier to work with it..
	public ArrayList<ArrayList> startMatrixNew()
	{
		ArrayList<Integer> inner;

		for (int h = 0; h < getNode(); h++)
		{
			inner = new ArrayList<Integer>();

			for (int i = 0; i < getNode(); i++)
			{

				inner.add(0);
			}
			outer.add(inner);
		}
		return outer;

	}
	/*
	 * public void startMatrix() { ArrayList<Integer> inner;
	 * 
	 * int v = 0; for (int h = 0; h < getNode(); h++) { inner = new
	 * ArrayList<Integer>();
	 * 
	 * for (int i = 0; i < getNode(); i++) { v++; inner.add(v); } outer.add(inner);
	 * }
	 * 
	 * } Specific test. Don't mind that. Don't ask questions.
	 */

	public void printMatrix()
	{

		for (int column = 0; column < outer.size(); column++)
		{
			for (int row = 0; row < outer.size(); row++)
			{

				System.out.print(String.format("%3d", outer.get(column).get(row)));
			}
			System.out.println();
		}
	}

	public void showEdge(int v1, int v2)
	{
		System.out.println(outer.get(v1).get(v2));

	}

	@SuppressWarnings("unchecked")
	public void changeEdge(int v1, int v2, int value)
	{
		if(v1 >= 0 && v2 >= 0)
		{
			outer.get(v1).set(v2, value);
		}
	}

	/*
	 * @SuppressWarnings("unchecked") public void changeEdgeManualy(int v1, int v2,
	 * int value) { if(v1 > 0 && v2 > 0) { v1 = v1 - 1; v2 = v2 - 1;
	 * 
	 * outer.get(v1).set(v2, value); } }
	 */
	@SuppressWarnings("unchecked")
	public void addEdge(int v1, int v2) // increases the node-degree(?? valency .. Wertigkeit/Valenz ??) by 1
	{
		if(v1 > 0 & v2 > 0)
		{
			if(v1 < node && v2 < node)
			{
				if(v1 > 0 && v2 > 0)
				{
					if(v1 != v2)
					{
						v1 = v1 - 1; // that way, the user just needs to type in the node
						v2 = v2 - 1;
						int n = (int) outer.get(v1).get(v2);
						n++;
						outer.get(v1).set(v2, n);
					}
					else
						System.out.println("No Loops!");
				}
			}
			else
				System.out.println("Graph doesn't have so many nodes. Amount of nodes: " + node);
		}
		else
			System.out.println("Tryin' to work with a negativ node is a No-Go dude. Node need's to be 1 or higher");
	}

	@SuppressWarnings("unchecked")
	public void zeroMatrix()
	{

		for (int i = 0; i < outer.size(); i++)
		{
			for (int j = 0; j < outer.size(); j++)
				outer.get(i).set(j, 0);
		}
	}
	/*
	 * public void randomMatrix(int nodes, int valencyMax) // without self-referring
	 * nodes { ArrayList<Integer> inner;
	 * 
	 * setNode(nodes); int x = 0; for (int h = 0; h < getNode(); h++) { inner = new
	 * ArrayList<Integer>();
	 * 
	 * for (int i = 0; i < getNode(); i++) { if(h != i) { x = (int) (Math.random() *
	 * 10 + 1); inner.add(x<valencyMax?x:0); } else inner.add(0); }
	 * outer.add(inner); } }
	 */

//	multiplication hardcoded

	public void multiplicateMatrix()
	{
		// graphx: create new graph - for saving the result				
		// graph1: iterate through graph1 outer.get(h0).get(i0)
		// graph2: iterate through graph2 outer.get(h0).get(i0)
		// multiplicate graph1.currentValue by graph2.currentValue -- save as temp.
		// value
		// prepare position x & y or iterate through it ..
		// add temp. value to graphx @ pos x & y graphx.changeEdge(x, y, temp. value)
		// graph1: increase h++
		// graph2: increase i++

//	ArrayList<ArrayList> temp = outer; 
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	int prod = 0;
//	int f1, f2 = 0;
	
	for (int i = 0; i < outer.size(); i++)
	{
//		outer.get(i).get
	}
//	 ---------------	Faktor 1 -------------- * ------------ Faktor 2 -------------
//	|prod += (int)(outer.get(row0).get(column0))*(int)(outer.get(column0).get(row0));|
//	|prod += (int)(outer.get(row0).get(column1))*(int)(outer.get(column1).get(row0));|
//	|prod += (int)(outer.get(row0).get(column2))*(int)(outer.get(column2).get(row0));|
//	|result.get(0).set(0, prod);													 |
//	|prod = 0;																		 |
//	 --------------------------------------------------------------------------------
//	prod += (int)(outer.get(row0).get(column0))*(int)(outer.get(row0).get(column1));
//	prod += (int)(outer.get(row0).get(column1))*(int)(outer.get(row1).get(column1));
//	prod += (int)(outer.get(row0).get(column2))*(int)(outer.get(row2).get(column1));
//	result.get(0).set(1, prod);
//	prod = 0;
//	prod += (int)(outer.get(row0).get(column0))*(int)(outer.get(row0).get(column2));
//	prod += (int)(outer.get(row0).get(column1))*(int)(outer.get(row1).get(column2));
//	prod += (int)(outer.get(row0).get(column2))*(int)(outer.get(row2).get(column2));
//	result.get(0).set(1, prod);
//	prod = 0;
	
	for(int resultColumn = 0; resultColumn < outer.size(); resultColumn++)
	{
		for(int resultRow = 0; resultRow < outer.size(); resultRow++)
		{
			for(int row = 0; row < outer.size(); row++)
			{
				int column = 0;
				while(column < outer.size())
				{
					prod += (int)(outer.get(row).get(column))*(int)(outer.get(column).get(row));
					column++;
				}
			}
			result.get(resultColumn).set(resultRow, prod);
			prod = 0;
		}
	}
	
	

	}

}
