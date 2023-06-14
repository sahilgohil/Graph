    static void allPaths(ArrayList<Edge>[] graph, int src, int dt,boolean[] visited,String asf)
    {
        if(src == dt)
        {
            System.out.println(asf+" -> "+src);
            return;
        }

        visited[src] = true;

        for(Edge edge:graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                allPaths(graph, edge.nbr, dt, visited, asf+"->"+src);
            }
        }
        visited[src] = false;
    }
