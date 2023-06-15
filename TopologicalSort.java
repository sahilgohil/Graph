public static void topologicalSort(ArrayList<Edge>[] graph) {

        int vertice = graph.length;
            boolean[] visited = new boolean[graph.length];
            Stack<Integer> st = new Stack<>();
            for(int i=0;i<vertice;i++)
            {
                if(visited[i] == false)
                {
                    topologicalHelper(graph,i,visited,st);
                }
            }

            while(st.size()>0)
            {
                System.out.print(st.pop()+" ");
            }
        
       }

       public static void topologicalHelper(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {

            visited[src] = true;
            for(Edge e:graph[src])
            {
                if(visited[e.nbr] == false)
                {
                    topologicalHelper(graph, e.nbr, visited, st);
                }
            }
            st.push(src);
        
       }
