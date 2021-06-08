package claroja;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
public class GetConfig {
    public static void main(String[] args) throws NacosException {

        // 根据serverAddr和namespace定位到configService
        Properties properties =new Properties();
        properties.put("serverAddr","127.0.0.1:8848");
        properties.put("namespace","110d0329-95b6-43a7-9401-0fc6405a960e");
        ConfigService configService = NacosFactory.createConfigService(properties);

        // 根据group 和 dataId 定位到具体的配置文件
        String dataId = "newconfig";
        String group = "DEFAULT_GROUP";
        String config = configService.getConfig(dataId, group, 5000);
        System.out.println(config);

    }
}
