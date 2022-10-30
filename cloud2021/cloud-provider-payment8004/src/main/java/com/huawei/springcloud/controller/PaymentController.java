package com.huawei.springcloud.controller;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: csx
 * @Date: 2022/10/17 22:24
 * @Description:
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    private ZooKeeper zkclient;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
    @Before
    public void init() throws IOException {
        String connectString = "192.168.248.6:2181,192.168.248.7:2181,192.168.248.8:2181";
        int sessionTimeout = 2000;
        zkclient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkclient.getChildren("/", true);
                    children.forEach(System.out::println);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void creater() throws KeeperException, InterruptedException {
        String nodeCreated = zkclient.create("/sanguo", "weiguo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkclient.getChildren("/", true);
        children.forEach(System.out::println);
    }
}
