
package Datos;
/**
 *
 * @author samuel y jimena
 * @param 
 */
    public class ColaG {
        private Node front;
	private Node rear;
	private int size;
/**
 * metódo para obtener el primer elemento de la cola 
 * @return 
 */
    public Node getFront() {
        return front;
    }
/**
 * metodo para redefinir el valor del primer elemento de la cola
 * @param front 
 */
    public void setFront(Node front) {
        this.front = front;
    }
/**
 * metodo para obtener el ultimo de la cola
 * @return 
 */
    public Node getRear() {
        return rear;
    }
/**
 * metodo para cambiar el valor del ultimo nodo de la cola
 * @param rear 
 */
    public void setRear(Node rear) {
        this.rear = rear;
    }
/**
 * método para obtener el tamaño de la cola
 * @return 
 */
    public int getSize() {
        return size;
    }
/**
 * método para cambiar el valor del tamaño de la cola
 * @param size 
 */
    public void setSize(int size) {
        this.size = size;
    }

/**
 * constructor de la cola
 */
	public ColaG(){
		this.front = new Node();
		this.rear = this.front;
		this.size = 0;
	}
/**
 * metodo para agregar un elemento a la cola
 * @param element 
 */	
	public void enqueue(Personas element){
		this.rear.setNext(new Node(element, null));
		this.rear = rear.getNext();
		this.size++;
	}
/**
 * metodo para sacar un elemento de la cola
 * @return 
 */	
	public Personas dequeue(){
		if(this.size == 0){
			System.out.println("Cola Vacia");
			return null;
		}
		Personas temp = (Personas) this.front.getNext().getElement();
		Node nTemp = this.front.getNext();
		this.front.setNext(nTemp.getNext());
		if (this.rear == nTemp){
			this.rear = this.front;
		}
		this.size--;
		return temp;
	}
/**
 * metodo para obrener el elemento del primer nodo
 * @return 
 */	
	public Object first(){
		if(this.size == 0){
			System.out.println("Cola vacia");
			return null;
		}
		return this.front.getNext().getElement();
	}
/**
 * metodo para obtener el tamaño de la cola
 * @return 
 */	
	public int size(){
		return this.size;
	}
/**
 * metodo para vaciar la cola
 */	
	public void clear(){
		this.front = new Node();
		this.rear = this.front;
		this.size = 0;
	}
/**
 * metodo para conertir la cola en un string
 * @return 
 */	
        @Override
	public String toString(){
		String result = "*Cola*\n";
		Node tFront = this.front;
		int tSize = this.size;
		while(tSize != 0){
			result+= tFront.getNext().getElement() + " ";
			tFront = tFront.getNext();
			tSize--;
		}
		return result;
	}
/**
 * metodo para volver la cola
 */	
	public void rotate(){
		if (this.size == 0) {
			System.out.println("Cola vacia");
		} else {
			Node current = this.front.getNext();
			Node temp = null;
			Node newRear = null;
			while (current != null) {
				if (current == this.front.getNext()){
					temp = new Node(current.getElement(), null);
					newRear = temp;
				} else if (current == this.rear) {
					temp = new Node(current.getElement(), temp);
					this.front.setNext(temp);
				} else {
					temp = new Node(current.getElement(), temp);
				}
				current = current.getNext();
			}
			this.rear = newRear;
		}	
	}
/**
 * método para volver de nuevo la cola 
 */	
	public void rotate2(){
		if (this.size == 0) {
			System.out.println("Cola vacia");
		} else {
			Node next = this.front.getNext();
			Node afterNext = next.getNext();
			Node temp = null;
			
			while (afterNext != null) {
				if (next == this.front.getNext()){
					next.setNext(null);
					this.front.setNext(this.rear);
					this.rear = next;
				} 
				temp =  afterNext.getNext();
				afterNext.setNext(next);
				next = afterNext;
				afterNext = temp;
			}
			
		}	
	}
}
