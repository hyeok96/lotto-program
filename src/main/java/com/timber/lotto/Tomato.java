package com.timber.lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static int M;
    static int N;
    static int H;
    static int[][][] boxs;
    static int[] dx = new int[]{1, 0, -1, 0, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dh = new int[]{0, 0, 0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boxs = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    boxs[k][i][j] = Integer.parseInt(st.nextToken());
                    if (boxs[k][i][j] == 1) {
                        q.add(new int[]{k, i, j});
                    }
                }
            }
        }

        int days = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int h = p[0];
            int x = p[1];
            int y = p[2];
            for (int l = 0; l < 6; l++) {
                int nh = h + dh[l];
                int nx = x + dx[l];
                int ny = y + dy[l];

                if ((nh < 0 || nh >= H) || (nx < 0 || nx >= N) || (ny < 0 || ny >= M) || boxs[nh][nx][ny] == -1) {
                    continue;
                }

                if (boxs[nh][nx][ny] == 0) {
                    boxs[nh][nx][ny] = boxs[h][x][y] + 1;
                    days = Math.max(days, boxs[h][x][y]);
                    q.add(new int[]{nh, nx, ny});
                }
            }

            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        System.out.printf("%d ", boxs[k][i][j]);
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }

        System.out.println(days);
    }

}