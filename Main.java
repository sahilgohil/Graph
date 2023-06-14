BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = 0;
        try{
            vertices = Integer.parseInt(br.readLine());
        

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }

        int numOfEdges = Integer.parseInt(br.readLine());

        for(int i=0;i<numOfEdges;i++)
        {
            String[] parts = br.readLine().split(" ");
            int vertice1 = Integer.parseInt(parts[0]);
            int vertice2 = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);

            graph[vertice1].add(new Edge(vertice1, vertice2, weight));
            graph[vertice2].add(new Edge(vertice2, vertice1, weight));
        }
