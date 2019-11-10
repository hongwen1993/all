package com.kagura;


import com.drools.core.KieTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/8
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    // 1.注入KieTemplate
    @Autowired
    private KieTemplate kieTemplate;

    @Before
    public void before() throws InterruptedException {
        Thread.sleep(1000);
    }

    // 2.获取指定的规则文件，生成KieSession
    @Test
    public void test01() {
        KieSession session = kieTemplate.getKieSession("rule.drl");
        session.insert(1d);
        session.fireAllRules();
    }



}
