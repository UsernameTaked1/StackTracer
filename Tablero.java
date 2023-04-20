package StackTracer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tablero extends JFrame{
    private JPanel p;
    private GridLayout grid;
    private JLabel labels1[][];
    public StackTracer godofredo;
    //0 - camino
    //1 - pared
    //2 - inicio E
    //4 - "camino recorrido"
    //5 - jugador
    static int l = 19;
    int coordenadas [][];
    static int celdas [] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                            1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,
                            1,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1,
                            1,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,
                            1,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,1,
                            1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,
                            1,2,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,1,
                            1,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,
                            1,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,1,
                            1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,
                            1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,1,
                            1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,
                            1,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,
                            1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,
                            1,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,
                            1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,1,
                            1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,
                            1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                        };

    public Tablero(){
        p = new JPanel();
        add(p);
        grid = new GridLayout(l, l);
        coordenadas = new int[l][l];
        labels1 = new JLabel[l][l];
        for (int y = 0; y < l; y++) {
            for (int x = 0; x < l; x++) {
                int c = y * l + x;
                coordenadas[x][y] = celdas[c];
                labels1[x][y] = new JLabel();
                labels1[x][y].setOpaque(true);
                if (coordenadas[x][y] == 2) {
                    godofredo = new StackTracer(x, y);
                }
            }
        }
        armado();
        atributos();
        escuchas();
        mostrar();
    }

    public void armado(){
        p.setLayout(grid);
        for(int y = 0; y<l; y++){
            for(int x = 0; x<l; x++){
            color();
            p.add(labels1[x][y]);
        }
    }
}

    public void atributos(){
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void mostrar(){
        setVisible(true);
    }

    public void escuchas(){
        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if(e.getKeyChar()== 'w'||e.getKeyChar()== 'W')
                godofredo.movW();
                if(e.getKeyChar()== 'a'||e.getKeyChar()== 'A')
                godofredo.movA();
                if(e.getKeyChar()== 's'||e.getKeyChar()== 'S')
                godofredo.movS();
                if(e.getKeyChar()== 'd'||e.getKeyChar()== 'D')
                godofredo.movD();
                if(e.getKeyChar()== ' ')
                godofredo.stackTracer();
                if(godofredo.finish()==true){
                    p.removeKeyListener(this);
                    JOptionPane.showMessageDialog(null, "Llegaste al final del laberinto");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        p.setFocusable(true);
    }

    public void color(){
        for(int y = 0; y<l; y++){
            for(int x = 0; x<l; x++){
            switch(coordenadas[x][y]){
                case 0: labels1[x][y].setBackground(Color.WHITE);      break;
                case 1: labels1[x][y].setBackground(Color.BLACK);      break;
                case 2: labels1[x][y].setBackground(Color.GREEN);      break;
                case 4: labels1[x][y].setBackground(Color.RED);        break;
                case 5: labels1[x][y].setBackground(new Color(235,228,211)); break;
            }
        }
    }
    }


    public class StackTracer{
        Pila p = new Pila();
        String[] xy;
        int x, y, c, r;
        int stc = 0;

        public StackTracer(int x, int y){
            this.x = x;
            this.y = y;
            c = coordenadas[x][y];
            coordenadas[x][y] = 5;
            p.push(x,y);
        }

        public void movW() {
            mov(0,-1);
        }

        public void movA() {
            mov(-1,0);
        }

        public void movS() {
            mov(0,1);
        }

        public void movD() {
            mov(1,0);
        }

        private void mov(int j, int k) {
            try {
                if (coordenadas[x + j][y + k] != 1 && coordenadas[this.x + j][this.y + k] != 4) {
                    if (stc == 0)
                        coordenadas[x][y] = c;
                    else
                        coordenadas[x][y] = 4;
                    x = x + j;
                    y = y + k;
                    c = coordenadas[x][y];
                    coordenadas[x][y] = 5;
                    p.push(x, y);
                    color();
                    r = 0;
                } else {
                    r++;
                    if (r == 4) {
                        xy = p.pop().split(",");
                        coordenadas[x][y] = 4;
                        x = Integer.parseInt(xy[0]);
                        y = Integer.parseInt(xy[1]);
                        coordenadas[x][y] = 5;
                        r = 0;
                        color();
                    }
                }
            } catch (Exception e) {
                c = 3;
            }
        }

        public void stackTracer(){
            stc = 1;
            r=0;
            while(finish()==false){
                movW();
                movD();
                movS();
                movA();
            }
            stc = 0;
        }
        public boolean finish(){
            if(c == 3)
            return true;
            else
            return false;
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog( null, "w - moverse arriba \n a - moverse a la izquierda \n s - moverse abajo \n d - moverse a la derecha \n espacio - resolver laberinto");
        Tablero t = new Tablero();
    }
}
