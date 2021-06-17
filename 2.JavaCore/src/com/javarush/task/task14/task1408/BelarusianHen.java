package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{



    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.BELARUS, getCountOfEggsPerMonth());

    }
}
