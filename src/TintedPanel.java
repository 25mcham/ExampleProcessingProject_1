public class TintedPanel extends Panel {
    public TintedPanel(int _x, int _y, int _w, int _h){
        super( _x, _y, _w, _h); //invoking the panel constructor
    }

    public void display(){
        Main.app.tint(255,0,0,200);
        super.display(); // call display method from panel
        Main.app.noTint();
    }
}