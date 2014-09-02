import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightning extends PApplet {

int startX;
int startY;
int changeX;
int changeY;
int colorX;
int fade;
boolean control;
public void setup()
{
	size(510,255);
	background(0);
	startX = 0;
	startY = 127;
	changeX = 0;
	changeY = 0;
	control = false;
	frameRate(240);
	fade = 0;
}

public void draw()
{
	lightning();
}
public void mousePressed()
{
	control = !control;
}
public void lightning()
{
	if(control)
	{
		changeX = startX + PApplet.parseInt(random(10));
		changeY = startY + PApplet.parseInt(random(-10,10));
		if(startX <256)
		{
			colorX = startX;
		}
		else
		{
			colorX = 510 - startX;
		}
		stroke(0,colorX,startY);
		line(startX,startY,changeX,changeY);
		startX = changeX;
		startY = changeY;
		if(startX >510)
		{
			startX = 0;
			startY = 127;
			while(fade<121)
			{	
				fade++;
			}
			fill(0,fade);
			rect(0,0,510,255);
		}
	}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
