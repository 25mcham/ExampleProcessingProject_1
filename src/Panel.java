import processing.core.PImage;
public class Panel {
    private int x;
    private int y;
    private int w;
    private int h;
    private PImage img;

    public Panel(int _x, int _y, int _w, int _h) {//constructor
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }

    public void setUpImage(String imageName) {
        img = Main.app.loadImage(imageName);
    }

    public void display() {
        Main.app.image(img, x, y, w, h);
    }

    public void handleMouseCLicked(int mX, int mY) {
        if (mX > x && mX <x+w && mY >y && mY < y + h) {
            Main.app.println("mouseclicked");
        }
    }

    public PImage getImage() {
        return img;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }
    public void setx(int inx) {
        x = inx;
    }

    public void sety(int iny) {
        y = iny;
    }
}
