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
     * RPC����AXIS2 webservice
     * @param endpoint �����ַ �磺http://192.168.0.1:2597/aixs2/services/jqservice
     * @param localPart ������ ��<xs:element name="Receive">
     * @param opArgs �������� ��Object[] opArgs = new Object[] { param }; 
     * @param namespaceURI �����ռ� �� ��targetNamespace="http://server.test.com.cn">
     * @param opReturnType �������� ���ַ�����Class[] opReturnType = new Class[] { String[].class };
	 * @return 
	 * @throws AxisFault 
     */
	public static void callRemoteFun() throws AxisFault {

		/*RPCServiceClient client = null;
		try {
			client = new RPCServiceClient();
			Options options = client.getOptions();
		
			// ����һ��Զ�̵ķ��ʵ�ַ
			EndpointReference target = new EndpointReference("http://10.132.75.14:8080/IOAS/MessageService");
			options.setTo(target);
			Object[] objargs = new Object[] { "/zzzz" };
			options.
			//���岽 �����ķ���ֵ�����Բ�����  
	        Class[] classes = new Class[] {Object.class}; 
			Object[] response = client.invokeBlocking(new QName("http://tempuri.org/","MessageService"), objargs,classes );
			String result = (String) response[0];
			System.out.println(result);
		} catch (AxisFault e) {
			e.printStackTrace();
		}*/
		
		
		   /** ����webser��nextNum���� **/  
        
        //��һ�� ����RPCServiceClient����  
        RPCServiceClient serviceClient = new RPCServiceClient();  
        Options options = serviceClient.getOptions();  
        //�ڶ��� Զ��wsdl�ļ�   
        EndpointReference target = new EndpointReference("http://10.132.75.14:8080/IOAS/MessageService");  
        options.setTo(target);  
        //������ �����ռ�ͷ���  
        QName addEntry = new QName("http://tempuri.org/", "FileArrived");  
        //���Ĳ� ���뷽���Ĳ�����û�еĻ����������  
        Object[] addEntryArgs = new Object[]{ "shanshanbox.com" };  
        //���岽 �����ķ���ֵ�����Բ�����  
        Class[] classes = new Class[] {String.class};  
          
        Object[] invokeBlocking = serviceClient.invokeBlocking(addEntry, addEntryArgs, classes);  
          
        System.out.println(invokeBlocking[0]);  

		
	}
	
	

}
