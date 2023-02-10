public class CustomPanel extends Panel{
    private int bounceMax;
    private int bounceMin;
    private int initially;
    private boolean bouncing;
    private int why;

    public CustomPanel(int _x, int _y, int _w, int _h){
        super( _x, _y, _w, _h);
        bounceMin = _y ;
        bounceMax = _y-50;
        bouncing = false;
        initially = _y-20;
        why = _y-20;
    }

    public void display(){
        Main.app.tint(0,100,255,150);
        if(bouncing){
            sety(initially);
            if( why > bounceMax && why < bounceMin){
                sety(why+=10);
            }
            if(why == bounceMin){
                sety(initially);
                why = initially;
            }
        }
        super.display();
        Main.app.noTint();
    }


    public void handleMouseCLicked(int mX, int mY) {
        if (mX > getx() && mX <getx()+getWidth() && mY >gety() && mY < gety() + getHeight()) {
            Main.app.println("mouseclicked");
        }
        bouncing = !bouncing;
    }
}