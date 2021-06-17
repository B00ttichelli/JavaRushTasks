package com.javarush.task.task14.task1409;

public interface Bridge {

   default int getCarsCount(){
        return 10;
    }
}
