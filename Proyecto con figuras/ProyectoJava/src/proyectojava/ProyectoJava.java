
package proyectojava;

import javax.swing.JFrame;


public class ProyectoJava {
    

    
    public static void main(String[] args) {
        
        
        /************* Para leer el archivo ***************/
        LeeArchivo mi = new LeeArchivo();
        mi.leer();
        
        /************* ventana del grafo ***************/
        JFrame ventana = new JFrame("Grafo");
        ventana.add(new Lienzo());
        ventana.setSize(600,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

}
