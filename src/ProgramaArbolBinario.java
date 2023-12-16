
import java.util.Scanner;

public class ProgramaArbolBinario {
	
	public static void main(String[] args){

	           ArbolBinario arbol = new ArbolBinario("A");
            arbol.agregarHijoIzquierdo("B", arbol.raiz);
            arbol.agregarHijoDerecho("C", arbol.raiz);
            arbol.agregarHijoIzquierdo("D", arbol.raiz.izquierdo);
            arbol.agregarHijoDerecho("E", arbol.raiz.izquierdo);
            arbol.agregarHijoIzquierdo("F", arbol.raiz.derecho);
            arbol.agregarHijoDerecho("G", arbol.raiz.derecho);
            arbol.agregarHijoIzquierdo("H", arbol.raiz.izquierdo.izquierdo);
            arbol.agregarHijoDerecho("I", arbol.raiz.izquierdo.izquierdo);
            arbol.agregarHijoIzquierdo("J", arbol.raiz.izquierdo.derecho);
            arbol.agregarHijoDerecho("K", arbol.raiz.izquierdo.derecho);
            arbol.agregarHijoIzquierdo("L", arbol.raiz.derecho.izquierdo);
            arbol.agregarHijoDerecho("M", arbol.raiz.derecho.izquierdo);

            Scanner scanner = new Scanner(System.in);

            int opcion;
            do {
                System.out.println("---Menú---");
                System.out.println("1. -Imprimir árbol de manera horizontal ");
                System.out.println("2. -Buscar un Nodo ");
                System.out.println("3. -Recorrer el árbol en preorden ");
                System.out.println("4. -Recorrer el arbol en inorden ");
                System.out.println("5. -Recorrer el arbol en postorden ");
                System.out.println("6. -Eliminar un nodo por su valor ");
                System.out.println("7. -Salir ");
                System.out.println("Ingrese el número de la opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    
                    case 1:
                        System.out.println("Impresion del Arbol Horizontal.");
                        arbol.imprimirHorizontal();   
                        System.out.println("-------------------------------------------------");
                        break;
                        
                        
                    case 2:                        
        
                        System.out.print("Ingrese el valor a buscar en el árbol: ");
                        String valorABuscar = scanner.next();


                        ArbolBinario.ResultadoBusqueda resultado = arbol.buscarNodo(valorABuscar);
                        
                        if (resultado != null) {
                            System.out.println("Nodo encontrado: " + resultado.nodoEncontrado.name);
                            System.out.println("Posición (Izquierda/Derecha): " + resultado.posicion);
                            System.out.println("-------------------------------------------------");
                        } else {
                            System.out.println("Nodo no encontrado.");
                            System.out.println("-------------------------------------------------");}
                        break;
                        
                    case 3:

                        System.out.println("Árbol en preorden:");
                        arbol.recorrerPreorden();   
                        System.out.println("-------------------------------------------------");
                        break;

                    case 4:
 
                        System.out.println("Árbol en inorden:");
                        arbol.recorrerInorden();
                        System.out.println("-------------------------------------------------");
                        break;
                        
                        
                    case 5:

                        System.out.println("Árbol en postOrden:");
                        arbol.recorrerPostorden();
                        System.out.println("-------------------------------------------------");
                        break;    
                        
                        
                    case 6:

                        System.out.print("Ingrese el valor que desea eliminar: ");
                        scanner.nextLine(); // Limpia el búfer
                        String valorAEliminar = scanner.nextLine();


                        arbol.eliminarNodo(valorAEliminar);

                        System.out.println("Árbol después de la eliminación:");
                        arbol.recorrerInorden();
                        System.out.println("-------------------------------------------------");
                        break;
                               
                    case 7:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                        
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }

            } while (opcion != 7);

            scanner.close();		
	}
        
}
