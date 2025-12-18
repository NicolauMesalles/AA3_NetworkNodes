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
			n.comprometido = false;
		}
	}

	void escanearDesde(Nodo origen) {
		// TODO: BFS desde origen - https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/
		// Reglas:
		// - si un nodo visitado es vulnerable => comprometido=true
		// - si un nodo visitado es firewall => NO se propaga a sus vecinos
		ArrayList<Nodo> visitados = new ArrayList<>();
		ArrayList<Nodo> porVisitar = new ArrayList<>();
		porVisitar.add(origen);
		//A
		while (!porVisitar.isEmpty()) {
			Nodo actual = porVisitar.remove(0);
			if (!visitados.contains(actual)) {
				visitados.add(actual);
				if (actual.vulnerable) {
					actual.comprometido = true;
				}
				for (Nodo vecino : actual.vecinos) {
					if (!visitados.contains(vecino)) {
						if (vecino.firewall) {
							continue;
						}
						porVisitar.add(vecino);
					}
				}
			}
		}
	}

	Nodo buscarPorIP(String ip) {
		// Buscar por IP (iterar nodos)
		for (Nodo n : nodos) {
			if (n.ip.equals(ip)) {
				return n;
			}
		}
		return null;
	}

	int contarVulnerablesAlcanzables(Nodo origen) {
		// Contar vulnerables alcanzables desde origen (BFS)
		// Contar vulnerables alcanzables desde origen (BFS)
		ArrayList visitados = new ArrayList<>();
		ArrayList porVisitar = new ArrayList<>();
		porVisitar.add(origen);
		int contador = 0;

		while (!porVisitar.isEmpty()) {
			Nodo actual = (Nodo) porVisitar.remove(0);
			if (!visitados.contains(actual)) {
				visitados.add(actual);
				if (actual.vulnerable) {
					contador++;
				}
				for (Nodo vecino : actual.vecinos) {
					if (!visitados.contains(vecino) && !porVisitar.contains(vecino)) {
						porVisitar.add(vecino);
					}
				}
			}
		}
		return contador;
	}

String listarVecinosDe(Nodo n) {
	// Listar vecinos (iterar vecinos)
	StringBuilder sb = new StringBuilder();
	for (Nodo vecino : n.vecinos) {
		sb.append(vecino.nombre).append(", ");
	}
	return sb.toString();
}

ArrayList nodosAislados() {
	// Obtener nodos aislados (vecinos.size()==0)
	ArrayList aislados = new ArrayList<>();
	for (Nodo n : nodos) {
		if (n.vecinos.isEmpty()) {
			aislados.add(n);
		}
	}
	return aislados;
}
}


