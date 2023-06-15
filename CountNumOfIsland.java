static int countNumberOfIslands(int [][] arr)
    {

        int count =0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j] == 0 && visited[i][j] == false)
                {
                    countIslandHelper(arr,i,j,visited);
                    count++;
                }
            }
        }

        return count;
    }

    static void countIslandHelper(int[][] arr, int i, int j, boolean[][] visited)
    {
        if(i< 0 || j<0 || i>arr.length || j> arr[0].length || arr[i][j] == 1 || visited[i][j] == true)
        {
            return;
        }

        visited[i][j] = true;
        countIslandHelper(arr, i+1, j, visited);
        countIslandHelper(arr, i-1, j, visited);
        countIslandHelper(arr, i, j+1, visited);
        countIslandHelper(arr, i, j-1, visited);

    }
