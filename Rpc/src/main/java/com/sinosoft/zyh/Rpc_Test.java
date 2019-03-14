package com.sinosoft.zyh;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class Rpc_Test {
	
	public static void main(String[] args) {
		try {
			Rpc_Test.callRemoteFun();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
     * RPC调用AXIS2 webservice
     * @param endpoint 服务地址 如：http://192.168.0.1:2597/aixs2/services/jqservice
     * @param localPart 方法名 如<xs:element name="Receive">
     * @param opArgs 方法参数 如Object[] opArgs = new Object[] { param }; 
     * @param namespaceURI 命名空间 如 ：targetNamespace="http://server.test.com.cn">
     * @param opReturnType 返回类型 如字符串：Class[] opReturnType = new Class[] { String[].class };
	 * @return 
	 * @throws AxisFault 
     */
	public static void callRemoteFun() throws AxisFault {

		/*RPCServiceClient client = null;
		try {
			client = new RPCServiceClient();
			Options options = client.getOptions();
		
			// 创建一个远程的访问地址
			EndpointReference target = new EndpointReference("http://10.132.75.14:8080/IOAS/MessageService");
			options.setTo(target);
			Object[] objargs = new Object[] { "/zzzz" };
			options.
			//第五步 方法的返回值，可以不存在  
	        Class[] classes = new Class[] {Object.class}; 
			Object[] response = client.invokeBlocking(new QName("http://tempuri.org/","MessageService"), objargs,classes );
			String result = (String) response[0];
			System.out.println(result);
		} catch (AxisFault e) {
			e.printStackTrace();
		}*/
		
		
		   /** 调用webser中nextNum方法 **/  
        
        //第一步 创建RPCServiceClient对象  
        RPCServiceClient serviceClient = new RPCServiceClient();  
        Options options = serviceClient.getOptions();  
        //第二步 远程wsdl文件   
        EndpointReference target = new EndpointReference("http://10.132.75.14:8080/IOAS/MessageService");  
        options.setTo(target);  
        //第三步 命名空间和方法  
        QName addEntry = new QName("http://tempuri.org/", "FileArrived");  
        //第四步 传入方法的参数，没有的话定义空数组  
        Object[] addEntryArgs = new Object[]{ "shanshanbox.com" };  
        //第五步 方法的返回值，可以不存在  
        Class[] classes = new Class[] {String.class};  
          
        Object[] invokeBlocking = serviceClient.invokeBlocking(addEntry, addEntryArgs, classes);  
          
        System.out.println(invokeBlocking[0]);  

		
	}
	
	

}
