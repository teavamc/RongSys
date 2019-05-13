package com.ruoyi.redis;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;
/**
 * redis CAS乐观锁
 * @author 周博
 * @date 2019-5-12
 *
 */
public class RedisWatchLock {
    public static final String redisHost = "127.0.0.1";
    public static final String redisPassword = "123456";
    public static final String redisSocketSet = "chat";
    public static final String redisNumber = "chatNumber";

    private static final int port = 6379;

    private static JedisPoolConfig config;

    public static JedisPool pool;

    private static ExecutorService service;

    private static int ThLeng=10;

    private static CountDownLatch latch;

    private static AtomicInteger Countor = new AtomicInteger(0);
    static{
        //利用Redis连接池，保证多个线程利用多个连接，充分模拟并发性
        config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxWaitMillis(1000);
        config.setMaxTotal(30);
        pool = new JedisPool(config, redisHost, port);
        //利用ExecutorService 管理线程
        service = Executors.newFixedThreadPool(10);
        //CountDownLatch保证主线程在全部线程结束之后退出
        latch = new CountDownLatch(ThLeng);
    }

    public static void main(String args[]){
        int ThLeng = 10;
        String ThreadNamePrefix = "thread-";
        Jedis cli = pool.getResource();
        cli.auth(redisPassword);
        cli.del("redis_inc_key");//先删除既定的key
        cli.set("redis_inc_key", String.valueOf(1));//设定默认值
        for(int i =0;i<ThLeng;i++){
            Thread th = new Thread(new TestThread(pool));
            th.setName(ThreadNamePrefix+i);
            System.out.println(th.getName()+"inited...");
            service.submit(th);
        }
        service.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all sub thread sucess");
        System.out.println("countor is "+Countor.get());
        String countStr = cli.get("redis_inc_key");
        System.out.println(countStr);
    }

    public static class TestThread implements Runnable {
        private String incKeyStr = "redis_inc_key";
        private Jedis cli;
        private JedisPool pool;
        public TestThread(JedisPool pool) {
            cli = pool.getResource();
            this.pool = pool;

        }
        public void run() {
            try{

                for (int i = 0; i < 100; i++) {
                    actomicAdd();
                }
            }catch(Exception e){
                pool.returnBrokenResource(cli);
            }
            finally{
                pool.returnResource(cli);
                latch.countDown();
            }
        }

        public void actomicAdd(){
            boolean flag =true;
            while(flag){
                cli.watch(incKeyStr);
                String countStr = cli.get("redis_inc_key");
                int countInt = Integer.parseInt(countStr);
                int expect = countInt+1;
                Transaction tx = cli.multi();
                tx.set(incKeyStr, String.valueOf(expect));
                List<Object> list = tx.exec();
                //如果事务失败了exec会返回null
                if(list==null){
                    System.out.println("multi shut down");
                    continue;
                }
                else{
                    //如果达到期望值那么结束while循环
                    flag=false;
                }
                System.out.println("my expect num is "+expect);
                System.out.println("seting....");
            }
            Countor.incrementAndGet();
        }

    }

}