package test;

import com.neuedu.App;
import com.neuedu.pojo.Imgbytes;
import com.neuedu.service.IImgbytesService;
import org.apache.commons.io.FileUtils;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)
public class MyTest {
    @Resource
    StringEncryptor encryptor;
    @Test
    public void test(){

    }
}
