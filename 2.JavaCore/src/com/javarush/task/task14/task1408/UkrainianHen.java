package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 12;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.UKRAINE, getCountOfEggsPerMonth());

    }
}
