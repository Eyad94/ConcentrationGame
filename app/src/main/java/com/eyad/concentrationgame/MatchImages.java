package com.eyad.concentrationgame;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MatchImages {
    private Main3Activity main3Activity;
    private int size;
    private int flag = 1;
    private int first_img;
    private int second_img;
    private int first_id;
    private int current_id;
    private int count_success = 0;
    private int[] arr_images;

    public MatchImages(Main3Activity main3Activity, int size){
        this.main3Activity = main3Activity;
        this.size = size;
        this.arr_images = new int[this.size];
        this.arr_images = random_images(this.size);
    }

    public int num_image(int num){
        return this.arr_images[num - 1];
    }

    public int backgroundButton(int num_image){
        switch (num_image) {
            case 1:
                return R.drawable.img_1;
            case 2:
                return R.drawable.img_2;
            case 3:
                return R.drawable.img_3;
            case 4:
                return R.drawable.img_4;
            case 5:
                return R.drawable.img_5;
            case 6:
                return R.drawable.img_6;
            case 7:
                return R.drawable.img_7;
            case 8:
                return R.drawable.img_8;
            case 9:
                return R.drawable.img_9;
            case 10:
                return R.drawable.img_10;
            case 11:
                return R.drawable.img_11;
            case 12:
                return R.drawable.img_12;
            case 13:
                return R.drawable.img_13;
            case 14:
                return R.drawable.img_14;
            case 15:
                return R.drawable.img_15;
            case 16:
                return R.drawable.img_16;
            case 17:
                return R.drawable.img_17;
            case 18:
                return R.drawable.img_18;
            case 19:
                return R.drawable.img_19;
            case 20:
                return R.drawable.img_20;
            case 21:
                return R.drawable.img_21;
            case 22:
                return R.drawable.img_22;
            case 23:
                return R.drawable.img_23;
            case 24:
                return R.drawable.img_24;
            case 25:
                return R.drawable.img_25;
        }
        return R.drawable.background;
    }

    public void match_images(int index, int id){
        current_id = id;
        flag = flag * (-1);
        if(flag == 1) {
            second_img = num_image(index);
            ((Button)main3Activity.findViewById(current_id)).setBackgroundResource(backgroundButton(second_img));

            if (first_img != second_img) {
                ((Button)main3Activity.findViewById(id)).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((Button)main3Activity.findViewById(current_id)).setBackgroundResource(R.drawable.background);
                        ((Button)main3Activity.findViewById(first_id)).setBackgroundResource(R.drawable.background);
                    }
                }, 1000);
            }
            else {
                count_success++;
                if(count_success == this.size/2) {
                    Toast.makeText(main3Activity.getApplicationContext(), "Excellent!!!", Toast.LENGTH_SHORT).show();
                    main3Activity.finish();
                }
            }
        }
        else{
            first_img = num_image(index);
            first_id = current_id;
            ((Button)main3Activity.findViewById(first_id)).setBackgroundResource(backgroundButton(first_img));
        }
    }

    public int[] random_images(int size){
        Random rand = new Random();
        int [] arr_indicator = new int[size];
        int [] arr_images = new int[size];
        int count = 1;
        int num1, num2;

        for(int i=0; i<size/2; i++) {
            num1 = rand.nextInt(size);
            num2 = rand.nextInt(size);

            while (arr_indicator[num1] == 1 || num1 == num2)
                num1 = rand.nextInt(size);

            while (arr_indicator[num2] == 1 || num1 == num2)
                num2 = rand.nextInt(size);

            arr_indicator[num1] = 1;
            arr_indicator[num2] = 1;
            arr_images[num1] = count;
            arr_images[num2] = count;
            count++;
        }
        return arr_images;
    }

    public void buttonPress(View v) {
        int index = -1;
        switch (v.getId()) {
            case R.id.btn_img1:
                index = 1;
                break;
            case R.id.btn_img2:
                index = 2;
                break;
            case R.id.btn_img3:
                index = 3;
                break;
            case R.id.btn_img4:
                index = 4;
                break;
            case R.id.btn_img5:
                index = 5;
                break;
            case R.id.btn_img6:
                index = 6;
                break;
            case R.id.btn_img7:
                index = 7;
                break;
            case R.id.btn_img8:
                index = 8;
                break;
            case R.id.btn_img9:
                index = 9;
                break;
            case R.id.btn_img10:
                index = 10;
                break;
            case R.id.btn_img11:
                index = 11;
                break;
            case R.id.btn_img12:
                index = 12;
                break;
            case R.id.btn_img13:
                index = 13;
                break;
            case R.id.btn_img14:
                index = 14;
                break;
            case R.id.btn_img15:
                index = 15;
                break;
            case R.id.btn_img16:
                index = 16;
                break;
            case R.id.btn_img17:
                index = 17;
                break;
            case R.id.btn_img18:
                index = 18;
                break;
            case R.id.btn_img19:
                index = 19;
                break;
            case R.id.btn_img20:
                index = 20;
                break;
            case R.id.btn_img21:
                index = 21;
                break;
            case R.id.btn_img22:
                index = 22;
                break;
            case R.id.btn_img23:
                index = 23;
                break;
            case R.id.btn_img24:
                index = 24;
                break;
            case R.id.btn_img25:
                index = 25;
                break;
        }
        match_images(index, v.getId());
    }
}
