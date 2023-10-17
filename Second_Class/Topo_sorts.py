from collections import defaultdict, deque

def topological_sort_queue(graph):
    in_degree = {node: 0 for node in graph}
    for node in graph:
        for neighbor in graph[node]:
            in_degree[neighbor] += 1

    queue = deque(node for node in in_degree if in_degree[node] == 0)
    result = []

    while queue:
        current_node = queue.popleft()
        result.append(current_node)

        for neighbor in graph[current_node]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)

    if len(result) == len(graph):
        return result
    else:
        raise ValueError("Graph has a cycle")

# Example Usage:
graph = {
    1: [2, 3],
    2: [4],
    3: [4],
    4: []
}
print(topological_sort_queue(graph))


def topological_sort_dfs(graph):
    visited = set()
    stack = []

    def dfs(node):
        visited.add(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs(neighbor)
        stack.append(node)

    for node in graph:
        if node not in visited:
            dfs(node)

    return stack[::-1]

# Example Usage:
graph = {
    1: [2, 3],
    2: [4],
    3: [4],
    4: []
}
print(topological_sort_dfs(graph))


import timeit

# Assuming graph is defined and contains your data

time_queue = timeit.timeit(lambda: topological_sort_queue(graph), number=1000)
time_dfs = timeit.timeit(lambda: topological_sort_dfs(graph), number=1000)

print(f"Queue-based Topological Sort Time: {time_queue}")
print(f"DFS-based Topological Sort Time: {time_dfs}")
