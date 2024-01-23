package ch19.practice;

import java.util.TimerTask;

public class MyTask extends TimerTask
{
    public void run()
    {
        System.out.println("데이터를 저장중입니다 . . .");
    }
}