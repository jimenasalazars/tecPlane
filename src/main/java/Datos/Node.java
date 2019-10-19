/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Datos;

/**
 *
 * @author samuel y jimena
 * @param 
 */
public class Node {
    //atributos
		public Personas element;
		public Node next;
		
		//Constructores
		public Node() {
			this.element = null;
			this.next = null;
		}
		
		public Node(Personas element) {
			this.element = element;
			this.next = null;
		}
		
		public Node(Personas element, Node next) {
			this.element = element;
			this.next = next;
		}
/**
 * método para obtener el elemento de un nodo
 * @return 
 */
		
		public Personas getElement() {
			return this.element;
		}
/**
 * metodo para definir el siguiente nodo
 * @param element 
 */		
		public void setElement(Personas element) {
			this.element = element;
		}
/**
 * método para referenciar el siguiente nodo
 * @return 
 */		
		public Node getNext() {
			return this.next;
		}
/**
 * método para definir el siguiente nodo
 * @param next 
 */		
		public void setNext(Node next) {
			this.next = next;	
		}
    
}
