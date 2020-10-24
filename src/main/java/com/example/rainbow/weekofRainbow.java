package com.example.rainbow;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/* textView id : week_1, week_2...  ImageView id : week_pic_1, week_pic_2....
무지개 : rb_pic7
반무지개 : half_rb_pic4
비 : rain_pic5
기본값 : rb_pic8
변수명 week_rbpic1,...
*/
public class weekofRainbow extends Activity {
    private ImageView week_rbpic1, week_rbpic2, week_rbpic3, week_rbpic4, week_rbpic5;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekofrainbow_page);

        week_rbpic1 = (ImageView)findViewById(R.id.week_pic_1);
        week_rbpic2 = (ImageView)findViewById(R.id.week_pic_2);
        week_rbpic3 = (ImageView)findViewById(R.id.week_pic_3);
        week_rbpic4 = (ImageView)findViewById(R.id.week_pic_4);
        week_rbpic5 = (ImageView)findViewById(R.id.week_pic_5);

        week_rbpic1.setImageResource(R.drawable.rb_pic7);
        week_rbpic2.setImageResource(R.drawable.half_rb_pic4);
        week_rbpic3.setImageResource(R.drawable.rain_pic5);
        week_rbpic4.setImageResource(R.drawable.rb_pic7);
        week_rbpic5.setImageResource(R.drawable.rb_pic8);

    }

}
