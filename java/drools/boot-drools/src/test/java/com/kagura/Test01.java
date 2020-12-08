package com.kagura;


import com.drools.core.KieTemplate;
import com.kagura.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(Test01.class);

    // 1.注入KieTemplate
    @Autowired
    private KieTemplate kieTemplate;


    // 2.获取指定的规则文件，生成KieSession
    @Test
    public void test01() {
        KieSession session = kieTemplate.getKieSession("rule.drl");
        Person person = new Person();
        person.setName("王五");
        //session.setGlobal("isEnable", true);
        session.setGlobal("log", logger);
        session.insert(person);
        session.fireAllRules();
        logger.info("person=>{}", person);
    }



}
