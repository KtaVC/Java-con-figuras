
package proyectojava;

import java.util.Scanner;
import java.util.Vector;
import java.util.Scanner;
import java.util.Vector;
 
class Node
{
    int             nombre; 
    Vector<Integer> antecesor; 
    Vector<Integer> vecino; 
    Vector<Integer> fin; 
    Vector<Integer> inicio; 
    int             pNode; 
    int             eje; 
                           
 
    public Node(int id)
    {
        nombre = id;
        fin = new Vector<Integer>();
        inicio = new Vector<Integer>();
        pNode = -1;
        eje = -1;
    }
}
 
class Edge
{
    int nombre;    
    int inicio;  
    int fin;    
    int direct;         
    int capacidad; 
    int flujo;    
 
    public Edge(int id)
    {
        nombre = id;
        inicio = -1;
        fin = -1;
        direct = 0; 
        capacidad = 0;
        flujo = 0;
    }
 
    public String toString()
    {
        return nombre + ": s=" + inicio + " e=" + fin + " d=" + direct;
    }
}
 
public class RutaMasLarga
{
    int    n;                      // cantidad de nodos
    int    objetivo;                 // nodo al que se dirige
    int    minLongitud;              // el minimo peso
    Node[] v;                      
    Edge[] e;                     
    int[]  ruta;                   
    int    longitud       = 0;      
    int    distancia     = 0;       
    int[]  mejorRuta;              
    int    mejorLongitud   = 0;       
    int    mejorDistancia = -1000000; 
    int[]  visited;                
                                   
 
    public RutaMasLarga()
    {
        Scanner sc = new Scanner(System.in);
        n=8;
        System.out.println("La cantidad de vertices es: "+ n);
        int m=9;
        System.out.println("La cantidad de aristas son: "+ m);
        v = new Node[n];
        e = new Edge[m];
        System.out.println(n + " vertices " + m + " aristas.");
        for (int i = 0; i < n; i++)
            v[i] = new Node(i);
        int i = 0;
        
        while (i < e.length)
        {
            Edge edge = new Edge(i);
            int sVal = sc.nextInt();
            edge.inicio = sVal;
            int eVal = sc.nextInt();
            edge.fin = eVal;
            edge.capacidad = sc.nextInt();
            System.out.println(" bordes: " + edge.inicio + " - " + edge.fin
                    + " : " + edge.capacidad);
            edge.flujo = 0;
            e[i] = edge;
            v[sVal].inicio.add(i);
            v[eVal].fin.add(i);
            i++;
            if (i == m)
                break;
        }
        visited = new int[v.length];
        ruta = new int[v.length];
        mejorRuta = new int[v.length];
        sc.close();
    }
 
    
    public boolean EncuentraRutaMasLarga(int principio, int fin, int minLen)
    {
       
        objetivo = fin;
        mejorDistancia = -100000000;
        minLongitud = minLen;
        dfsLongestPath(principio);
        if (mejorDistancia == -100000000)
            return false;
        else
            return true;
    }
 
    private void dfsLongestPath(int actual)
    {
        visited[actual] = 1;
        ruta[longitud++] = actual;
        if (actual == objetivo && longitud >= minLongitud)
        {
            if (distancia > mejorDistancia)
            {
                for (int i = 0; i < longitud; i++)
                    mejorRuta[i] = ruta[i];
                mejorLongitud = longitud;
                mejorDistancia = distancia;
            }
        }
        else
        {
            Vector<Integer> inicio = v[actual].inicio;
            for (int i = 0; i < inicio.size(); i++)
            {
                Integer edge_obj = (Integer) inicio.elementAt(i);
                int edge = edge_obj.intValue();
                if (visited[e[edge].fin] == 0)
                {
                    distancia += e[edge].capacidad;
                    dfsLongestPath(e[edge].fin);
                    distancia -= e[edge].capacidad;
                }
            }
        }
        visited[actual] = 0;
        longitud--;
    }
 
    public String toString()
    {
        String output = "v" + mejorRuta[0];
        for (int i = 1; i < mejorLongitud; i++)
            output = output + " -> v" + mejorRuta[i];
        return output;
    }
 
    public static void main(String arg[])
    {
        RutaMasLarga lp = new RutaMasLarga();
        
        if (lp.EncuentraRutaMasLarga(0, lp.n - 1, 1))
            System.out.println("La ruta más larga es " + lp
                    + " y la distancia es: " + lp.mejorDistancia);
        else
            System.out.println("No path from v0 to v" + (lp.n - 1));
        
        if (lp.EncuentraRutaMasLarga(3, 5, 1))
            System.out.println("La ruta más larga es " + lp
                    + " y la distancia es: " + lp.mejorDistancia);
        else
            System.out.println("No path from v3 to v5");
       
        if (lp.EncuentraRutaMasLarga(lp.n - 1, 3, 1))
            System.out.println("La ruta más larga es " + lp
                    + " y la distancia es:" + lp.mejorDistancia);
        else
            System.out.println("No hay ruta de v5 a v3");
    }
}