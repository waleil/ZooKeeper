
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.huawei.ClientApplication;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.SecureRandom;
import java.util.Calendar;


/**
 * @Auther: csx
 * @Date: 2022/1/15 22:16
 * @Description:
 */

@SpringBootTest(classes = {ClientApplication.class})
@RunWith(SpringRunner.class)
public class P12CertTest {
  private final static String URL = "https://server.com:8090/server/hello";
  private String pw = "huawei123";
    @Test
    public void getHKVesselTrip() throws Exception {
        //请求 KeyStore 对象PKCS12类型
        KeyStore clientStrore = KeyStore.getInstance("PKCS12");
        // 加载客户端证书，即自己的私钥
        clientStrore.load(new FileInputStream("D:\\ssl\\client.p12"),pw.toCharArray());
        //创建管理JKS密钥库的x509的密钥管理器，用来管理密钥，需要key的密码。创建密钥管理工厂实例
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        //初始化客户端密钥库
        kmf.init(clientStrore, pw.toCharArray());

        KeyManager[] kms = kmf.getKeyManagers();
        //创建信任库管理工厂实例
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // 信任库类型
        KeyStore trustStore = KeyStore.getInstance("JKS");
        // 加载信任库，即服务端公钥
        trustStore.load(new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_171\\jre\\lib\\security\\cacerts"),"changeit".toCharArray());
        // 初始化信任库
        tmf.init(trustStore);
        TrustManager[] tms = tmf.getTrustManagers();
        // 建立TLS连接
        SSLContext sslContext = SSLContext.getInstance("TLS");
        // 初始化SSLContext   //KeyManager[] 第一个参数是授权的密钥管理器，用来授权验证。第二个是被授权的证书管理器，
        //		//用来验证服务器端的证书。只验证服务器数据，第一个管理器可以为null
        sslContext.init(kms, tms, new SecureRandom());


//        //引入jwt
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.SECOND, 600);
//        String token = JWT.create()// header有默认值可不用写
//                .withClaim("userId", 21)//payload
//                .withClaim("username", "zhangsan")
//                .withExpiresAt(calendar.getTime())// token过期时间  600秒后过期
//                .sign(Algorithm.HMAC256("!@sdsfsdgfdg")); // 签名
//        System.out.println(token);

        //创建验证对象
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("!@sdsfsdgfdg")).build();// 注意秘钥要和生成token的秘钥一致
//
//        DecodedJWT verify = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTYyMTU1MzksInVzZXJJZCI6MjEsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.Y8CrFynod_hd4983yk9azl8xXIB5YiwajFSE_B71qAk");
//
//        System.out.println(verify.getClaim("userId").asInt());
//
//        System.out.println(verify.getClaim("username").asString());


        SSLConnectionSocketFactory  sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpGet httpGet = new HttpGet(URL);
            System.out.println("executing request"+httpGet.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null){
                    System.out.println(EntityUtils.toString(entity));
                }
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }

    }
}
