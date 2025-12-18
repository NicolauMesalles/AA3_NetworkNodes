import java.util.ArrayList;

public class Red {
    private ArrayList<Nodo> nodos;

    public Red() {
        nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        if (!nodos.contains(nodo)) {
            nodos.add(nodo);
        }
    }

    public void conectar(Nodo a, Nodo b) {
        a.connectar(b);
        b.connectar(a);
    }

    public void mostrar() {
        System.out.println("=== GRAFO ===");
        for (Nodo n : nodos) {
            System.out.print(n.getNombre() + " --> " + n.getVecinos());
        }
    }

     void resetCompromisos() {
            // TODO: poner comprometido=false a todos los nodos
            for (Nodo n : nodos) {
                n.setComprometido(false);
            }
    }

    void escanearDesde(Nodo origen) {
            // TODO: BFS desde origen - https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/
            // Reglas:
            // - si un nodo visitado es vulnerable => comprometido=true
            // - si un nodo visitado es firewall => NO se propaga a sus vecinos
    }

    Nodo buscarPorIP(String ip) {
            // Buscar por IP (iterar nodos)
            return null;
    }
  
    int contarVulnerablesAlcanzables(Nodo origen) {
            // Contar vulnerables alcanzables desde origen (BFS)
            return 0;
    }

    String listarVecinosDe(Nodo n) {
            // Listar vecinos (iterar vecinos)
            return "";
    }

    ArrayList<Nodo> nodosAislados() {
            // Obtener nodos aislados (vecinos.size()==0)
            return new ArrayList<>();
    }
}
