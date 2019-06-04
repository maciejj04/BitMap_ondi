package com.example.myapplication;

import java.util.Random;

class RandomCoordinatesFactory {
    private Random random = new Random();
    
    RandomCoordiates get(int width, int height){
        int left = random.nextInt(width);
        int top = random.nextInt(height);

        return new RandomCoordiates(
                left,
                random.nextInt(width - left) + left,
                top,
                random.nextInt(height - top) + top
        );
    }

    int nextInt() {
        return random.nextInt();
    }

}
