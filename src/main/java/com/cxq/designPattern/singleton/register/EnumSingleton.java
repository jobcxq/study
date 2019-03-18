package com.cxq.designPattern.singleton.register;

/**
 * 枚举单例
 */
public enum EnumSingleton {
    INSTANCE;

    //实现拓展
    private Object data;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
