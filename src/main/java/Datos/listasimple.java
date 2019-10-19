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

public class listasimple <T> {

        
	//atributos LinkedList
	private Node<T> head;
	private Node<T> current;
	private Node<T> tail;
	private int position;
	private int size;
	
	//constructores LinkedList
	
	/**
	 * Contructor predeterminado
	 */
	public listasimple() {
		this.head = new Node<T>();
		this.current = this.head;
		this.tail = this.head;
		this.size = 0;
		this.position = -1;
	}

    /**
     * constructor por defecto
     *
     * @param lista
     */
    public listasimple(listasimple lista) {

    }

    /**
     * método para obtener el primer nodo de la lista
     *
     * @return
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * metodo para definir el primer nodo de la lista
     *
     * @param head
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * método para obtener el nodo current
     *
     * @return
     */
    public Node<T> getCurrent() {
        return current;
    }

    /**
     * método para definir el current
     *
     * @param current
     */
    public void setCurrent(Node<T> current) {
        this.current = current;
    }

    /**
     * método para obtener el ultimo nodo de la lista
     *
     * @return
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * método para definir el ultimo nodo
     *
     * @param tail
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    /**
     * método para definir la posicion
     *
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * método para obtener la posicion
     *
     * @return
     */
    public int getposition() {
        return this.position;
    }

    /**
     * método para obtener el tamaño de la lista
     *
     * @return
     */
    public int getsize() {
        return this.size;
    }

    /**
     * método para obtener la farmacia del current
     *
     * @return
     */
    public Object getfarmacia() {
        return this.current.getElement();
    }

    /**
     * método para insertar un elemento a la lista
     *
     * @param element
     */
    public void insert(T element) {
        //insertar en cualquier posici�n
        Node<T> newNode = new Node(element, this.current.getNext());
        this.current.setNext(newNode);
        this.current = newNode;
        this.setPosition(position + 1);

        //necesario si se est� insertando al final de la lista
        if (this.current == this.tail) {
            this.tail = tail.getNext();
        }
        this.size++;

    }

    /**
     * método para añadir un elemento a la lista
     *
     * @param element
     */
    public void append(T element) {
        //siempre se pega al final de la lista
        Node<T> newNode = new Node(element);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.size++;
    }

    /**
     * método para remover un elemento de la lista
     */
    public void remove() {
        //verificar que la lista no est� vac�a
        if ((this.head == this.current) && (this.head == this.tail)) {
            return;
        } //tambi�n if (this.size == 0) ...

        //en temp se va a almacenar el nodo ANTERIOR al que se quiere borrar
        Node<T> temp = this.head;
        while (temp.getNext() != this.current) {
            temp = temp.getNext();
        }
        //borrar la referencia al nodo actual
        temp.setNext(this.current.getNext());
        //necesario si se esta borrando el �ltimo nodo
        if (this.current == this.tail) {
            this.current = this.tail = temp;
            this.position--;
        } else //necesario si se est� borrando un nodo diferente al �ltimo
        {
            this.current = this.current.getNext();
        }

        //disminuir el tama�o
        this.size--;
    }

    /**
     * método para vaciar la lista
     */
    public void clear() {
        this.head = this.tail = this.current = new Node();
        this.position = -1;
        this.size = 0;
    }

    /**
     * método para obtener el elemento de la lista
     *
     * @return
     */
    public Object getElement() {
        return this.current.getElement();
    }

    /**
     * método prar obtener el tamaño de la lista
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * metodo para moverme un nodo hacia al frente
     *
     * @return
     */
    public boolean next() {
        if (this.current == this.tail) {
            System.out.println("Actualmente en �ltimo nodo, no se puede avanzar");
            return false;
        }
        this.current = this.current.getNext();
        this.position++;
        return true;
    }

    /**
     * método para moverme un método hacia atras
     *
     * @return
     */
    public boolean previous() {
        if (this.current == this.head) {
            System.out.println("Actualmente en primer nodo, no se puede retroceder");
            return false;
        }
        Node temp = head;
        this.position = -1;
        while (temp.getNext() != this.current) {
            temp = temp.getNext();
            this.position++;
        }
        this.current = temp;
        return true;
    }

    /**
     * método para obtener la posicion del current
     *
     * @return
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * método para mover el current al principio de la lista
     */
    public void goToStart() {
        this.current = this.head;
        this.position = -1;
    }

    /**
     * método para mover el current al final de la lista
     */
    public void goToEnd() {
        this.current = this.tail;
        this.position = this.size - 1;
    }

    /**
     * método para mover el current a la posicion ingresada
     *
     * @param pos
     */
    public void goToPos(int pos) {
        if (pos < 0 || pos >= this.size) {
            System.out.println("Posici�n inv�lida");
            return;
        }
        if (pos > this.position) {
            while (pos > this.position) {
                this.next();
            }
        } else if (pos < this.position) {
            while (pos < this.position) {
                this.previous();
            }
        }
    }

    /**
     * método para obtener la posicion de un elemento ingresado
     *
     * @param element
     * @return
     */
    public int getPositionOfElement(Object element) {
        Node tempNode = this.head;
        int positions = -1;
        while (tempNode != null) {
            if (tempNode.getElement() != null && tempNode.getElement().equals(element)) {
                return positions;
            }
            tempNode = tempNode.getNext();
            positions++;
        }
        return -1;
    }

}
