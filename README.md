# Graph Algorithms Project

This project implements a generic graph data structure with adjacency lists in Java. It includes the `Grafo` interface and the `GrafoListaAdyacencia` class that implements the interface.

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven build tool

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/your-username/graph-algorithms.git

2. Navigate to the project directory:

   ```shell
   cd graph-algorithms

3. Compile and run the tests:
   
   ```shell
   mvn test

## Usage

To use the graph data structure and algorithms in your own project, follow these steps:

1. Add the following Maven dependency to your project's pom.xml file:
   
  ``shell
  <dependency>
    <groupId>com.example</groupId>
    <artifactId>graph-algorithms</artifactId>
    <version>1.0-SNAPSHOT</version>
  </dependency>
  
2. Import the necessary classes in your Java code:
   
  ``shell
  import com.example.graph.Grafo;
  import com.example.graph.GrafoListaAdyacencia;
  
3. Create an instance of the Grafo interface using the GrafoListaAdyacencia implementation:
   
  ``shell
  Grafo<String> grafo = new GrafoListaAdyacencia<>();

4. Use the available methods to add vertices, add edges, and perform graph traversal algorithms such as BFS and DFS.
  
## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please create a new issue or submit a pull request.
  
## License 
  
This project is licensed under the MIT License. See the LICENSE file for details.


  

