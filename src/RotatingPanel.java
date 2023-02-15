public class RotatingPanel extends Panel {
    private float degrees;
    private boolean rotating;
    public RotatingPanel(int _x, int _y, int _w, int _h){
        super( _x, _y, _w, _h);
        degrees = 1;
        rotating = false;
    }
    public void display(){
        if(!rotating){
            super.display();
        } else {
            Main.app.push();
            Main.app.imageMode(Main.app.CENTER);
            int ex = getx();
            int why = gety();
            Main.app.translate(ex+getWidth()/2, why+getHeight()/2);
            Main.app.rotate(Main.app.radians(degrees));
            degrees += 50000;
            setx(0);
            sety(0);
            super.display();
            setx(ex);
            sety(why);
            Main.app.pop();
        }
        Main.app.noTint();
    }
    public void handleMouseCLicked(int mX, int mY) {
        if (mX > getx() && mX <getx()+getWidth() && mY >gety() && mY < gety() + getHeight()) {
            System.out.println("mouseclicked");
            rotating = !rotating;
        }
    }
}