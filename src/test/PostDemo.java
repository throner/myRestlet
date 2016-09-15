package test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chenjiansheng on 2016-5-23.
 */
public class PostDemo {
    public String postData(){
        String sResult = "";
        try{
            sResult = new String(this.getBytes("http://localhost:8080/myRestlet/api/1/2/hello","post name",-1,"utf-8"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(sResult);
        return sResult;
    }
    /**
     * 获取字节集合
     * @param pageUrl
     * @param paramMap
     * @param iTimeout
     * @param charset字符集
     * @return
     * @throws Exception
     */
    public byte[] getBytes(String pageUrl,String content, int iTimeout, String charset) throws Exception {
        byte[] aResult = null;
        if (iTimeout <= 0){
            iTimeout = 5000;//默认5秒超时间
        }
        if(charset==null){
            charset = "GBK";
        }
        DataOutputStream printout = null;
        InputStream input = null;
        HttpURLConnection urlConn = null;
        ByteArrayOutputStream os = null;
        try {
            URL url;
            url = new URL(pageUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.setRequestProperty("Content-Type","application/json;charset="+charset);
            urlConn.setConnectTimeout(iTimeout);//设置超时
            urlConn.setReadTimeout(iTimeout);//设置超时
            //发送request
            urlConn.setRequestProperty("Content-Length", String.valueOf(content.length()));
            printout = new DataOutputStream(urlConn.getOutputStream());
            printout.write(content.getBytes(charset));
            printout.flush();

            //取response
            input = urlConn.getInputStream();
            os = new ByteArrayOutputStream();
            byte[] buffer = new byte[64*1024];
            while (true) {
                int count = input.read(buffer);
                if (count < 0){
                    break;
                }
                os.write(buffer, 0, count);
            }
            aResult = os.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{//关闭数据流
            try{
                if(printout!=null){
                    printout.close();
                }
                if(input!=null){
                    input.close();
                }
                if(os!=null){
                    os.close();
                }
                if(urlConn!=null){
                    urlConn.disconnect();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return aResult;
    }
}
