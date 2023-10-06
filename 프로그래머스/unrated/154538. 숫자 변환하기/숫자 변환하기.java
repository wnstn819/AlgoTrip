import java.util.*;

class Solution {
        static int N,M;
    public int solution(int x, int y, int n) {
        int answer = 0;
        M=x;
        N=n;
        return BFS(new Node(y,0));
    }
    
    public int BFS(Node node){
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while(!que.isEmpty()){
            Node num = que.poll();
            if(num.x == M){
                return num.depth;
            }
            
            if(num.x - N >=M){
                que.add(new Node(num.x - N,num.depth +1));    
            }
            if(num.x/2 >= M  && num.x % 2 == 0){
                que.add(new Node(num.x/2,num.depth +1));
            }
            if(num.x/3 >= M && num.x % 3 == 0){
                que.add(new Node(num.x/3,num.depth +1));
            }
            
            
            
        }
        return -1;
    }
}
class Node{
    int x;
    int depth;
    
    Node(int x,int depth){
        this.x =x;
        this.depth = depth;
    }
}