package com.example.rainbow;

public class PostItem {


    private String date;
    private int time;
    private int goal;
    private int detectTime;

    // achievement가 1인가 0인가
    private int IsAchieved;

    private String[] achievementList;
    private int[] estimation;

    public String get_date()
    {
        return date;
    }
    public int get_time()
    {
        return time;
    }
    public int get_goal()
    {
        return goal;
    }
    public int get_detectTime()
    {
        return detectTime;
    }
    public int get_IsAchieved()
    {
        return IsAchieved;
    }

    public String[] get_achievementList()
    {
        return achievementList;
    }
    public int[] get_estimation()
    {
        return estimation;
    }

    public void set_date(String s)
    {
        date = s;
    }
    public void set_time(int t)
    {
        time = t;
    }
    public void set_goal(int g)
    {
        goal =g;
    }
    public void set_detectTime(int d)
    {
        detectTime =d;
    }
    public void set_IsAchieved(int i)
    {
        IsAchieved = i;
    }

    public void set_achievementList(String[] a)
    {
        achievementList =a;
    }

    public void set_estimation(int[] e)
    {
        estimation = e;
    }

}