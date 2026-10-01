#include <stdio.h>

int graph[20][20], visited[20];
int n;

void DFS(int v) {
    int i;
    visited[v] = 1;
    printf("%d ", v);

    for (i = 0; i < n; i++) {
        if (graph[v][i] == 1 && !visited[i])
            DFS(i);
    }
}

void BFS(int start) {
    int queue[20], front = 0, rear = 0;
    int visitedBFS[20] = {0};
    int i, v;

    queue[rear++] = start;
    visitedBFS[start] = 1;

    while (front < rear) {
        v = queue[front++];
        printf("%d ", v);

        for (i = 0; i < n; i++) {
            if (graph[v][i] == 1 && !visitedBFS[i]) {
                queue[rear++] = i;
                visitedBFS[i] = 1;
            }
        }
    }
}

int main() {
    int i, j;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter adjacency matrix:\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
            scanf("%d", &graph[i][j]);

    printf("DFS: ");
    for (i = 0; i < n; i++)
        visited[i] = 0;

    DFS(0);

    printf("\nBFS: ");
    BFS(0);

    for (i = 0; i < n; i++) {
        if (!visited[i])
            break;
    }

    printf("\n");

    if (i == n)
        printf("Graph is connected");
    else
        printf("Graph is not connected");

    return 0;
}
