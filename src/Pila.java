/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Bolaños
 */
public class Pila {
    char [] pila;
    int tope;
    int tam;
    public Pila(int tamaño){
        tope=-1;
        pila= new char [tamaño];
        tam=tamaño;
    }
    public boolean vacia(){
        return tope==-1;
    }
    public boolean llena(){
        return tope==tam-1;
    }
    public void push(char dato){
        if(!llena()){
            tope++;
            pila[tope]=dato;
        }else{
            System.out.println("desbordamiento");
        }
    }
    public void pop(){
        if(!vacia()){
            tope--;
        }else{
            System.out.println("subdesbordamiento");
        }
    }
    public char peek(){
        char vt=' ';
        if(vacia()){
            return vt;
        }else{
            vt=pila[tope];
        }
        return pila[tope];
    }
}
