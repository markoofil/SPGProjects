package model;

import java.util.ArrayList;
import java.util.Random;

/*
 * This Graphprogram creates only undirected graphs, without self-referring nodes.
 * It's created by myself(Marko Filipovic) for a schoolproject. (HTL-SPG)
 */
public class Matrix
{

	private int node;
	private ArrayList<ArrayList> outer;
	private ArrayList<Integer> inner;

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
		int v = 0;
		for (int h = 0; h < getNode(); h++)
		{
			inner = new ArrayList<Integer>();

			for (int i = 0; i < getNode(); i++)
			{
				v++;
				inner.add(v);
			}
			outer.add(inner);
		}

	}

	public void printMatrix()
	{

		for (int h = 0; h < outer.size(); h++)
		{
			for (int i = 0; i < outer.size(); i++)
			{

				System.out.print(String.format("%3d", outer.get(h).get(i)));
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
		if(v1 > 0 && v2 > 0)
		{
			v1 = v1 - 1;
			v2 = v2 - 1;

			outer.get(v1).set(v2, value);
		}
	}

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

	public void randomMatrix(int nodes, int valencyMax) // without self-referring nodes
	{

		setNode(nodes);
		int x = 0;
		for (int h = 0; h < getNode(); h++)
		{
			inner = new ArrayList<Integer>();

			for (int i = 0; i < getNode(); i++)
			{
				if(h != i)
				{
					x = (int) (Math.random() * 10 + 1);
					inner.add(x<valencyMax?x:0);
				}
				else
					inner.add(0);
			}
			outer.add(inner);
		}
	}
}
