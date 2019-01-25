/*
Program to find identify island with maximum area and its perimeter in a grid.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Island {
    int perimeter;
    private int findArea(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0|| grid[i][j]==2) return 0;
        grid[i][j] = 2;
        perimeter += 4;
        if (i < grid.length - 1 && (grid[i + 1][j] == 1||grid[i + 1][j] == 2)) perimeter -= 2; // count down neighbours
        if (j < grid[i].length - 1 && (grid[i][j + 1] == 1 || grid[i][j+1] == 2)) perimeter -= 2; // count right neighbours

        int count = 1+findArea(i+1,j,grid)
                +findArea(i-1,j,grid)
                +findArea(i,j-1,grid)
                +findArea(i,j+1,grid);
        return count;
    }
    public int[] maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        int maxPeri=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) {
                    perimeter=0;
                    int curr_area = findArea(i, j, grid);
                    if(curr_area > maxArea){
                        maxArea = curr_area;
                        maxPeri = perimeter;
                    }
                    else if(curr_area == maxArea)
                        maxPeri = Math.min(maxPeri,perimeter);

                }
            }
        }
        return new int[]{maxArea,maxPeri};
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Island inst = new Island();
        String fileName = "C:/Users/vedas/dev/CodingPractice/src/perimeter.in";
        int n=0;
        String line = null;
        int[][] grid=null;

        try {
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean flag = true;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (flag) {
                    flag = false;
                    n = Integer.parseInt(line);
                    grid = new int[n][n];
                    continue;
                }
                for(int j=0; j<n; j++){
                    if(line.charAt(j)=='#')
                        grid[i][j]=1;
                    else
                        grid[i][j]=0;
                }
                i++;
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        int[] ans  = inst.maxAreaOfIsland(grid);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/vedas/dev/CodingPractice/src/perimeter.out"));
            writer.write(Integer.toString(ans[0])+" ");
            writer.write(Integer.toString(ans[1]));
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        //System.out.println(totalTime);
    }

}