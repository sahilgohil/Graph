static void printBreadthFirstSearch(ArrayList<Edge>[] graph, int src)
     {
        ArrayDeque<PathPair> q = new ArrayDeque<>();
        q.add(new PathPair(src, src+""));
        boolean[] visited = new boolean[graph.length];
        while(q.size()>0)
        {
            // at the end queue should be empty
            // algorithm is -> RM*PA*

            PathPair p = q.removeFirst();
            if(visited[p.src] == true)
            {
                continue;
            }

            visited[p.src] = true;

            System.out.println(p.src+" @ "+p.psf);

            for(Edge e: graph[p.src])
            {
                if(visited[e.nbr] == false)
                {
                    q.add(new PathPair(e.nbr, p.psf+e.nbr+" "));
                }
            }
        }

     }
