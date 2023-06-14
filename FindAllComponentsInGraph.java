/*
     * getting each component of the graph that is a seperate from other components
     * 
     * requires two methods
     * 
     * first that will create a list of list of integers that will store each list of components and return it
     * 
     * then we will call for each of the vertice in the graph the method that will mark the component visited and add the component to 
     * a list and fill the list
     * then add the lsit to the return result
     */

    static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph, int src)
    {
        int vertices = graph.length;
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++)
        {
            if(visited[i] == false)
            {
                ArrayList<Integer> comp = new ArrayList<>();
                getCompHelper(graph,i,visited,comp );
                components.add(comp);
            }
        }

        return components;

    }
    static void getCompHelper(ArrayList<Edge>[] graph,int src, boolean[] visited, ArrayList<Integer> comp)
    {
        visited[src] = true;
        comp.add(src);
        for(Edge e:graph[src])
        {
            if(visited[e.nbr] == false)
            {
                getCompHelper(graph, e.nbr, visited, comp);
            }
        }   
    }
