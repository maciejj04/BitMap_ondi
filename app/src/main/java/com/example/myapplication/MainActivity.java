package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private ImageView image;
    private Bitmap bitmap;
    private Canvas canvas;

    private Paint paint = new Paint();
    private RandomCoordinatesFactory randomCoordinatesFactory = new RandomCoordinatesFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        image = findViewById(R.id.image);
    }

    public void onClickCreate(View v) {
        bitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        setEnabled(R.id.CLEAR_BUTTON, true);
        setEnabled(R.id.RECTANGLE_BUTTON, true);
        setEnabled(R.id.ELIPSES_BUTTON, true);
        setEnabled(R.id.LINES_BUTTON, true);
        setEnabled(R.id.CREATE_BUTTON, false);

        image.setImageBitmap(bitmap); 
        text.setText("Bitmap prepared");
    }

    void setEnabled(int buttonId, boolean value) {
        findViewById(buttonId).setEnabled(value);
    }

    public void onRectangleClick(View v) {
        int width = image.getWidth();
        int height = image.getHeight();

        for(int i = 0; i < 30; i++) {
            drawRandomRectangle(width, height);
        }
        text.setText("30 rectangles added!");
    }

    private void drawRandomRectangle(int width, int height) {
        RandomCoordiates randomCoordiates = randomCoordinatesFactory.get(width, height);
        paint.setColor(randomCoordinatesFactory.nextInt());
        canvas.drawRect(randomCoordiates.getLeft(), randomCoordiates.getTop(), randomCoordiates.getRight(), randomCoordiates.getBottom(), paint);
    }

    public void onElipsesClick(View v) {
        int width = image.getWidth();
        int height = image.getHeight();

        for(int i = 0; i < 30; i++) {
            drawRandomElipse(width, height);
        }
        text.setText("30 elipses added");
    }

    private void drawRandomElipse(int width, int height) {
        RandomCoordiates randomCoordiates = randomCoordinatesFactory.get(width, height);
        paint.setColor(randomCoordinatesFactory.nextInt());
        canvas.drawArc(randomCoordiates.getLeft(), randomCoordiates.getTop(), randomCoordiates.getRight(), randomCoordiates.getBottom(), 0, 360, true, paint);
    }

    public void onLinesClick(View v) {
        int width = image.getWidth();
        int height = image.getHeight();

        for(int i = 0; i < 200; i++) {
            drawRandomLine(width, height);
        }
        text.setText("200 new lines added");
    }
    void drawRandomLine(int width, int height) {
        RandomCoordiates randomCoordiates = randomCoordinatesFactory.get(width, height);
        paint.setColor(randomCoordinatesFactory.nextInt());
        canvas.drawLine(randomCoordiates.getLeft(), randomCoordiates.getTop(), randomCoordiates.getRight(), randomCoordiates.getBottom(), paint);
    }

    public void onClearClick(View v) {
        int width = image.getWidth();
        int height = image.getHeight();

        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, width, height, paint);

        setEnabled(R.id.CLEAR_BUTTON, false);
        setEnabled(R.id.RECTANGLE_BUTTON, false);
        setEnabled(R.id.ELIPSES_BUTTON, false);
        setEnabled(R.id.LINES_BUTTON, false);
        setEnabled(R.id.CREATE_BUTTON, true);

        text.setText("Cleared view");
    }
}
