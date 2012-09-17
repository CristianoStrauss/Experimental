package nom.cas.proto;

import java.util.ArrayList;
import java.util.concurrent.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.perf4j.log4j.Log4JStopWatch;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) throws InterruptedException {
        PoolingClientConnectionManager pool = new PoolingClientConnectionManager();
        final HttpClient httpClient = new DefaultHttpClient();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ArrayList<FutureTask<Object>> futureTasks = new ArrayList<FutureTask<Object>>();
//        futureTasks.add(new FutureTask<Object>());
//        forkJoinPool.invokeAll(args)
        ThreadGroup threadGroup = new ThreadGroup("http-test");
        for (int i = 0; i < 30; i++) {
            new Thread(threadGroup, new Runnable() {
                public void run() {
                    HttpGet httpGet = null;
                    Log4JStopWatch watch = new Log4JStopWatch(log);
                    watch.start();
                    try {
                        httpGet = new HttpGet("http://www.terra.com.br/");
                        HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
                        HttpEntity entity = response.getEntity();
                        EntityUtils.consume(entity);
                    } catch (Exception e) {
                        httpGet.abort();
                    }
                    watch.stop();
                }
            }, "thread-" + i).start();
        }

        while(threadGroup.activeCount() > 1) {
            Thread.currentThread().sleep(2000);
        }
        System.out.println("Hello World!");
    }
}
