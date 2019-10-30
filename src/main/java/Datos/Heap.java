package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samue
 */
public class Heap {
    public class Nodo {

        /* Declaraciones de variables */
        private Personas persona;

        private Nodo padre;
        private Nodo hojaIzquierda;
        private Nodo hojaDerecha;

        /* Constructor */
        public Nodo(Personas valor) {
            this.persona = valor;
        }

        /* Setters y Getters */
        public void setValor(Personas valor) {
            this.persona = valor;
        }

        public Personas getValor() {
            return persona;
        }

        public Nodo getPadre() {
            return padre;
        }

        public void setPadre(Nodo padre) {
            this.padre = padre;
        }

        public Nodo getHojaIzquierda() {
            return hojaIzquierda;
        }

        public void setHojaIzquierda(Nodo hojaIzquierda) {
            this.hojaIzquierda = hojaIzquierda;
        }

        public Nodo getHojaDerecha() {
            return hojaDerecha;
        }

        public void setHojaDerecha(Nodo hojaDerecha) {
            this.hojaDerecha = hojaDerecha;
        }
    }
    /* Atributos */
    private Nodo raiz;
    private int size;
    
    private int Nespecial;
    private int Noro;
    private int Nplatino;
    private int Neconomico;

    /* Contructories */
    
    public Heap() {
    }

    public Heap(Personas valor) {
        this.raiz = new Nodo(valor);
    }

    public Heap(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getNespecial() {
        return Nespecial;
    }

    public int getNoro() {
        return Noro;
    }

    public int getNplatino() {
        return Nplatino;
    }

    public int getNeconomico() {
        return Neconomico;
    }

    public int getSize() {
        return size;
    }

    /* Setters y Getters */
    public void setSize(int size) {
        this.size = size;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
      private void addNodo( Nodo nodo, Nodo raiz ) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            /* 
             * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato. 
             * ==== EDITO =====
             * Muchas gracias a @Espectro por la corrección de esta línea
             */
            this.setRaiz(nodo);
        }
        else {
            /* 4.- En caso negativo preguntamos: X < Nodo */
            if ( nodo.getValor().getClase()<= raiz.getValor().getClase()) {
                /* 
                 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar 
                 */
                if (raiz.getHojaIzquierda() == null) {
                    raiz.setHojaIzquierda(nodo);
                }
                else {
                    addNodo( nodo , raiz.getHojaIzquierda() );
                }
            }
            else {
                /* 
                 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.
                 */
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                }
                else {
                    addNodo( nodo, raiz.getHojaDerecha() );
                }
            }
        }
    }

    public void addNodo( Personas nodo ) {
        this.addNodo( new Nodo(nodo) , this.raiz );
        if (nodo.getClase()==1){
            this.Nespecial=this.Nespecial+1;
        }
        if (nodo.getClase()==2){
            this.Noro=this.Noro+1;
        }
        if (nodo.getClase()==3){
            this.Nplatino=this.Nplatino+1;
        }
        if (nodo.getClase()==4){
            this.Neconomico=this.Neconomico+1;
        }
        this.size = this.size+1;
    }
    
    public boolean delete(int value){
        Nodo current = this.raiz;
        Nodo parent = this.raiz;
        boolean isLeftChild = false;
                while(current.getValor().getClase() != value){
            parent = current;
            if(value < current.getValor().getClase()){
                // Move to the left if searched value is less
                current = current.hojaIzquierda;
                isLeftChild = true;
            }
            else{
                // Move to the right if searched value is >=
                current = current.hojaDerecha;
                isLeftChild = false;
            }
            if(current == null){
                return false;
            }
        }
        // if reached here means node to be deleted is found
        
        // Leaf node deletion case
        if(current.hojaIzquierda == null && current.hojaDerecha == null){
            System.out.println("Leaf node deletion case");
            // if root node is to be deleted
            if(current == this.raiz){
                raiz = null;
            }
            // left child
            else if(isLeftChild){
                parent.hojaIzquierda = null;
            }
            // right child
            else{
                parent.hojaDerecha = null;
            }
        }
        // Node to be deleted has one child case
        // Node to be deleted has right child
        else if(current.hojaIzquierda == null){
            System.out.println("One right child deletion case");
            // if root node is to be deleted
            if(current == raiz){
                raiz = current.hojaDerecha;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = current.hojaDerecha;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = current.hojaDerecha;
            }
        }
        // Node to be deleted has left child
        else if(current.hojaDerecha == null){
            System.out.println("One left child deletion case");
            if(current == raiz){
                raiz = current.hojaIzquierda;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = current.hojaIzquierda;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = current.hojaIzquierda;
            }
        }
        // Node to be deleted has two children case
        else{
            System.out.println("Two children deletion case");
            // find in-order successor of the node to be deleted
            Nodo successor = findSuccessor(current);
            if(current == raiz){
                raiz = successor;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = successor;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = successor;
            }
            successor.hojaIzquierda = current.hojaIzquierda;
        }
        this.setSize(this.size-1);
        return true;
    }
    private Nodo findSuccessor(Nodo node){
        Nodo successor = node;
        Nodo successorParent = node;
        // Start from the right child of the node to be deleted
        Nodo current = node.hojaDerecha;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.hojaIzquierda;
        }
        // When In-order successor is in the left subtree 
        // perform two ref changes here as we have 
        // access to successorParent
        if(successor != node.hojaDerecha){
            successorParent.hojaIzquierda = successor.hojaDerecha;
            // applicable only when successor is not right child
            // so doing here
            successor.hojaDerecha = node.hojaDerecha;
        }
        return successor;
    }
    
    public Personas Bpersonas (int value){

       Personas per = new Personas();
       per.setNombre("No encontrado");
       per.setClase(5);

        Nodo current = this.raiz;
        Nodo parent = this.raiz;
        boolean isLeftChild = false;
        
        if (this.size==0){
            return per;
        }
        while(current.getValor().getClase() != value){
            parent = current;
            if(value < current.getValor().getClase()){
                // Move to the left if searched value is less
                current = current.hojaIzquierda;
                isLeftChild = true;
            }
            else{
                // Move to the right if searched value is >=
                current = current.hojaDerecha;
                isLeftChild = false;
            }
            if(current == null){
                return per;
            }
        }
        if(current.hojaIzquierda == null && current.hojaDerecha == null){
            return current.getValor();
        }
        // Node to be deleted has one child case
        // Node to be deleted has right child
        else if(current.hojaIzquierda == null){
            return current.getValor();
        }
        // Node to be deleted has left child
        else if(current.hojaDerecha == null){
            return current.getValor();
        }
        // Node to be deleted has two children case
        else{
            return current.getValor();
        }
    }
    
    public int Cantidad (int value){
       int contador =0; 
       if (this.size==0){
            return 0;
        }
       Heap copia = this;
       while (copia.delete(value)==true){
           contador++;  
       }
       return contador;
    }
    
    public boolean existe(int value){
        Heap copia = this;
        Nodo current = copia.raiz;
        Nodo parent = copia.raiz;
        boolean isLeftChild = false;
        while(current.getValor().getClase() != value){
            parent = current;
            if(value < current.getValor().getClase()){
                // Move to the left if searched value is less
                current = current.hojaIzquierda;
                isLeftChild = true;
            }
            else{
                // Move to the right if searched value is >=
                current = current.hojaDerecha;
                isLeftChild = false;
            }
            if(current == null){
                return false;
            }
        }
        // if reached here means node to be deleted is found
        
        // Leaf node deletion case
        if(current.hojaIzquierda == null && current.hojaDerecha == null){
            System.out.println("Leaf node deletion case");
            // if root node is to be deleted
            if(current == copia.raiz){
                raiz = null;
            }
            // left child
            else if(isLeftChild){
                parent.hojaIzquierda = null;
            }
            // right child
            else{
                parent.hojaDerecha = null;
            }
        }
        // Node to be deleted has one child case
        // Node to be deleted has right child
        else if(current.hojaIzquierda == null){
            System.out.println("One right child deletion case");
            // if root node is to be deleted
            if(current == raiz){
                raiz = current.hojaDerecha;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = current.hojaDerecha;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = current.hojaDerecha;
            }
        }
        // Node to be deleted has left child
        else if(current.hojaDerecha == null){
            System.out.println("One left child deletion case");
            if(current == raiz){
                raiz = current.hojaIzquierda;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = current.hojaIzquierda;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = current.hojaIzquierda;
            }
        }
        // Node to be deleted has two children case
        else{
            System.out.println("Two children deletion case");
            // find in-order successor of the node to be deleted
            Nodo successor = findSuccessor(current);
            if(current == raiz){
                raiz = successor;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = successor;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = successor;
            }
            successor.hojaIzquierda = current.hojaIzquierda;
        }
        return true;
    }

}
