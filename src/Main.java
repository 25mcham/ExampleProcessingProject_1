import processing.core.PApplet;
import java.util.Random;

import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet{
    final int NUM_PANELS_HORIZONTAL = 3;
    final int NUM_PANELS_VERTICAL = 5;
    private ArrayList<Panel> panels = new ArrayList<Panel>();
    public static PApplet app;

    public Main(){
        super();
        app = this;
    }

    public static void main(String[] args){
        PApplet.main("Main");
    }

    public void settings(){
        size(600,600);
    }
    public void setup(){
        int index = 0; // index of the array ( for storing the panels in the array)
        int h = height/NUM_PANELS_VERTICAL; //height of the image
        int w = width/NUM_PANELS_HORIZONTAL; // width = total width/ number of panels

        for(int col = 0; col < NUM_PANELS_VERTICAL; col ++){// iterating
            for(int row = 0; row < NUM_PANELS_HORIZONTAL; row++){
                int y = col * h;
                int x = row * w;
                Panel p;
                p = new Panel(x,y,w,h);
                if(col == 0){
                    p = new RotatingPanel(x,y,w,h); //(0, 0, height/NUM_PANELS_VERTICAL, width/NUM_PANELS_HORIZONTAL)
                }
                if(col == 1){
                    p = new TintedPanel(x,y,w,h);
                }

                if(col == 2){
                    p = new ContrastedPanel(x,y,w,h);
                }
                if(col == 3){
                    p = new Panel(x,y,w,h);
                }
                if(col == 4){
                    p = new CustomPanel(x,y,w,h); //(4*height/NUM_PANELS_VERTICAL, 2*width/NUM_PANELS_HORIZONTAL,
                }
                p.setUpImage("data/snorlax copy.png");  //loads image
                panels.add(index , p);
                index++;
            }
        }
    }

    public void draw(){
        fancyBackground();
        for(int i = 0; i < panels.size(); i++){
            Panel p = panels.get(i);
            p.display(); //display panel p
        }
    }

    public void mouseClicked(){
        for(int i = 0; i < panels.size(); i++){
            panels.get(i).handleMouseCLicked(mouseX, mouseY); // if mouse click is inside the image, print mouse clicked to console
        }
    }

    private void fancyBackground(){
        loadPixels();
        for(int a = 0; a < width; a++){
            for(int b = 0; b < height; b++){
                int loc = a + b * width;
                if(a % 2 == 0) {
                    pixels[loc] = color(b*2,a,b/(a+1));
                } else {
                    pixels[loc] = color(a*b,a,3*b);
                }
            }
        }
        updatePixels();
    }

    public void keyPressed(){
        if(key == 's'){
            Panel last = panels.remove(14);
            Panel first = panels.remove(0);
            panels.add(first);
            panels.add(0,last);

            int lastX = last.getx();
            int lastY = last.gety();

            last.setx(first.getx());
            last.sety(first.gety());
            first.setx(lastX);
            first.sety(lastY);
        }

        if(key == 'r'){
            Random rand  = new Random();
            int exy = rand.nextInt(15);
            Panel og = panels.remove(exy);

            if(4<=exy && exy <= 6){
                CustomPanel swap = new CustomPanel(og.getx(), og.gety(), og.getWidth(), og.getHeight());
                panels.add(exy, swap);

                swap.setx(og.getx());
                swap.sety(og.gety());

                swap.setUpImage("data/snorlax copy.png");
            }else {
                TintedPanel swap = new TintedPanel(og.getx(), og.gety(), og.getWidth(), og.getHeight());
                panels.add(exy, swap);

                swap.setx(og.getx());
                swap.sety(og.gety());

                swap.setUpImage("data/snorlax copy.png");
            }
        }
    }
}