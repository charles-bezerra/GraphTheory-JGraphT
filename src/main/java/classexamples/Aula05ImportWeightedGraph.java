// Teoria dos Grafos - UFCG

package classexamples;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.ImportUtil;
import util.VertexEdgeUtil;

public class Aula05ImportWeightedGraph {
	// Importa Grafo Direcionado Ponderado no formato CSV

	public static void main(String[] args) {
		// Import CSV

		Graph<DefaultVertex, DefaultWeightedEdge> graph = 
				new DefaultDirectedWeightedGraph<DefaultVertex, DefaultWeightedEdge>(
						VertexEdgeUtil.createDefaultVertexSupplier(),
						SupplierUtil.createDefaultWeightedEdgeSupplier());
		ImportUtil.importWeightedGraphCSV(
				graph, 
				"./src/main/java/graphs/csv-weighted-example.txt", 
				CSVFormat.MATRIX, 
				false, 
				true, // EDGE_WEIGHTS
				true); // MATRIX_FORMAT_NODEID

		DefaultVertex a = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "a");
		DefaultVertex b = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "b");
		DefaultVertex c = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "c");
		DefaultVertex d = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "d");
		DefaultVertex e = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "e");
		System.out.println("Grafo importado do arquivo CSV: ");
		System.out.println("Arestas: " + graph.edgeSet());
		System.out.println("Vertices: " + graph.vertexSet());
		System.out.println("Peso do arco (a,b): " + graph.getEdgeWeight(graph.getEdge(a, b)));
		System.out.println("Peso do arco (a,d): " + graph.getEdgeWeight(graph.getEdge(a, d)));
		System.out.println("Peso do arco (b,a): " + graph.getEdgeWeight(graph.getEdge(b, a)));
		System.out.println("Peso do arco (c,d): " + graph.getEdgeWeight(graph.getEdge(c, d)));
		System.out.println("Peso do arco (d,b): " + graph.getEdgeWeight(graph.getEdge(d, b)));
		System.out.println("Peso do arco (e,a): " + graph.getEdgeWeight(graph.getEdge(e, a)));
	}
}