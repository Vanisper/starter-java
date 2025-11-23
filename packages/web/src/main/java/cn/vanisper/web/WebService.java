package cn.vanisper.web;

import cn.vanisper.core.Test;

/**
 * Web 服务示例类，展示如何引用 core 模块
 */
public class WebService {
    
    public void startWebServer() {
        System.out.println("[Web] Starting web server...");
        
        // 调用 core 模块的功能
        System.out.println("[Web] Using core module functionality:");
        Test.main(new String[]{});
        
        System.out.println("[Web] Web server started successfully!");
    }
    
    public static void main(String[] args) {
        WebService webService = new WebService();
        webService.startWebServer();
    }
}
