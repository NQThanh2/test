package Lab7;

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	private LinkedList<Node> expression = new LinkedList<Node>();
	
	public Polynomial() {
		
	}
	public Polynomial(LinkedList<Node> expression) {
		for (Node node : expression) {
			this.expression.add(new Node(node));
		}
	}
	
	//Task 1. perform the addition operator between the
	//polynomial expression and a given node
	public void add(Node node) {
		ListIterator<Node> iter = (ListIterator<Node>) expression.iterator();
		boolean added= false;
		
		
		while (iter.hasNext()) {
			Node next = iter.next();
			
			if(next.isSameExponent(node)) {
				next.updateCoefficient(node, node.ADD);
				added = true;
				break;
			}
			if(next.lessThanExponent(node)) {
				iter.previous();
				iter.add(node);
				added = true;
				break;
			}
		}
		if (!added) {
            iter.add(node);
        }
		
	}
	
	//Task 2. perform the subtraction operator between the polynomial expression and a given node
		public void subtract(Node node) {
			ListIterator<Node> iter = (ListIterator<Node>) expression.iterator();
			boolean subtracted = false;
			
			while(iter.hasNext()) {
				Node next = iter.next();
				
				if(next.isSameExponent(node)) {
					next.updateCoefficient(node, node.SUBTRACT);
					subtracted = true;
					break;
				}
				if(next.lessThanExponent(node)) {
					iter.previous();
					iter.add(node);
					subtracted = true;
					break;
				}
			}
			if (!subtracted) {
				iter.add(node);
			}
			
		}

	//Task 3. perform the addition operator between the current polynomial expression and other
		public Polynomial add(Polynomial other) {
			// TODO
			return null;
		}

	// Task 4. perform the subtraction operator between the current polynomial expression and other
		public Polynomial subtract(Polynomial other) {
			// TODO
			return null;
		}

	// Task 5. perform the multiplication operator between the current polynomial expression and other
		public Polynomial multiply(Polynomial other) {
			
			Polynomial re = new Polynomial();
			for(Node n1 : this.expression) {
				for(Node n2 : other.expression) {
					int Exponent = n1.getExponent() + n2.getExponent();
					int Coefficient = n1.getCoefficient() * n2.getCoefficient();
					
					re.add(new Node(Exponent,Coefficient));
				}
			}
			return re;
		}
	public String toString() {
		String re = "";
		for (Node node : expression) {
			if (node.getExponent() != 0)
				re += node.getCoefficient() + "x^" + node.getExponent() + " ";
			else
				re += node.getCoefficient();
		}
		return re;
	}
	public static void main(String[] args) {
		Polynomial poly1 = new Polynomial();
		poly1.add(new Node(3, 2));
		poly1.add(new Node(4, 3));
		poly1.add(new Node(0, 10));
		poly1.add(new Node(7, 5));
		poly1.add(new Node(5, -1));

		System.out.println("R1: " + poly1);
		Polynomial poly2 = new Polynomial();
		poly2.add(new Node(0, 2));
		poly2.add(new Node(2, 3));
		poly2.add(new Node(5, 1));
		System.out.println("R2: " + poly2);
		
		Polynomial poly3 = poly1.add(poly2);
		System.out.println("R3=R1+R2: " + poly3);

		Polynomial poly4 = poly1.subtract(poly2);
		System.out.println("R4=R1-R2: " + poly4);

		Polynomial poly5 = new Polynomial();
		poly5.add(new Node(0, 2));
		poly5.add(new Node(2, 3));
		System.out.println("R5: "+poly5);

		Polynomial poly6 = poly5.multiply(poly1);
		System.out.println("R6=R5*R1: " + poly6);
	}
}
