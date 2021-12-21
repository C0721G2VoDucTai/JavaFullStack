package _23_behavioral.practice.observer;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
