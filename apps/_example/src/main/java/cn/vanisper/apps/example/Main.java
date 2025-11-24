package cn.vanisper.apps.example;

import cn.vanisper.core.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("[app-example] Hello, i am an app-example!");

        // 调用 core 模块的功能
        System.out.println("[app-example] Using core module functionality:");
        Test.main(new String[]{});

        System.out.println("[app-example] Successfully!");
    }
}
