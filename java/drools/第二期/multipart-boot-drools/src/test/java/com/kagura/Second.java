package com.kagura;


import com.drools.core.KieTemplate;
import com.kagura.entity.UserInfo;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/30
 * @since 1.0.0
 */
public class Second extends Base{

    @Autowired
    private KieTemplate kieTemplate;

    private KieSession kieSession;

    private Object object;

    // @Before => @Test => @After
    @Before
    public void before() throws InterruptedException {
        Thread.sleep(1000);
        this.kieSession = kieTemplate.getKieSession("rule.drl");
    }

    @Test
    public void test01() {
        object = 1d;
    }

    @After
    public void after() {
        kieSession.insert(object);
        kieSession.fireAllRules();
    }





    @Test
    public void test02() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张");
        //userInfo.setAge(20);
        object = userInfo;
    }


    @Test
    public void test03() {
        UserInfo info = new UserInfo();
        info.setInterests(Lists.newArrayList("tea", "coffee"));
        //info.setInterests(Lists.newArrayList("coffee", "tea"));
        object  = info;
    }

    @Test
    public void test04() {
        UserInfo info = new UserInfo();
        Map<String, String> map = new HashMap<>();
        map.put("job", "se");
        info.setTags(map);
        object  = info;
    }

    @Test
    public void test05() {
        UserInfo info = new UserInfo();
        info.setInterests(Lists.newArrayList("tea1", "coffee"));
        //info.setInterests(Lists.newArrayList("coffee", "tea"));
        object  = info;
    }

    @Test
    public void test06() {
        UserInfo info = new UserInfo();
        info.setInterests(Lists.newArrayList("tea", "coffee"));
        //info.setInterests(Lists.newArrayList("coffee", "tea"));
        object  = info;
    }

    @Test
    public void test07() {
        UserInfo info = new UserInfo();
        info.setName("TonyKara");
        object  = info;
    }

    @Test
    public void test08() {
        UserInfo info = new UserInfo();
        info.setInterests(Lists.newArrayList("tea1", "coffee"));
        //info.setInterests(Lists.newArrayList("coffee", "tea"));
        object  = info;
    }

}
