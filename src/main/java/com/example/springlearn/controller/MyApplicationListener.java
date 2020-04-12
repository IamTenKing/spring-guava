package com.example.springlearn.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author jt
 * @date 2020-4-4
 *
 * spring容器监听事件，通过监听容器的发布事件进行扩展操作
 *
 * 父容器Root WebApplicationContext 最先启动,启动后执行扩展的消息事件
 *
 * 2020-04-04 14:57:16.949  INFO 4452 --- [  restartedMain] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2217 ms
 * 2020-04-04 14:57:17.203  INFO 4452 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
 * 2020-04-04 14:57:17.365  INFO 4452 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
 * ContextRefreshedEvent事件监听器执行了。。。。。。。
 */

@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        int andIncrement = ShareData.getInstance().getNum().getAndIncrement();
        System.out.println("MyApplicationListener"+andIncrement);


        ApplicationContext applicationContext = event.getApplicationContext();
        System.out.println(event.getApplicationContext().getDisplayName());
        System.out.println(event.getApplicationContext().getParent());
        System.out.println(event.getApplicationContext().getParentBeanFactory());

        System.out.println("ContextRefreshedEvent事件监听器执行了。。。。。。。");


    }
}
