static int findPerfectFriends(ArrayList<Edge>[] graph)
    {
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];

        for(int i=0;i<vertices;i++)
        {
            if(visited[i] == false)
            {
                ArrayList<Integer> component = new ArrayList<>();
                findFirendsHelper(graph, i, visited, component);
                components.add(component);
            }
        }

        int pairs = 0;

        for(int i=0;i<components.size();i++)
        {
            for(int j=i+1;j<components.size();j++)
            {
                int count = (components.get(i).size() * components.get(j).size());
                pairs += count;
            }
        }

        return pairs;


    }
    
    static void findFirendsHelper(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> component)
    {
        visited[src] = true;
        component.add(src);
        for(Edge e:graph[src])
        {
            if(visited[e.nbr] == false)
            {
                findFirendsHelper(graph, e.nbr, visited, component);
            }
        }
    }
