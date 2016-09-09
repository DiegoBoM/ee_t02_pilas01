/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Bolaños
 */
import java.io.*;
import java.util.*;

public class Ee_t02_pilas01 {
   String palabra;
   String nombre;//variable que guarda el nombre del archivo a leer
   public Ee_t02_pilas01(){
       
   }
    public void leer(String nombre) {//se introduce la direccion del archivo que se va abrir
        ArrayList<String> archivo = new ArrayList<String>(); //creacion del arraylist
        int conta=-1;//declaracion del contador
        String s;
        try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream(nombre);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                StringTokenizer st = new StringTokenizer (strLinea);
                archivo.add(strLinea);//se agraga la linea del archivo al arraylist
                conta++;//el contador se incrementa
            }
            // Cerramos el archivo
            entrada.close();
        }catch (Exception e){ //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        //se imprime el contenido del archivo
        Iterator<String> it = archivo.iterator();
        System.out.println("ENTRADA:");
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //se imprime el archivo en forma descendente
        System.out.println("");
        System.out.println("SALIDA:");
        for(int x=1;x<conta+1;x++){
            s=archivo.get(x);
            if(cierto(s)){//se hace el llamado al metodo que determina si es correcta o es erronea
                System.out.println("SI");
            }else{
                System.out.println("NO");
            }
     }
            
   }
   public boolean cierto(String palabra){
       String a=palabra;
       int cont=0;
       int max=palabra.length();//tamaño de la pila
       Pila p= new Pila(max);//se crea la pila
       while(cont<max){//empieza con las comparaciones 
          if(a.charAt(cont)=='('){
                    p.push(a.charAt(cont));//si encuentra un agrupador que abre lo agrega a la pila
          }
          if(a.charAt(cont)=='['){
                    p.push(a.charAt(cont));//si encuentra un agrupador que abre lo agrega a la pila
          }
          if(a.charAt(cont)=='{'){
                    p.push(a.charAt(cont));//si encuentra un agrupador que abre lo agrega a la pila
          }
          if(a.charAt(cont)==')'){//si encuentra un agrupador que cierre saca de la pila
                     if(!p.vacia() && p.peek()=='('){//si la pila esta vacia o si el elemento de la pila no concuerda con el caraacter retorna false en otro caso saca de la pila
                               p.pop();
                            }else{
                                return false;
                     }
          }
          if(a.charAt(cont)==']'){
                     if(!p.vacia() && p.peek()=='['){//si la pila esta vacia o si el elemento de la pila no concuerda con el caraacter retorna false en otro caso saca de la pila
                               p.pop();
                            }else{
                                return false;
                     }
          }
          if(a.charAt(cont)=='}'){
                     if(!p.vacia() && p.peek()=='{'){//si la pila esta vacia o si el elemento de la pila no concuerda con el caraacter retorna false en otro caso saca de la pila
                               p.pop();
                              }else{
                                return false;
                     }
          }
          cont++;
       }
       return true;//si no encontro errores devuelve un true que significa que la expresion esta bien
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ee_t02_pilas01 e = new Ee_t02_pilas01();
        e.leer("diego.txt");//la direccion del archivo va en los parametros
        // TODO code application logic here
    }
}
