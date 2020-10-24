package com.example.rainbow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import static java.util.Calendar.*;

public class MainActivity extends AppCompatActivity implements OnDateSelectedListener {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    private final Calendar calendar = Calendar.getInstance();
    MaterialCalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        calendarView = (MaterialCalendarView) findViewById((R.id.calendarView));

        //날짜 한 개만 클릭 가능
        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_SINGLE);

        calendarView.setClickable(true);
        // 오늘 날짜 하이라이트표시
        calendarView.setSelectedDate(CalendarDay.today());
        // 날짜 클릭 시, 함수 실행
        calendarView.setOnDateChangedListener(this);


        Calendar mon = getInstance();
        mon.add(MONTH, -1);
        String beforeMonth = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
        // 설정
        calendarView.state().edit()
                // 주의 시작을 일요일
                .setFirstDayOfWeek(SUNDAY)
                // 캘린더의 범위 설정
                .setMinimumDate(mon)
                .setMaximumDate(CalendarDay.today())
                //Months로 볼 건지, Weeks로 볼 건지 결정
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        // SundayDecorator는 일요일에 지정색
        // oneDayDecorator는 오늘 날짜에 지정색
        calendarView.addDecorators(
                new SundayDecorator(),
                oneDayDecorator);

        //디비: dot 표시할 날짜 지정
        String[] result = {"2020,09,18","2020,09,20","2020,10,2","2020,10,11"};

        new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());


    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        String[] Time_Result;

        ApiSimulator(String[] Time_Result){
            this.Time_Result = Time_Result;
        }

        // 점을 어떤 규칙으로 찍을
        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //현재 캘린더 불러오기
            Calendar calendar = Calendar.getInstance();
            //점을 찍을 day
            ArrayList<CalendarDay> dates = new ArrayList<>();

            /*특정날짜 달력에 점표시해주는곳*/
            /*월은 0이 1월 년,일은 그대로*/
            //string 문자열인 Time_Result 을 받아와서 ,를 기준으로짜르고 string을 int 로 변환
            for(int i = 0 ; i < Time_Result.length ; i ++){
                CalendarDay day = CalendarDay.from(calendar);
                String[] time = Time_Result[i].split(",");
                int year = Integer.parseInt(time[0]);
                int month = Integer.parseInt(time[1]);
                int dayy = Integer.parseInt(time[2]);

                dates.add(day);
                calendar.set(year,month-1,dayy);
            }

            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

            calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays));

            /* 1안..... 무지개 닷 꼭 할거야.....
            for(int i =0; i< calendarDays.size();i++) {
                calendarView.addDecorator(new SundayDotDecorator(Color.RED, calendarDays.get(i)));
                calendarView.addDecorator(new MondayDotDecorator(Color.RED, calendarDays.get(i)));
                calendarView.addDecorator(new TuesdayDotDecorator(Color.YELLOW, calendarDays.get(i)));
                calendarView.addDecorator(new WednesdayDotDecorator(Color.GREEN, calendarDays.get(i)));
                calendarView.addDecorator(new ThursdayDotDecorator(Color.CYAN, calendarDays.get(i)));
                calendarView.addDecorator(new FridayDotDecorator(Color.BLUE, calendarDays.get(i)));
                calendarView.addDecorator(new SaturdayDotDecorator(Color.RED, calendarDays.get(i)));

            }
             */
                /* 2안....
            for(int i =0; i< calendarDays.size();i++){
                int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
                if (weekDay == Calendar.SUNDAY) {
                    calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays.get(i)));
                } else if (weekDay == Calendar.MONDAY) {
                    // 주황색으로 바꿔야함
                    calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays.get(i)));
                } else if (weekDay == Calendar.TUESDAY) {
                    calendarView.addDecorator(new EventDecorator(Color.YELLOW, calendarDays.get(i)));
                } else if (weekDay == Calendar.WEDNESDAY) {
                    calendarView.addDecorator(new EventDecorator(Color.GREEN, calendarDays.get(i)));
                } else if (weekDay == Calendar.THURSDAY) {
                    calendarView.addDecorator(new EventDecorator(Color.CYAN, calendarDays.get(i)));
                } else if (weekDay == Calendar.FRIDAY) {
                    calendarView.addDecorator(new EventDecorator(Color.BLUE, calendarDays.get(i)));
                } else {
                    // 보라색으로 바꿔야
                    calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays.get(i)));
                }

            }*/
        }
    }


    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        /* 날짜 클릭 시 Toast 띄우기
        //selected is no value on logcat
        Log.d("selected", "" + selected);
        //It can't be show
        Toast.makeText(this, "enterDateSelected" + date, Toast.LENGTH_SHORT).show();

        if (selected == true) {
            //It can't be show
            Toast.makeText(this, "onClick" + date, Toast.LENGTH_SHORT).show();
        }
        */
        // 일자 페이지로 이동
        Intent intent = new Intent(this, date_study.class);

        // 날짜 넘기기
        String strday = date.toString();
        intent.putExtra("Date", strday);

        // 이동
        startActivity(intent);
    }

    // 설정 버튼 만들기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // 설정 눌렀을 때 시간 설정 페이지로 이동
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_btn1:
                Intent intent = new Intent(this, setting_time.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v){
        Intent intent = new Intent(MainActivity.this,weekofRainbow.class);
        startActivity(intent);
    }

}