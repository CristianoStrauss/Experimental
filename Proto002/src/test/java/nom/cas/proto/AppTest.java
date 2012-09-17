package nom.cas.proto;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.perf4j.log4j.Log4JStopWatch;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    private static Logger log = Logger.getLogger(App.class);

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        Log4JStopWatch watch = new Log4JStopWatch(log);
        PoolingClientConnectionManager pool = new PoolingClientConnectionManager();
        pool.setDefaultMaxPerRoute(20);
        final HttpClient httpClient = new DefaultHttpClient(pool);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ArrayList<FutureTask<Object>> futureTasks = new ArrayList<FutureTask<Object>>();
//        futureTasks.add(new FutureTask<Object>());
//        forkJoinPool.invokeAll(args)
        ThreadGroup threadGroup = new ThreadGroup("http-test");
        watch.start(Thread.currentThread().getName());
        int maxCount = 30;
        for (int i = 0; i < maxCount; i++) {
            final int count = i;
            new Thread(threadGroup, new Runnable() {
                public void run() {
                    NDC.push(Thread.currentThread().getName());
                    HttpGet httpGet = null;
                    Log4JStopWatch watch = new Log4JStopWatch(log);
                    watch.start(Thread.currentThread().getName());
                    try {
                        if (count <= 6) {
                            Thread.sleep(250);
//                        } else if (count >= 20) {
//                            Thread.sleep(500);
                        } else {
                            Thread.sleep(8000);
                        }

                        if (count <= 6) {
                            httpGet = new HttpGet("http://localhost:8084/Proto004/test?id="+Thread.currentThread().getName()+"&block=5000&sendTime="+Calendar.getInstance().getTimeInMillis());
//                        } else if (count >= 20) {
//                            httpGet = new HttpGet("http://localhost:8084/Proto004/test?id="+Thread.currentThread().getName()+"&block=8000&sendTime="+Calendar.getInstance().getTimeInMillis());
                        } else {
//                            httpGet = new HttpGet("http://localhost:8084/Proto004/test?id="+Thread.currentThread().getName()+"&block="+(count*250)+"&sendTime="+Calendar.getInstance().getTimeInMillis());
                            httpGet = new HttpGet("http://localhost:8084/Proto004/test?id="+Thread.currentThread().getName()+"&block=250&sendTime="+Calendar.getInstance().getTimeInMillis());
                        }

                        log.debug("-----------------");
                        
                        HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
                        HttpEntity entity = response.getEntity();
                        log.debug(EntityUtils.toString(entity));
                        log.debug("Final Response Time:"+String.format("%1$tH:%1$tM:%1$tS,%1$tL", Calendar.getInstance().getTime()));
                        EntityUtils.consume(entity);
                    } catch (Exception e) {
                        httpGet.abort();
                        log.error(e);
                    }
                    watch.stop();
                }
            }, "thread-" + i).start();
        }

        try {
            while (threadGroup.activeCount() > 1) {
                Thread.currentThread().sleep(2000);
            }
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        watch.stop();
        System.out.println("Hello World!");
    }
}
