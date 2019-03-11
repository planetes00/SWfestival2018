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

public class mineshouse extends PApplet {

PImage mine, one, two, three, four, five, six, seven, eight, flag, none, cover, gameOver, clear, bang, keep, timer, ballon;
PFont f;
int i, j, k, a, b, c, rand, countM=0, countU=0, countF=0, se=0, countT=millis()+1000, countC=0;
;
int[] mines=new int[480];
int[] mineo={1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
int[] flags={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
int[] uncover={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
int[] clicks={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

public void setup() {
  
  background(255);
  mine=loadImage("mine.png");
  one=loadImage("one.png");
  two=loadImage("two.png");
  three=loadImage("three.png");
  four=loadImage("four.png");
  five=loadImage("five.png");
  six=loadImage("six.png");
  seven=loadImage("seven.png");
  eight=loadImage("eight.png");
  flag=loadImage("flag.png");
  none=loadImage("none.png");
  cover=loadImage("cover.png");
  gameOver=loadImage("gameOver.png");
  clear=loadImage("clear.png");
  bang=loadImage("bang.png");
  keep=loadImage("keep.png");
  ballon=loadImage("ballon.png");
  timer=loadImage("timer.png");
  f=loadFont("Monospaced-64.vlw");
  while (countM<=99) {
    while (true) {
      rand=floor(random(480));
      if (mineo[rand]==1) {
        mineo[rand]=0;
        countM++;
        break;
      }
    }
    if (countM==99) {
      break;
    }
  }
  for (k=0; k<480; k++) {
    j=k/30;
    i=k%30;
    mines[k]=0;
    if (mineo[k]!=0) {
      if (j!=0) {
        if (mineo[k-30]==0) {
          mines[k]++;
        }
      }
      if (j!=15) {
        if (mineo[k+30]==0) {
          mines[k]++;
        }
      }
      if (i!=0) {
        if (mineo[k-1]==0) {
          mines[k]++;
        }
      }
      if (i!=29) {
        if (mineo[k+1]==0) {
          mines[k]++;
        }
      }
      if (i!=29&&j!=15) {
        if (mineo[k+1+30]==0) {
          mines[k]++;
        }
      }
      if (i!=29&&j!=0) {
        if ( mineo[k+1-30]==0) {
          mines[k]++;
        }
      }
      if (i!=0&&j!=15) {
        if (mineo[k-1+30]==0) {
          mines[k]++;
        }
      }
      if (i!=0&&j!=0) {
        if (mineo[k-1-30]==0) {
          mines[k]++;
        }
      }
    }
  }
  for (i=0; i<30; i++) {
    for (j=0; j<16; j++) {
      image(mine, i*40, j*40, 40, 40);
    }
  }
  image(timer, 4, 670-30, 30, 30);
  image(ballon, 1200-35, 670-30, 30, 30);
  fill(0xff8288C6);
  textAlign(CENTER);
  text("Look out ballons!", width/2, 670-12);
  for (k=0; k<uncover.length; k++) {
    uncover[k]=0;
  }
}

public void draw() {
  frameRate=0.3f;
  noStroke();
  fill(255);
  rect(1200-60, 670-25, 20, 30);
  rect(35, 670-25, 60, 30);
  if (millis()>=countT) {
    countT=millis()+1000;
    se=se+1;
  }
  for (k=0; k<480; k++) {
    j=k/30;
    i=k%30;
    if (i*40<mouseX&&mouseX<(i+1)*40&&j*40<mouseY&&mouseY<(j+1)*40) {
      if (mousePressed&&mouseButton==LEFT) {
        if (mineo[k]!=0) {
          around(k, i, j);
        } else if (mineo[k]==0) {
          explosion(k);
        }
      } else if (mousePressed&&mouseButton==RIGHT) { 
        image(flag, i*40, j*40, 40, 40);
      }
    }
  }
  for (k=0; k<480; k++) {
    j=k/30;
    i=k%30;
    if (uncover[k]==1) {
      if (j!=0) {
        around(k-30, i, j-1);
        flags[k-30]=0;
      }
      if (j!=15) {
        around(k+30, i, j+1);
        flags[k+30]=0;
      }
      if (i!=0) {
        around(k-1, i-1, j);
        flags[k-1]=0;
      }
      if (i!=29) {
        around(k+1, i+1, j);
        flags[k+1]=0;
      }
      if (i!=29&&j!=15) {
        around(k+1+30, i+1, j+1);
        flags[k+1+30]=0;
      }
      if (i!=29&&j!=0) {
        around(k+1-30, i+1, j-1);
        flags[k+1-30]=0;
      }
      if (i!=0&&j!=15) {
        around(k-1+30, i-1, j+1);
        flags[k-1+30]=0;
      }
      if (i!=0&&j!=0) {
        around(k-1-30, i-1, j-1);
        flags[k-1-30]=0;
      }
      uncover[k]=0;
      flags[k]=0;
    }
  }
  fill(0xff7ECBFA);
  textAlign(LEFT);
  text(se, 38, 670-12);
  fill(255);
  textAlign(RIGHT);
  fill(0xff636464);
  text(99-countF, 1200-40, 670-12);
  for (k=0; k<480; k++) {
    countC+=clicks[k];
  }
  if (countC==(480-99)) {
    tint(255, 150);
    image(clear, 0, 0, 1200, 670);
    noLoop();
  }
}


public void mousePressed() {
  countF=0;
  for (k=0; k<480; k++) {
    j=k/30;
    i=k%30;
    if (i*40<mouseX&&mouseX<(i+1)*40&&j*40<mouseY&&mouseY<(j+1)*40) {
      if (flags[k]!=1) {
        if (mousePressed&&mouseButton==RIGHT) {
          flags[k]=1;
        }
      } else if (flags[k]==1) {
        if (mousePressed&&mouseButton==LEFT) {
          flags[k]=0;
        }
      }
    }
  }
  for (k=0; k<480; k++) {
    countF+=flags[k];
  }
}

public void around(int hand, int air, int con) {
  if (mines[hand]==0) {
    image(none, air*40, con*40, 40, 40);
    uncover[hand]=1;
  }
  if (mines[hand]==1) {
    image(one, air*40, con*40, 40, 40);
  }
  if (mines[hand]==2) {
    image(two, air*40, con*40, 40, 40);
  }
  if (mines[hand]==3) {
    image(three, air*40, con*40, 40, 40);
  }
  if (mines[hand]==4) {
    image(four, air*40, con*40, 40, 40);
  }
  if (mines[hand]==5) {
    image(five, air*40, con*40, 40, 40);
  }
  if (mines[hand]==6) {
    image(six, air*40, con*40, 40, 40);
  }
  if (mines[hand]==7) {
    image(seven, air*40, con*40, 40, 40);
  }
  if (mines[hand]==8) {
    image(eight, air*40, con*40, 40, 40);
  }
  clicks[hand]=1;
}

public void explosion(int groundZero) {
  j=groundZero/30;
  i=groundZero%30;
  for (c=0; c<480; c++) {
    a=c/30;
    b=c%30;
    if (mineo[c]==0) {
      if (flags[c]==1) {
        image(keep, b*40, a*40, 40, 40);
      } else if (flags[c]==0) {
        image(cover, b*40, a*40, 40, 40);
      }
      image(bang, i*40, j*40, 40, 40);
      noLoop();
      textAlign(CENTER);
      fill(255);
      rect(400, 670-25, 300, 30); 
      fill(0xfffe3254);
      text("gameover", width/2, 670-12);
    }
  }
}

  public void settings() {  size(1200, 677); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "mineshouse" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
