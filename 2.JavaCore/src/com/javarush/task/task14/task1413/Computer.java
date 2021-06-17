package com.javarush.task.task14.task1413;

public class Computer {
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Computer(Keyboard keyboard,  Mouse mouse,Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;
    }



    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
