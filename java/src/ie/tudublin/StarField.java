// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;



// public class StarField extends PApplet {

//   Star[] stars;

//   Minim minim;
//   AudioPlayer ap;
//   AudioInput ai;
//   AudioBuffer ab;
  
//   public void settings() {
//     size(1024, 1000, P3D);
//   }
  
//   public void setup() {
//     minim = new Minim(this);
//     ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
//     ap.play();
//     ab = ap.mix;

//     background(0);
//     stars = new Star[800];
//     for (int i = 0; i < stars.length; i++) 
//     {
//       stars[i] = new Star();
//     }
//   }
  
//   public void draw() {
//     background(0);
//     translate(width / 2, height / 2);
  
//     float volume = ap.mix.level(); // Get the current amplitude

//     for (Star s : stars) 
//     {
//       s.update(volume);
//       s.show();
//     }
//   }

  
//   class Star {
    
//     float x, y, z;
//     float px, py, pz;
    
//     Star() {
//       x = random(-width / 2, width / 2);
//       y = random(-height / 2, height / 2);
//       z = random(width / 2);
//       pz = z;
//     }
    
//     void update(float volume) {
//       z = z - 10 - volume * 100;
//       if (z < 1) 
//       {
//         z = width/2;
//         x = random(-width / 2, width / 2);
//         y = random(-height / 2, height / 2);
//         pz = z;
//       }
//     }
    
//     void show() {
//       float sx = map(x / z, 0, 1, 0, width);
//       float sy = map(y / z, 0, 1, 0, height);
//       float r = map(z, 0, width/2, 16, 0);

//       ellipse(sx/2, sy/2, r/2, r/2);

//       float px = map(x / pz, 0, 1, 0, width);
//       float py = map(y / pz, 0, 1, 0, height);

//       stroke(255, 128);
    
//       line(sx, sy, px, py);
      

//       px = sx;
//       py = sy;
//       pz = z;
//     }
    
//   }
  
// }

// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;

// public class StarField extends PApplet {

//   Star[] stars;
//   float sunRadius = 200; // Radius of the sun

//   Minim minim;
//   AudioPlayer ap;
//   AudioInput ai;
//   AudioBuffer ab;

//   public void settings() {
//     size(1024, 1000, P3D);
//   }

//   public void setup() {
//     minim = new Minim(this);
//     ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
//     ap.play();
//     ab = ap.mix;

//     background(0);
//     stars = new Star[800];
//     for (int i = 0; i < stars.length; i++) {
//       stars[i] = new Star();
//     }
//   }

//   public void draw() {
//     background(0);
//     translate(width / 2, height / 2);

//     float volume = ap.mix.level(); // Get the current amplitude

//     // Draw the sun
//     fill(255, 255, 0);
//     noStroke();
//     ellipse(0, 0, sunRadius, sunRadius);

//     // Draw the sound waves around the sun
//     float waveRadius = sunRadius + volume * 200; // Increase the radius of the waves based on the current amplitude
//     stroke(255, 255, 0, 100);
//     noFill();
//     strokeWeight(2);
//     for (float i = 0; i < TWO_PI; i += 0.1) {
//       float x = cos(i) * waveRadius;
//       float y = sin(i) * waveRadius;
//       ellipse(x, y, 20, 20);
//     }

//     for (Star s : stars) {
//       s.update(volume);
//       s.show();
//     }
//   }

//   class Star {

//     float x, y, z;
//     float px, py, pz;

//     Star() {
//       x = random(-width / 2, width / 2);
//       y = random(-height / 2, height / 2);
//       z = random(width / 2);
//       pz = z;
//     }

//     void update(float volume) {
//       z = z - 10 - volume * 100;
//       if (z < 1) {
//         z = width / 2;
//         x = random(-width / 2, width / 2);
//         y = random(-height / 2, height / 2);
//         pz = z;
//       }
//     }

//     void show() {
//       float sx = map(x / z, 0, 1, 0, width);
//       float sy = map(y / z, 0, 1, 0, height);
//       float r = map(z, 0, width / 2, 16, 0);

//       ellipse(sx / 2, sy / 2, r / 2, r / 2);

//       float px = map(x / pz, 0, 1, 0, width);
//       float py = map(y / pz, 0, 1, 0, height);

//       stroke(255, 128);

//       line(sx, sy, px, py);

//       px = sx;
//       py = sy;
//       pz = z;
//     }

//   }

//}




