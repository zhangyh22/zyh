package com.sinosoft.common.config;

import com.alibaba.druid.filter.config.ConfigTools;

public class Test {


    public static void main(String[] args) {
        try {
            testEncrypt("uusesm");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //password: QWwgrxWTYnmwXFugHXdBAefx1FXkFaYg40UeLImew6Tcr9mrv1QlAae222b1uu1KP5T+5+GRgjt9XA/k+lcCxw==
         //       publicKey: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJEgGBxsWFMY4TaSSOCgT+t/2Jtj0kWlIba7sN6/v+ozQjVkD9RYPcmehKv9dWCZi6m1QzxWIGzSzCoWZbnSRi8CAwEAAQ==


        /*String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJEgGBxsWFMY4TaSSOCgT+t/2Jtj0kWlIba7sN6/v+ozQjVkD9RYPcmehKv9dWCZi6m1QzxWIGzSzCoWZbnSRi8CAwEAAQ==" ;
        String password = "QWwgrxWTYnmwXFugHXdBAefx1FXkFaYg40UeLImew6Tcr9mrv1QlAae222b1uu1KP5T+5+GRgjt9XA/k+lcCxw==";


        try {
            String decrypt = ConfigTools.decrypt(publicKey, password);
            System.out.println(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public static String testDecrypt(String pwd, String  publicKey){
        String decrypt = null;
        try {
            decrypt = ConfigTools.decrypt(publicKey, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(decrypt);

        return "";
    }

    public static String testEncrypt(String pwd) throws  Exception{
        String[] keyPair = ConfigTools.genKeyPair(512);


        String privateKey = keyPair[0];
        String publicKey = keyPair[1];

        pwd = ConfigTools.encrypt(privateKey, pwd);

        System.out.println("privateKey:>>>>>" + privateKey );
        System.out.println("publicKey:>>>>>" + publicKey );
        System.out.println("pwd:>>>>>" + pwd );


        testDecrypt(pwd, publicKey);

        return pwd;




    }



}
