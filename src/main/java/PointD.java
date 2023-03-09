public class PointD implements Comparable<PointD>{

    int x;
    int y;
    String val;
    int score;

    public PointD(int i, int j, int row, int cols, String val, int[][] m){
        if(i==-1){
            x = row-1;
        }else{
            if(i==row){
                x = 0;
            }else{
                x = i;
            }
        }

        if(j==-1){
            y = cols-1;
        }else{
            if(j==cols){
                y = 0;
            }else{
                y = j;
            }
        }
        this.val = val;
        score = m[x][y];
    }

    @Override
    public int compareTo(PointD o) {
        return o.score-this.score;
    }
}
