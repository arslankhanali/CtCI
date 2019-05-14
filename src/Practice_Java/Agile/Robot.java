package Practice_Java.Agile;

import java.util.ArrayList;


public class Robot {
    int max_x;
    int max_y;
    int x;
    int y;
    Face face;
    int i;

    ArrayList<Face> NESW = new ArrayList<>();

    public Robot(int max_x, int max_y,int x, int y, char f) {
        this.x = x;
        this.y = y;
        this.max_x = x;
        this.max_y = y;

        if      (f == 'N') { face = face.N;i = 0;}
        else if (f == 'E') { face = face.E ;i = 1;}
        else if (f == 'W') { face = face.W ;i = 2;}
        else if (f == 'S') { face = face.S;i = 3;}

        NESW.add(face.N);
        NESW.add(face.E);
        NESW.add(face.S);
        NESW.add(face.W);
    }

    @Override
    public String toString() {
        return x+" "+y+" "+face;
    }

    public void command(String s) {
        char[] charArray = s.toCharArray();

        for (char character : charArray) {moveRobot(character);}
    }

    public void moveRobot(char c) {
        if (c == 'R') {
            i = i + 1; if (i > 3) { i = 0;}
            this.face = NESW.get(i);

        } else if (c == 'L') {
            i = i - 1; if (i < 0) { i = 3;}
            this.face = NESW.get(i);

        } else if (c == 'M') {
            x = x + this.face.x;
            y = y + this.face.y;

//            if(x>max_x || y>max_y){
//                System.out.println("Robot has moved beyond initial parameters");
//            }

        }
    }


    public enum Face {
        N(0, 1), E(1, 0), S(0, -1), W(-1, 0);
        private int x, y;

        Face(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
