static void printAllTypesOfPath(ArrayList<Edge>[] graph, int src, int dest, int k, int weight, boolean[] visited,String asf)
    {
        if(src == dest)
        {
            if(weight < shortWeight)
            {
                shortPath = asf+src;
                shortWeight = weight;
            }
            if(weight > longWeight)
            {
                longPath = asf+src;
                longWeight = weight;
            }
            if(pq.size() < k)
            {
                pq.add(new Pair(asf+src, weight));
            }
            else{
                if(weight > pq.peek().weight)
                {
                    pq.remove();
                    pq.add(new Pair(asf+src, weight));
                }
            }

            return;
        }

        visited[src] = true;
        
        for(Edge edge:graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                printAllTypesOfPath(graph, edge.nbr, dest, k, weight+edge.wt, visited, asf+src+"->");
            }
        }

        visited[src] = false;
        
    }
