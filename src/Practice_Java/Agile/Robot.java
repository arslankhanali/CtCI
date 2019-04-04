package Practice_Java.Agile;

import java.util.ArrayList;


public class Robot {
    int x;
    int y;
    Face face;
    int i;

    ArrayList<Face> NESW = new ArrayList<>();

    public Robot(int x, int y, char f) {
        this.x = x;
        this.y = y;

        if      (f == 'N') { face = face.north;i = 0;}
        else if (f == 'E') { face = face.east ;i = 1;}
        else if (f == 'W') { face = face.west ;i = 2;}
        else if (f == 'S') { face = face.south;i = 3;}

        NESW.add(face.north);
        NESW.add(face.east);
        NESW.add(face.south);
        NESW.add(face.west);
    }

    @Override
    public String toString() {
        return "Robot is located at (" + x + "," + y +") facing the " + face + " side.";
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
        }
    }


    public enum Face {
        north(0, 1), east(1, 0), south(0, -1), west(-1, 0);
        private int x, y;

        Face(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
