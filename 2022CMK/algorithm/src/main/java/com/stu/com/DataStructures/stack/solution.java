package com.stu.com.DataStructures.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: csx
 * @Date: 2022/4/23 14:30
 * @Description:
 */
public class solution {
    public static void main(String[] args) {

        int[][] prerequisites  = new int[][]{{1, 0}};
        canFinish(2, prerequisites);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 定义入度表, 邻接表, 队列
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 初始化邻接表, , 第一维是第二维的前驱结点
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<Integer>());
        }
        // 初始化入度表和邻接表
        for (int[] temp : prerequisites) {
            int curr = temp[1];
            int next = temp[0];
            inDegrees[next]++;
            lists.get(curr).add(next);
        }
        // 将入度为 0 的结点加入队列
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 开始 BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            numCourses--;
            List<Integer> nextList = lists.get(curr);
            // 遍历当前出队结点的所有后继结点, 将其入度减一, 同时判断若为 0 ,
            // 表明可以到达该结点, 入队
            for (int i = 0; i < nextList.size(); i++) {
                int next = nextList.get(i);
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return numCourses == 0;
    }
}
