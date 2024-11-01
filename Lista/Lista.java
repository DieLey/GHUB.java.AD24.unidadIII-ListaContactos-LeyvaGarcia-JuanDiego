package lista;

public class Lista <T>{
    private Nodo<T> cabeza;
    private int tamanio;

    public Lista() {
        cabeza = null;
        tamanio = 0;

    }

    public int getTamanio() {
        return tamanio;
    }
    /**
     * Consulta si la lista es vacia
     * @return true cuando es vacia, false cuando no
     */
    public boolean esVacia(){
        if(cabeza==null)
           return true;
        else
           return false;
    }

    /**
     * 
     * @param valor
     */
   
    public void agregar(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        //fija el valor en el nuevo nodo
        nuevo.setValor(valor);
        if(this.esVacia()){
            cabeza = nuevo;
        }else{
            //agregar al final de la lista
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente()!=null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        tamanio++;
    }

    public void insertar(T valor, int pos) throws PosicionIlegalException{
        if(pos>=0 && pos<=tamanio){
            Nodo<T> nuevo = new Nodo<T>();
            nuevo.setValor(valor);
            //el nodo se inserta al principio de la lista
            if(pos==0){
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;

            }else{
                //el nodo a insertar va al final de la lista
                if(pos == tamanio){
                    Nodo<T> aux = cabeza;
                    while (aux.getSiguiente()!=null){
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo);

                }
                //insertar en medio de la lista
                else{
                    Nodo<T> aux = cabeza;
                    for(int i=0;i<=pos-2;i++){
                        aux = aux.getSiguiente();

                    }
                    Nodo<T> siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);


                }
            }
            tamanio++;

        }else{
            throw new PosicionIlegalException();
        }
    }

    /**
     * 
     * @param pos
     * @return el valor del elemento que se encuentra en pos si no retorna una excepcion
     * @throws PosicionIlegalException
     */

    public T getValor(int pos) throws PosicionIlegalException{
        if(pos>=0 && pos<tamanio){
            T valor;
            if(pos == 0){
                valor = cabeza.getValor();
                return valor;
            }else{
                Nodo<T> aux = cabeza;
                for(int i=0;i<=pos-1;i++){
                    aux = aux.getSiguiente();
                }
                valor = aux.getValor();
            }
            return valor;

        }else{
            throw new PosicionIlegalException();
        }

    }

    public void remover(int pos) throws PosicionIlegalException{
        if(pos>0 && pos<tamanio){
            if (pos==0){
                //el Nodo a eliminar esta al principio de la lista
                cabeza = cabeza.getSiguiente();
                tamanio--;
            }
            Nodo<T> aux = cabeza;
            for(int i=0;i<=pos-2;i++){
                aux = aux.getSiguiente();
            }
            Nodo<T> prox = aux.getSiguiente();
            aux.setSiguiente(prox.getSiguiente());
            tamanio--;


        }
        else{
            throw new PosicionIlegalException();
        }

    }
    public void limpiar(){
        cabeza=null;
        tamanio=0;
    }


    

    
}
