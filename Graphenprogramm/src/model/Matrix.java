package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	private ArrayList<ArrayList<Integer>> matrix;

	public Matrix(int node)
	{
		setNode(node);
		matrix = new ArrayList<>();
		newMatrix();
	}

	public void setNode(int node)
	{
		// TODO:plausibilitätsprüfung
		this.node = node;
	}

	public int getNode()
	{
		return node;
	}

	public void createMatrix(ArrayList<ArrayList<Integer>> temp)
	{
		for (int i = 0; i < node; i++)
		{
			temp.add(new ArrayList<Integer>());
			for (int j = 0; j < node; j++)
			{
				temp.get(i).add(j, 0);
			}
		}
	}

	public void newMatrix()
	{
		for (int i = 0; i < node; i++)
		{
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < node; j++)
			{
				matrix.get(i).add(j, 0);
			}
		}
	}

	public void printMatrix()
	{
		for (int i = 0; i < getNode(); i++)
		{
			for (int j = 0; j < getNode(); j++)
			{
				System.out.print(String.format("%3d", (matrix.get(i).get(j))));
			}
			System.out.println();
		}
	}

	public void printMatrix(ArrayList<ArrayList<Integer>> m)
	{
		for (int i = 0; i < getNode(); i++)
		{
			for (int j = 0; j < getNode(); j++)
			{
				System.out.print(String.format("%3d", m.get(i).get(j)));
			}
			System.out.println();
		}
	}

	public String toString()
	{
		String str = "";

		str += "Node: " + getNode();

		return str;
	}

	public void print()
	{
		System.out.println(toString());
		printMatrix();
	}

	public void setValency(int i, int j, int valency)
	{
		matrix.get(i).set(j, valency);
	}

	public void multiply()
	{

		ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		createMatrix(temp);

		int sum = 0;

		System.out.println(" Mit sich selbst multipliziert =  ");
		for (int k = 0; k < getNode(); k++)
		{
			for (int i = 0; i < getNode(); i++)
			{
				for (int j = 0; j < getNode(); j++)
				{
//					System.out.print("get.(" + k + ")" + ".get(" + j + ") = " + temp.get(j).get(k));
//					System.out.println(" get.(" + i + ")" + ".get(" + j + ") = " + temp.get(i).get(j));
//					System.out.print("get.(" + k + ")" + ".get(" + j + ") = " + matrix.get(k).get(j));
//					System.out.println(" get.(" + j + ")" + ".get(" + i + ") = " + matrix.get(j).get(i));
					sum += (matrix.get(k).get(j)) * (matrix.get(j).get(i));

				}

				temp.get(k).add(i, sum);
				sum = 0;

			}
		}
		for (int i = 0; i < getNode(); i++)
		{
			for (int j = 0; j < getNode(); j++)
			{
				System.out.print(String.format("%3d", temp.get(i).get(j)));
			}
			System.out.println();
		}

		matrix.clear();
		createMatrix(matrix);

		for (int i = 0; i < getNode(); i++)
		{
			for (int j = 0; j < getNode(); j++)
			{
				matrix.get(i).add(j, temp.get(i).get(j));
			}
		}

	}

}
