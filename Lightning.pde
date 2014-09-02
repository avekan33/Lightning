int startX;
int startY;
int changeX;
int changeY;
int colorX;
int fade;
boolean control;
void setup()
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

void draw()
{
	lightning();
}
void mousePressed()
{
	control = !control;
}
void lightning()
{
	if(control)
	{
		changeX = startX + int(random(10));
		changeY = startY + int(random(-10,10));
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

