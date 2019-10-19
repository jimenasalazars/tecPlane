
package Datos;
/**
 *
 * @author samuel y jimena
 * @param <T>
 */
public class ColaG <T>{
        private Node<T> front;
	private Node<T> rear;
	private int size;
/**
 * metódo para obtener el primer elemento de la cola 
 * @return 
 */
    public Node<T> getFront() {
        return front;
    }
/**
 * metodo para redefinir el valor del primer elemento de la cola
 * @param front 
 */
    public void setFront(Node<T> front) {
        this.front = front;
    }
/**
 * metodo para obtener el ultimo de la cola
 * @return 
 */
    public Node<T> getRear() {
        return rear;
    }
/**
 * metodo para cambiar el valor del ultimo nodo de la cola
 * @param rear 
 */
    public void setRear(Node<T> rear) {
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
		this.front = new Node<>();
		this.rear = this.front;
		this.size = 0;
	}
/**
 * metodo para agregar un elemento a la cola
 * @param element 
 */	
	public void enqueue(T element){
		this.rear.setNext(new Node<T>(element, null));
		this.rear = rear.getNext();
		this.size++;
	}
/**
 * metodo para sacar un elemento de la cola
 * @return 
 */	
	public T dequeue(){
		if(this.size == 0){
			System.out.println("Cola Vacia");
			return null;
		}
		T temp = (T) this.front.getNext().getElement();
		Node<T> nTemp = this.front.getNext();
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
		this.front = new Node<>();
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
		Node<T> tFront = this.front;
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
			Node<T> current = this.front.getNext();
			Node<T> temp = null;
			Node<T> newRear = null;
			while (current != null) {
				if (current == this.front.getNext()){
					temp = new Node<T>(current.getElement(), null);
					newRear = temp;
				} else if (current == this.rear) {
					temp = new Node<T>(current.getElement(), temp);
					this.front.setNext(temp);
				} else {
					temp = new Node<T>(current.getElement(), temp);
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
			Node<T> next = this.front.getNext();
			Node<T> afterNext = next.getNext();
			Node<T> temp = null;
			
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
