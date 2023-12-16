public class ArbolBinario {
    Node raiz;

    
    
    public ArbolBinario(String dato) {
        this.raiz = new Node();
        this.raiz.name = dato;
        this.raiz.izquierdo = null;
        this.raiz.derecho = null;
    }
    public void agregarHijoIzquierdo(String dato, Node arbol) {
        Node hijo = new Node();
        hijo.name = dato;
        hijo.izquierdo = null;
        hijo.derecho = null;
        arbol.izquierdo = hijo;
        hijo = null;
    }
    public void agregarHijoDerecho(String dato, Node arbol) {
        Node hijo = new Node();
        hijo.name = dato;
        hijo.izquierdo = null;
        hijo.derecho = null;
        arbol.derecho = hijo;
        hijo = null;
    }
    public void imprimirHorizontal() {
        imprimirHorizontalUtil(raiz, 0);
    }

    private void imprimirHorizontalUtil(Node nodo, int nivel) {
        if (nodo != null) {
            imprimirHorizontalUtil(nodo.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.name);

            imprimirHorizontalUtil(nodo.izquierdo, nivel + 1);
        }
    }
    public static class ResultadoBusqueda {
        Node nodoEncontrado;
        String posicion;

        public ResultadoBusqueda(Node nodoEncontrado, String posicion) {
            this.nodoEncontrado = nodoEncontrado;
            this.posicion = posicion;
        }
    }
    public ResultadoBusqueda buscarNodo(String valor) {
        return buscarNodoRecursivo(raiz, valor, "");
    }
    private ResultadoBusqueda buscarNodoRecursivo(Node nodo, String valor, String posicion) {
        if (nodo == null) {
            return null;
        }

        if (nodo.name.equals(valor)) {
            return new ResultadoBusqueda(nodo, posicion);
        }
        ResultadoBusqueda resultadoIzquierdo = buscarNodoRecursivo(nodo.izquierdo, valor, posicion + "I");
        if (resultadoIzquierdo != null) {
            return resultadoIzquierdo;
        }
        ResultadoBusqueda resultadoDerecho = buscarNodoRecursivo(nodo.derecho, valor, posicion + "D");
        return resultadoDerecho;
    }
    public void recorrerPreorden() {
        recorrerPreordenUtil(raiz);
    }

    private void recorrerPreordenUtil(Node nodo) {
        if (nodo != null) {
            System.out.println(nodo.name + " "); 
            recorrerPreordenUtil(nodo.izquierdo);
            recorrerPreordenUtil(nodo.derecho);   
        }
    }
    public void recorrerInorden() {
        recorrerInordenUtil(raiz);
    }

    private void recorrerInordenUtil(Node nodo) {
        if (nodo != null) {
            recorrerInordenUtil(nodo.izquierdo); 
            System.out.println(nodo.name + " ");  
            recorrerInordenUtil(nodo.derecho);    
        }
    }
    public void recorrerPostorden() {
        recorrerPostordenUtil(raiz);
    }

    private void recorrerPostordenUtil(Node nodo) {
        if (nodo != null) {
            recorrerPostordenUtil(nodo.izquierdo); 
            recorrerPostordenUtil(nodo.derecho); 
            System.out.println(nodo.name + " ");   
        }
    }

    // Método para eliminar un nodo por su valor
    public void eliminarNodo(String valor) {
        raiz = eliminarNodoRecursivo(raiz, valor);
    }

    private Node eliminarNodoRecursivo(Node nodo, String valor) {
        if (nodo == null) {
            return null;
        }

        if (valor.compareTo(nodo.name) < 0) {
            nodo.izquierdo = eliminarNodoRecursivo(nodo.izquierdo, valor);
        }

        else if (valor.compareTo(nodo.name) > 0) {
            nodo.derecho = eliminarNodoRecursivo(nodo.derecho, valor);
        }
 
        else {

            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
  
            else if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            else {
 
                Node sucesor = encontrarNodoSucesor(nodo.derecho);
 
                nodo.name = sucesor.name;
        
                nodo.derecho = eliminarNodoRecursivo(nodo.derecho, sucesor.name);
            }
        }

        return nodo; 
    }
    private Node encontrarNodoSucesor(Node nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }
}
