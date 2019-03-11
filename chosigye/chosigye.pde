int se=0; //초
int countT=millis()+1000; //
PFont f;

void setup(){
  size(700,330);
  background(130);
  f=createFont("Futura",250);
  textFont(f,250);
}

void draw() {
 if(millis()>=countT){  //millis가 1초에 도달할 때 실행
    countT=millis()+1000; //1초로 리셋
    se=se+1;
}
background(130);
textAlign(CENTER);
 text(se,width/2,250);
}
