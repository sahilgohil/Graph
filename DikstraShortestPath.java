static class DikstraPair implements Comparable<DikstraPair>{
        int v;
        String psf;
        int wsf;

            public DikstraPair(int v, String psf, int wsf)
            {
                this.v = v;
                this.psf = psf;
                this.wsf = wsf;
            }

            @Override
            public int compareTo(GraphQiestions.DikstraPair o) {
                return this.wsf-o.wsf;
            }
      }

      static void dikstraShortestPath(ArrayList<Edge>[] graph, Edge src)
      {
            PriorityQueue<DikstraPair> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[graph.length];
            pq.offer(new DikstraPair(src.sc, src.sc+" ", src.wt));

            while(pq.size()>0)
            {
                DikstraPair rp = pq.poll();
                // RM* WA*
                if(visited[rp.v] == true)
                {
                    continue;
                }

                visited[rp.v] = true;

                System.out.println(rp.v+" @ "+rp.psf+" W-"+rp.wsf);

                for(Edge e: graph[rp.v])
                {
                    if(visited[e.nbr] == false)
                    {
                        pq.offer(new DikstraPair(e.nbr, rp.psf+e.nbr+" ", rp.wsf+e.wt));
                    }
                }

            }

      }
