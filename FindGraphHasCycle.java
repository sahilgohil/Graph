static void findGraphHasCycle(ArrayList<Edge>[] graph)
     {
        int vertice = graph.length;
        boolean[] visited = new boolean[vertice];
        for(int i=0;i<vertice;i++)
        {
            if(visited[i] == false)
            {
                // do something
                boolean cycle = hasCycle(graph, visited, i);
                if(cycle)
                {
                    System.out.println("Graph Has a Cycle");
                    return;
                }
            }
        }
        System.out.println("Graph has no cycle");
     }

     static boolean hasCycle(ArrayList<Edge>[] graph, boolean[] visited, int src)
     {
        ArrayDeque<PathPair> q = new ArrayDeque<>();
        q.add(new PathPair(src, src+""));

        while(q.size()>0)
        {
            // rm* W a*
            PathPair r = q.removeFirst(); // remove
            if(visited[r.src] == true) // mark *
            {
                return true;
            }
            visited[r.src] = true; // mark *

            // work
            for(Edge e: graph[r.src])
            {
                if(visited[e.nbr] == false)
                {
                    q.add(new PathPair(e.nbr, r.psf+e.nbr));
                }
            }
        }
        return false;
     }
