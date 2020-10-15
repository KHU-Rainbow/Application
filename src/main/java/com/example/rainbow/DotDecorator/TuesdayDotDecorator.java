package com.example.rainbow.DotDecorator;

import android.graphics.Color;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Calendar;

public class TuesdayDotDecorator implements DayViewDecorator {
    private final Calendar calendar = Calendar.getInstance();

    private int color;
    private CalendarDay dates;

    public TuesdayDotDecorator(int color, CalendarDay date) {
        this.color = color;
        this.dates = dates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay == Calendar.TUESDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(7, color)); // 날자밑에 점
    }
}