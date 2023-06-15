static class InfectionPair{
        int v;
        int time;
        public InfectionPair(int v, int t)
        {
            this.v = v;
            this.time = t;
        }
     }
      static int spreadInfection(ArrayList<Edge>[] graph, int src, int t)
      {
            ArrayDeque<InfectionPair> q = new ArrayDeque<>();
            boolean[] visited = new boolean[graph.length];
            int count =0;
            q.add(new InfectionPair(src, 1));

            while(q.size()>0)
            {
                // rm*wA*
                InfectionPair rp = q.removeFirst();
                if(visited[rp.v] == true)
                {
                    continue;
                }
                visited[rp.v] = true;
                count++;
                

                for(Edge e:graph[rp.v])
                {
                    if(visited[e.nbr] == false )
                    {
                        q.add(new InfectionPair(e.nbr, rp.time+1));
                    }
                }
                if(rp.time >t)
                {
                    break;
                }

            }
            return count;
      }
