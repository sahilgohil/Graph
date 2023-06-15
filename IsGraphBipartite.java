 static void isGraphBipartite(ArrayList<Edge>[] graph)
     {
        int vertice = graph.length;
        int[] visited = new int[vertice];
        Arrays.fill(visited,-1);

        for(int i=0;i<vertice;i++)
        {
            if(visited[i] == -1)
            {
                boolean isBipartite = isGraphBipartiteHelper(graph,i,visited);
                if(isBipartite == false)
                {
                    System.out.println("The graph is not bipartite");
                    return;
                }
            }
        }
        System.out.println("The graph is bipartite");
     }

     static boolean isGraphBipartiteHelper(ArrayList<Edge>[] graph, int src, int[] visited)
     {
        ArrayDeque<PathPair> q = new ArrayDeque<>();
        q.add(new PathPair(src, src+"", 0));

        while(q.size()>0)
        {
            //rM* W A*

            PathPair rmv = q.removeFirst();
            if(visited[rmv.src] != -1)
            {
                if(visited[rmv.src] != rmv.level)
                {
                    return false;
                }
            }
            else{
                visited[rmv.src] = rmv.level;
            }

            for(Edge e:graph[src])
            {
                if(visited[e.nbr] == -1)
                {
                    q.add(new PathPair(e.nbr, rmv.psf+e.nbr,rmv.level+1));
                }
            }
        }
        return true;
     }
