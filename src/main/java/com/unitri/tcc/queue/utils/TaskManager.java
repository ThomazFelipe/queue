package com.unitri.tcc.queue.utils;

import java.util.TimerTask;
import java.util.function.Function;

public class TaskManager extends TimerTask {

    private Function<Object, Object> function;
    private Object object;

    public TaskManager(Function<Object, Object> function, Object object){
        this.function = function;
        this.object = object;
    }

    @Override
    public void run() {
        function.apply(object);
    }
}
