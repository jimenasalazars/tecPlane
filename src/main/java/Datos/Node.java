/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Datos;

/**
 *
 * @author samuel y jimena
 * @param <T>
 */
public class Node<T> {
    //atributos
		public T element;
		public Node<T> next;
		
		//Constructores
		public Node() {
			this.element = null;
			this.next = null;
		}
		
		public Node(T element) {
			this.element = element;
			this.next = null;
		}
		
		public Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}
/**
 * método para obtener el elemento de un nodo
 * @return 
 */
		
		public T getElement() {
			return this.element;
		}
/**
 * metodo para definir el siguiente nodo
 * @param element 
 */		
		public void setElement(T element) {
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
		public void setNext(Node<T> next) {
			this.next = next;	
		}
    
}
