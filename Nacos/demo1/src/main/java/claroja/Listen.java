package claroja;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class Listen {
    public static void main(String[] args) throws NacosException {

        // 根据serverAddr和namespace定位到configService
        Properties properties =new Properties();
        properties.put("serverAddr","127.0.0.1:8848");
        properties.put("namespace","110d0329-95b6-43a7-9401-0fc6405a960e");
        ConfigService configService = NacosFactory.createConfigService(properties);

        //监听, 当配置文件发生变化时, 回调
        String dataId = "newconfig";
        String group = "DEFAULT_GROUP";
        configService.addListener(dataId, group, new Listener() {
            public Executor getExecutor() {
                return null;
            }
            //当配置有变化 时候获取通知
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });

        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
