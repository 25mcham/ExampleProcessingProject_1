import processing.core.PImage;
public class ContrastedPanel extends Panel {

    public ContrastedPanel(int _x, int _y, int _w, int _h){
        super( _x, _y, _w, _h); //invoking the panel constructor
    }

    public void display(){
        PImage newImg = getImage().copy();
        newImg.loadPixels();

        for(int y = 0; y < newImg.height; y++){
            for(int x = 0; x <newImg.width; x++){
                int loc = x +(y *newImg.width);
                if(Main.app.brightness(newImg.pixels[loc]) >190){
                    newImg.pixels[loc] = Main.app.color(255);
                } else {
                    newImg.pixels[loc] = Main.app.color(0,0);
                }
            }
        }

        newImg.updatePixels();

        Main.app.image(newImg, getx(), gety(), getWidth(), getHeight());
    }
}