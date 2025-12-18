
import java.util.ArrayList;

public class Nodo {
    String nombre;
    String ip;
    boolean firewall;
    boolean vulnerable;
    boolean comprometido;
    ArrayList<Nodo> vecinos;

    public Nodo(String nombre, String ip, boolean firewall, boolean vulnerable) {
        this.nombre = nombre;
        this.ip = ip;
        this.firewall = firewall;
        this.vulnerable = vulnerable;
        this.vecinos = new ArrayList<>();
    }

    void connectar(Nodo otro) {
       if (!vecinos.contains(otro))
           vecinos.add(otro); 
    }

    public String getNombre() {
        return nombre;
    }

    
    
    public String getVecinos() {
        String tmp = "";
        for (Nodo v : vecinos) {
            tmp += "[" + v.getNombre() + "] - ";
        }
        return tmp;
    }


     @Override
    public String toString() {
        // TODO: devolver algo tipo:
        // "WebServer (172.16.0.10) [VULN] [PWN]" etc.
        return nombre + " (" + ip + ") [" + (vulnerable ? "VULN" : "NO VULN") + "] [" + (comprometido ? "PWN" : "NO PWN") + "]";
    }
}