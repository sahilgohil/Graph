static void printHamiltonPathAndCycle(ArrayList<Edge>[] graph)
    {
        int vertices = graph.length;
        // boolean[] visited = new boolean[vertices];
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0;i<vertices;i++)
        {
            if(visited.contains(i) == false)
            {
                helperHamilton(graph,i,visited,i,"");
            }
        }
     }
     static void helperHamilton(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, int osrc,String asf)
     {
        visited.add(src);
        if(visited.size() == graph.length)
        {
            System.out.print(asf +src);
            for(Edge e:graph[src])
            {
                if(e.nbr == osrc)
                {
                    System.out.println("*");
                    visited.remove(src);
                    return;
                }
            }
            System.out.println(".");
            visited.remove(src);
            return;
        }

        
        for(Edge e: graph[src])
        {
            if(visited.contains(e.nbr) == false)
            {
                helperHamilton(graph, e.nbr, visited, osrc, asf+src+" ");
            }
        }

        visited.remove(src);
     }
