package StackTracer;

public class Pila{
    private Nodo tope;
    private int i;

    public Pila() {
        tope = null;
    }

    public void push(int x, int y) {
        i++;
        Nodo nuevoNodo = new Nodo(x,y);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        i--;
        int x = tope.x;
        int y = tope.y;
        tope = tope.siguiente;
        return x+","+y;
    }

    public String isFull() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return tope.x+","+tope.y;
    }

    public boolean isEmpty() {
        if(tope == null)
        return true;
        else
        return false;
    }

    public int getSize() {
        return i;
    }


    private static class Nodo{
        int x;
        int y;
        Nodo siguiente;

        public Nodo(int x, int y) {
            this.x = x;
            this.y = y;
            siguiente = null;
        }
    }

    /*public static void main(String[] args) {
        Pila p = new Pila();
        for(int x =0; x<20; x++)
        p.push(x, 0);

        System.out.println(p.getSize()+"Tamaño");

        for(int x =0; x<20; x++){
            System.out.println(p.pop());
            System.out.println(p.getSize());
        }
    }*/
}

