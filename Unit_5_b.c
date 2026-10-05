#include <stdio.h>

#define INF 99999

int main() {
    int n, graph[20][20];
    int distance[20], visited[20];
    int source;
    int i, j, count, min, next;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter weighted adjacency matrix:\n");
    printf("Use 0 for no edge.\n");

    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            scanf("%d", &graph[i][j]);

            if (graph[i][j] == 0 && i != j)
                graph[i][j] = INF;
        }
    }

    printf("Enter source vertex: ");
    scanf("%d", &source);

    for (i = 0; i < n; i++) {
        distance[i] = graph[source][i];
        visited[i] = 0;
    }

    distance[source] = 0;
    visited[source] = 1;

    for (count = 1; count < n; count++) {

        min = INF;
        next = -1;

        for (i = 0; i < n; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                next = i;
            }
        }

        if (next == -1)
            break;

        visited[next] = 1;

        for (i = 0; i < n; i++) {
            if (!visited[i] &&
                distance[next] + graph[next][i] < distance[i]) {

                distance[i] =
                    distance[next] + graph[next][i];
            }
        }
    }

    printf("\nShortest distances from vertex %d:\n", source);

    for (i = 0; i < n; i++) {
        if (distance[i] == INF)
            printf("Vertex %d : Not reachable\n", i);
        else
            printf("Vertex %d : %d\n", i, distance[i]);
    }

    return 0;
}
