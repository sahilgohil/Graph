    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dt, boolean[] visited)
    {
        if(src == dt)
        {
            return true;
        }

        visited[src] = true;

        for(Edge edge:graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                boolean hasPathToDest = hasPath(graph, edge.nbr, dt, visited);
                if(hasPathToDest == true)
                {
                    return true;
                }
            }
        }

        return false;
    }
