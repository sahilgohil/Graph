static class PrimPair implements Comparable<PrimPair>{
        int v;
        int w;
        public PrimPair(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(GraphQiestions.PrimPair o) {
            return this.w-o.w;
        }
       }

       static void primAlgoMinimumSpanningTree(ArrayList<Edge>[] graph, int src)
       {
            PriorityQueue<PrimPair> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[graph.length];
            pq.offer(new PrimPair(src, 0));
        

            while(pq.size()>0)
            {
                // rm* wA*
                PrimPair p = pq.poll();
                if(visited[p.v] == true)
                {
                    continue;
                }

                visited[p.v] = true;
                System.out.println(p.v+" @ "+p.w);

                for(Edge e:graph[p.v])
                {
                    if(visited[e.nbr] == false)
                    {
                        pq.offer(new PrimPair(e.nbr, e.wt));
                    }
                }
            }

       }
