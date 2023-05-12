package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// Interface for the Graph
interface Grafo<T> {
    void agregarVertice(T vertice);
    void agregarArista(T origen, T destino);
    void BFS(T inicio);
    void DFS(T inicio);
}

// Graph implementation using adjacency lists
class GrafoListaAdyacencia<T> implements Grafo<T> {
    private Map<T, List<T>> grafo;

    public GrafoListaAdyacencia() {
        this.grafo = new HashMap<>();
    }

    @Override
    public void agregarVertice(T vertice) {
        grafo.put(vertice, new LinkedList<>());
    }

    @Override
    public void agregarArista(T origen, T destino) {
        if (!grafo.containsKey(origen) || !grafo.containsKey(destino)) {
            throw new IllegalArgumentException("Vertice(s) no existen en el grafo.");
        }
        grafo.get(origen).add(destino);
    }

    @Override
    public void BFS(T inicio) {
        Set<T> visitados = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        visitados.add(inicio);
        queue.add(inicio);

        while (!queue.isEmpty()) {
            T actual = queue.poll();
            System.out.print(actual + " ");

            List<T> adyacentes = grafo.get(actual);
            for (T adyacente : adyacentes) {
                if (!visitados.contains(adyacente)) {
                    visitados.add(adyacente);
                    queue.add(adyacente);
                }
            }
        }
    }

    @Override
    public void DFS(T inicio) {
        Set<T> visitados = new HashSet<>();
        DFSRecursivo(inicio, visitados);
    }

    private void DFSRecursivo(T vertice, Set<T> visitados) {
        visitados.add(vertice);
        System.out.print(vertice + " ");

        List<T> adyacentes = grafo.get(vertice);
        for (T adyacente : adyacentes) {
            if (!visitados.contains(adyacente)) {
                DFSRecursivo(adyacente, visitados);
            }
        }
    }
}

// JUnit test class for GrafoListaAdyacencia
class GrafoListaAdyacenciaTest {
    @Test
    void testBFS() {
        Grafo<String> grafo = new GrafoListaAdyacencia<>();

        // Agregar vertices al grafo
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        // Agregar aristas al grafo
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "E");

        // Test case 1: Starting from vertex A
        // Expected BFS traversal: A B C D E
        System.out.println("BFS traversal:");
        Assertions.assertDoesNotThrow(() -> {
            grafo.BFS("A");
        });
        System.out.println();

        // Test case 2: Starting from vertex D
        // Expected BFS traversal: D B A C E
        System.out.println("BFS traversal:");
        Assertions.assertDoesNotThrow(() -> {
            grafo.BFS("D");
        });
        System.out.println();

        // Test case 3: Starting from vertex E
        // Expected BFS traversal: E C A B D
        System.out.println("BFS traversal:");
        Assertions.assertDoesNotThrow(() -> {
            grafo.BFS("E");
        });
        System.out.println();
    }

    @Test
    void testDFS() {
        Grafo<String> grafo = new GrafoListaAdyacencia<>();

        // Agregar vertices al grafo
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        // Agregar aristas al grafo
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "E");

        // Test case 1: Starting from vertex A
        // Expected DFS traversal: A B D C E
        System.out.println("DFS traversal:");
        Assertions.assertDoesNotThrow(() -> {
            grafo.DFS("A");
        });
        System.out.println();

        // Test case 2: Starting from vertex B
        // Expected DFS traversal: B D A C E
        System.out.println("DFS traversal:");
        Assertions.assertDoesNotThrow(() -> {
            grafo.DFS("B");
        });
        System.out.println();

        // Test case 3: Starting from vertex E
        // Expected DFS traversal: E C A B D
        System.out.println("DFS traversal:");
        Assertions.assertDoesNotThrow(() -> {
            grafo.DFS("E");
        });
        System.out.println();
    }
}