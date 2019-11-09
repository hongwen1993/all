package com.kagura;

import com.drools.core.KieTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.event.rule.*;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/8
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    public static volatile AtomicInteger RIGHT = new AtomicInteger(0);
    public static volatile AtomicInteger COUNT = new AtomicInteger(0);

    @Autowired
    private KieTemplate kieTemplate;

    @Before
    public void before() throws InterruptedException {
        Thread.sleep(1500);
    }

    @Test
    public void test01() {
        KieSession kieSession = kieTemplate.getKieSession("rule1.drl");
        kieSession.addEventListener(new DefaultRuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                System.err.println("监听到插入数据");
                System.err.println("Object : " + event.getObject());
                System.err.println("Fact : " + event.getFactHandle());
                COUNT.incrementAndGet();
            }
        });

        // 该监听，只能监听到匹配的对象的事件。
        kieSession.addEventListener(new DefaultAgendaEventListener() {
            @Override
            public void matchCreated(MatchCreatedEvent event) {
                System.err.println("matchCreated");
            }

            @Override
            public void beforeMatchFired(BeforeMatchFiredEvent event) {
                System.err.println("beforeMatchFired");
            }

            @Override
            public void afterMatchFired(AfterMatchFiredEvent event) {
                System.err.println("afterMatchFired");
                System.err.println("........");
            }
        });

        kieSession.setGlobal("RIGHT", RIGHT);
        kieSession.insert("QTO");
        kieSession.insert("CTO");
        kieSession.fireAllRules();
        System.err.println("RIGHT : " + RIGHT.get());
        System.err.println("COUNT : " + COUNT.get());
    }

}
