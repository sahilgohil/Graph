      static void depthFirstSearchIterative(ArrayList<Edge>[] graph, int src)
       {
            boolean[] visited = new boolean[graph.length];
            Stack<DepthPair> st = new Stack<>();

            st.push(new DepthPair(src, src+""));

            while(st.size()>0)
            {
                // R M* W A*
                DepthPair dp = st.pop();

                if(visited[dp.src] == true)
                {
                    continue;
                }

                visited[dp.src] = true;
                
                    System.out.println(dp.src+"@"+dp.psf);
                
                for(Edge edge:graph[dp.src])
                {
                    if(visited[edge.nbr] == false)
                    {
                        st.push(new DepthPair(edge.nbr, dp.psf+edge.nbr)); 
                    }
                }
            }
       }
