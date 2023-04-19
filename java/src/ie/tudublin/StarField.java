// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;

// public class StarField extends PApplet {

//     Star[] stars;

//     Minim minim;
//     AudioPlayer ap;
//     AudioInput ai;
//     AudioBuffer ab;

//     SunSlitClass sunSlit;

//     public void settings() {
//         size(1024, 1000, P3D);
//     }

//     public void setup() {
//         minim = new Minim(this);
//         ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
//         ap.play();
//         ab = ap.mix;

//         background(0);
//         stars = new Star[800];
//         for (int i = 0; i < stars.length; i++) {
//             stars[i] = new Star();
//         }

//         sunSlit = new SunSlitClass();
//     }

//     public void draw() {
//         background(0);
//         translate(width / 2, height / 2);

//         float volume = ap.mix.level(); // Get the current amplitude

//         sunSlit.draw();

//         for (Star s : stars) {
//             s.update(volume);
//             s.show();
//         }
//     }

//     class Star {

//         float x, y, z;
//         float px, py, pz;

//         Star() {
//             x = random(-width / 2, width / 2);
//             y = random(-height / 2, height / 2);
//             z = random(width / 2);
//             pz = z;
//         }

//         void update(float volume) {
//             z = z - 10 - volume * 100;
//             if (z < 1) {
//                 z = width / 2;
//                 x = random(-width / 2, width / 2);
//                 y = random(-height / 2, height / 2);
//                 pz = z;
//             }
//         }

//         void show() {
//             float sx = map(x / z, 0, 1, 0, width);
//             float sy = map(y / z, 0, 1, 0, height);
//             float r = map(z, 0, width / 2, 16, 0);

//             ellipse(sx / 2, sy / 2, r / 2, r / 2);

//             float px = map(x / pz, 0, 1, 0, width);
//             float py = map(y / pz, 0, 1, 0, height);

//             stroke(255, 128);

//             line(sx, sy, px, py);

//             px = sx;
//             py = sy;
//             pz = z;
//         }

//     }

//     public class SunSlitClass {

//         // RGB colors
//         int[] sunColors = {
//             color(212, 202, 11),
//             color(214, 198, 30),
//             color(211, 170, 26),
//             color(216, 157, 51),
//             color(217, 124, 64),
//             color(213, 104, 81),
//             color(212, 51, 98),
//             color(215, 29, 121),
//             color(217, 11, 139),
//             color(217, 0, 151)
//         };

//         int bgColor = color(37, 25, 53);
//         float sunRadius = 300;
//         float topSlitY;
//         Rectangle[] slits;

//         class Rectangle {
//           float x, y, w, h;

//           Rectangle(float y, float h) {
//             this.x = width / 2 - sunRadius;
//             this.w = 2 * sunRadius;
//             this.y = y;
//             this.h = h;
//           }

//           void draw() {
//             fill(bgColor);
//             rect(x, y, w, h);
//           }

//           void update() {
//             y -= 0.5;

//             if (y < topSlitY) {
//               y = height / 2 + sunRadius;
//             }

//             h = map(y, topSlitY, height / 2 + sunRadius, 1.0f, 40.0f);
//           }
//         }

//         public void settings() {
//           size(1200, 800);
//         }

//         public void setup() {
//           topSlitY = height / 2 - (sunRadius / 4);

//           slits = new Rectangle[6];

//           float y = topSlitY;
//           float h = 1.0f;
//           for (int i = 0; i < slits.length; i++) {
//             slits[i] = new Rectangle(y, h);

//             y += ((height / 2 + sunRadius) - topSlitY) / slits.length;
//             h = map(y, topSlitY, height / 2 + sunRadius, 1.0f, 40.0f);
//           }
//         }

//         public void draw() {
//           background(bgColor);

//           noStroke();
//           fill(sunColors[0]);
//           ellipse(width / 2, height / 2, 2 * sunRadius, 2 * sunRadius);

//           loadPixels();

//           for (int i = 0; i < pixels.length; i++) {

//             if (pixels[i] == sunColors[0]) {
//               int y = i / width;

//               float step = map(y, height / 2 - sunRadius, height / 2 + sunRadius, 0, 1.0f);

//               pixels[i] = interpolateColor(sunColors, step);
//             }

//           }

//           updatePixels();

//           for (Rectangle r : slits) {
//             r.update();
//             r.draw();
//           }
//         }

//         public int interpolateColor(int[] arr, float step) {
//           int sz = arr.length;

//           if (sz == 1 || step <= 0.0f) {
//             return arr[0];
//           } 
//           else if (step >= 1.0f) {
//             return arr[sz - 1];
//           } 
//           else {
//             float f = step * (sz - 1);
//             int i = (int) f;
//             float p = f - i;
//             return lerpColor(arr[i], arr[i + 1], p);
//           }
//         }
//       }

// }

// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;

// public class StarField extends PApplet {

// Star[] stars;

// Minim minim;
// AudioPlayer ap;
// AudioInput ai;
// AudioBuffer ab;

// public void settings() {
// size(1024, 1000, P3D);
// }

// public void setup() {
// minim = new Minim(this);
// ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
// ap.play();
// ab = ap.mix;

// background(0);
// stars = new Star[800];
// for (int i = 0; i < stars.length; i++) {
// stars[i] = new Star();
// }
// }

// public void draw() {
// background(0);
// translate(width / 2, height / 2);

// float volume = ap.mix.level(); // Get the current amplitude
// float[] fft = ap.mix.toArray();

// for (Star s : stars) {
// s.update(volume, fft);
// s.show();
// }
// }

// class Star {

// float x, y, z;
// float px, py, pz;
// float size;

// Star() {
// x = random(-width / 2, width / 2);
// y = random(-height / 2, height / 2);
// z = random(width / 2);
// pz = z;
// size = 0;
// }

// void update(float volume, float[] fft) {
// z = z - 10 - volume * 100;
// if (z < 1) {
// z = width / 2;
// x = random(-width / 2, width / 2);
// y = random(-height / 2, height / 2);
// pz = z;
// }

// int index = (int) map(x / z, 0, 1, 0, fft.length - 1);
// float freq = fft[index];
// float sizeTarget = map(freq, 0, 1, 0, 200);
// size += (sizeTarget - size) * 0.1;
// }

// void show() {
// float sx = map(x / z, 0, 1, 0, width);
// float sy = map(y / z, 0, 1, 0, height);

// noStroke();
// fill(255, 128);
// ellipse(sx / 2, sy / 2, size / 2, size / 2);

// float px = map(x / pz, 0, 1, 0, width);
// float py = map(y / pz, 0, 1, 0, height);

// stroke(255, 128);
// line(sx, sy, px, py);

// px = sx;
// py = sy;
// pz = z;
// }
// }

// }

// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;

// public class StarField extends PApplet {

// Star[] stars;
// float sunRadius = 200; // Radius of the sun

// Minim minim;
// AudioPlayer ap;
// AudioInput ai;
// AudioBuffer ab;

// public void settings() {
// size(1024, 1000, P3D);
// }

// public void setup() {
// minim = new Minim(this);
// ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
// ap.play();
// ab = ap.mix;

// background(0);
// stars = new Star[800];
// for (int i = 0; i < stars.length; i++) {
// stars[i] = new Star();
// }
// }

// public void draw() {
// background(0);
// translate(width / 2, height / 2);

// float volume = ap.mix.level(); // Get the current amplitude

// // Draw the sun
// fill(255, 255, 0);
// noStroke();
// ellipse(0, 0, sunRadius, sunRadius);

// // Draw the sound waves around the sun
// float waveRadius = sunRadius + volume * 200; // Increase the radius of the
// waves based on the current amplitude
// stroke(255, 255, 0, 100);
// noFill();
// strokeWeight(2);
// for (float i = 0; i < TWO_PI; i += 0.1) {
// float x = cos(i) * waveRadius;
// float y = sin(i) * waveRadius;
// ellipse(x, y, 20, 20);
// }

// for (Star s : stars) {
// s.update(volume);
// s.show();
// }
// }

// class Star {

// float x, y, z;
// float px, py, pz;

// Star() {
// x = random(-width / 2, width / 2);
// y = random(-height / 2, height / 2);
// z = random(width / 2);
// pz = z;
// }

// void update(float volume) {
// z = z - 10 - volume * 100;
// if (z < 1) {
// z = width / 2;
// x = random(-width / 2, width / 2);
// y = random(-height / 2, height / 2);
// pz = z;
// }
// }

// void show() {
// float sx = map(x / z, 0, 1, 0, width);
// float sy = map(y / z, 0, 1, 0, height);
// float r = map(z, 0, width / 2, 16, 0);

// ellipse(sx / 2, sy / 2, r / 2, r / 2);

// float px = map(x / pz, 0, 1, 0, width);
// float py = map(y / pz, 0, 1, 0, height);

// stroke(255, 128);

// line(sx, sy, px, py);

// px = sx;
// py = sy;
// pz = z;
// }

// }

// }

// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;

// public class StarField extends PApplet {

//     Star[] stars;

//     Minim minim;
//     AudioPlayer ap;
//     AudioInput ai;
//     AudioBuffer ab;

//     public void settings() {
//         size(1024, 1000, P3D);
//     }

//     public void setup() {
//         minim = new Minim(this);
//         ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
//         ap.play();
//         ab = ap.mix;

//         background(0);
//         stars = new Star[800];
//         for (int i = 0; i < stars.length; i++) {
//             stars[i] = new Star();
//         }
//     }

//     public void draw() {
//         background(0);
//         translate(width / 2, height / 2);

//         float volume = ap.mix.level(); // Get the current amplitude

//         for (Star s : stars) {
//             s.update(volume);
//             s.show();
//         }
//     }

//     class Star {

//         float x, y, z;
//         float px, py, pz;

//         Star() {
//             x = random(-width / 2, width / 2);
//             y = random(-height / 2, height / 2);
//             z = random(width / 2);
//             pz = z;
//         }

//         void update(float volume) {
//             z = z - 2 - volume * 100;
//             if (z < 1) {
//                 z = width / 2;
//                 x = random(-width / 2, width / 2);
//                 y = random(-height / 2, height / 2);
//                 pz = z;
//             }
//         }

//         void show() {
//             float sx = map(x / z, 0, 1, 0, width);
//             float sy = map(y / z, 0, 1, 0, height);
//             float r = map(z, 0, width / 2, 16, 0);

//             ellipse(sx / 2, sy / 2, r / 2, r / 2);

//             float px = map(x / pz, 0, 1, 0, width);
//             float py = map(y / pz, 0, 1, 0, height);

//             stroke(255, 128);

//             line(sx, sy, px, py);

//             px = sx;
//             py = sy;
//             pz = z;
//         }

//     }

// }

// package ie.tudublin;

// import processing.core.PApplet;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;

// public class StarField extends PApplet {

//     Star[] stars;

//     Minim minim;
//     AudioPlayer ap;
//     AudioInput ai;
//     AudioBuffer ab;

//     // Define a variable to hold the angle of rotation
//     float angle = 0;

//     // Define a variable to hold the size of the squares
//     float squareSize = 100;

//     // Draw rotating squares in the middle of the screen
//     void drawSquares() {
//         pushMatrix();
//         translate(0, 0, -width / 4);
//         rotateY(angle);
    
//         float volume = ap.mix.level(); // Get the current amplitude
    
//         float squareSize = map(volume, 0, 1, 100, 500); // Map the amplitude to a size for the square
    
//         fill(255, 128);
//         rect(-squareSize / 2, -squareSize / 2, squareSize, squareSize);
//         popMatrix();
//     }
    

//     public void settings() {
//         size(1024, 1000, P3D);
//     }

//     public void setup() {
//         minim = new Minim(this);
//         ap = minim.loadFile("java_bin_starryeyed.mp3", 2048);
//         ap.play();
//         ab = ap.mix;

//         background(0);
//         stars = new Star[800];
//         for (int i = 0; i < stars.length; i++) {
//             stars[i] = new Star();
//         }
//     }

//     public void draw() {
//         background(0);
//         translate(width / 2, height / 2);

//         float volume = ap.mix.level(); // Get the current amplitude

//         for (Star s : stars) {
//             s.update(volume);
//             s.show();
//         }

//         drawSquares(); // Draw the rotating squares
//         angle += 0.01; // Increment the angle of rotation
//     }

//     class Star {

//         float x, y, z;
//         float px, py, pz;

//         Star() {
//             x = random(-width / 2, width / 2);
//             y = random(-height / 2, height / 2);
//             z = random(width / 2);
//             pz = z;
//         }

//         void update(float volume) {
//             z = z - 2 - volume * 100;
//             if (z < 1) {
//                 z = width / 2;
//                 x = random(-width / 2, width / 2);
//                 y = random(-height / 2, height / 2);
//                 pz = z;
//             }
//         }

//         void show() {
//             float sx = map(x / z, 0, 1, 0, width);
//             float sy = map(y / z, 0, 1, 0, height);
//             float r = map(z, 0, width / 2, 16, 0);

//             ellipse(sx / 2, sy / 2, r / 2, r / 2);

//             float px = map(x / pz, 0, 1, 0, width);
//             float py = map(y / pz, 0, 1, 0, height);

//             stroke(255, 128);

//             line(sx, sy, px, py);

//             px = sx;
//             py = sy;
//             pz = z;
//         }

//     }
// }
package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class StarField extends PApplet {

    Star[] stars;

    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    float lerpedBuffer[] = new float[1024];
    float smoothedAmplitude = 0;

    public void settings() {
        size(1920, 1080, P3D);
    }

    public void setup() {
        minim = new Minim(this);
        ap = minim.loadFile("java_bin_starryeyed.mp3", 1024);
        ap.play();
        ab = ap.mix;

        background(0);
        stars = new Star[800];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void draw() {
        background(0);
        translate(width / 2, height / 2);

        beginShape();
        fill(255);
        float volume = ap.mix.level(); // Get the current amplitude
        for (Star s : stars) {
            s.update(volume);
            s.show();
        }
        endShape();

        float average = 0;
        float sum = 0;;

        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));

            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        beginShape();
        noFill();
        for (int i = 0; i < ab.size(); i++) {
            float c = map(i, 0, ab.size(), 0, 255);

            stroke(c, 255, 255);

            float f = lerpedBuffer[i] * 400;

            float angle = map(i, 0, ab.size(), 0, TWO_PI);

            float x = cos(angle) * (250 + f);

            float y = sin(angle) * (250 + f);

            vertex(x, y);
        }
        endShape();

        // draw a sphere
        beginShape();
        pushMatrix();
        rotateX(frameCount * 0.01f);
        rotateY(frameCount * 0.01f);
        noFill();
        sphere(200);
        popMatrix();
        endShape();
    }

    class Star {

        float x, y, z;
        float px, py, pz;

        Star() {
            x = random(-width / 2, width / 2);
            y = random(-height / 2, height / 2);
            z = random(width / 2);
            pz = z;
        }

        void update(float volume) {
            z = z - 2 - volume * 100;
            if (z < 1) {
                z = width / 2;
                x = random(-width / 2, width / 2);
                y = random(-height / 2, height / 2);
                pz = z;
            }
        }

        void show() {
            float sx = map(x / z, 0, 1, 0, width);
            float sy = map(y / z, 0, 1, 0, height);
            float r = map(z, 0, width / 2, 16, 0);

            ellipse(sx / 2, sy / 2, r / 2, r / 2);

            float px = map(x / pz, 0, 1, 0, width);
            float py = map(y / pz, 0, 1, 0, height);

            stroke(255, 128);

            line(sx, sy, px, py);

            px = sx;
            py = sy;
            pz = z;
        }

    }

}