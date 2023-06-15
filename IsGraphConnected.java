static boolean isConnected(ArrayList<Edge>[] graph)
    {
        int vertice = graph.length;
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[vertice];
        for(int i=0;i<vertice;i++)
        {
            if(visited[i] == false)
            {
                ArrayList<Integer> component = new ArrayList<>();
                isConnectedHelper(graph,i,visited,component);
                components.add(component);
            }

        }

        return (components.size() == 1);
    }

    static void isConnectedHelper(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> component)
    {
        visited[src] = true;
        component.add(src);
        for(Edge e: graph[src])
        {
            if(visited[e.nbr] == false)
            {
                isConnectedHelper(graph, e.nbr, visited, component);
            }
        }
    }
