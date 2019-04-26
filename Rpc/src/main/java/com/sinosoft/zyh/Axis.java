package com.sinosoft.zyh;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Axis {

	public static void main(String[] args) {
		// webserviceURL
		String service_url = "http://10.132.75.14:8080/IOAS/MessageService?wsdl";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(service_url));
			// ����Ҫ���õķ���
			// http://intelink.net/��wsdl��definitions���ڵ��targetNamespace����ֵ
			call.setOperationName(new QName("http://tempuri.org/", "FileArrived"));
			
			// �÷�����Ҫ�Ĳ���
			//call.addParameter("CustNo", org.apache.axis.encoding.XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new javax.xml.namespace.QName("http://tempuri.org/", "fileRelativePath"), org.apache.axis.encoding.XMLType.XSD_STRING, String.class, javax.xml.rpc.ParameterMode.IN);
			
			call.setUseSOAPAction(true);
			
			//http://tempuri.org/IMessageService/FileArrived
			call.setSOAPActionURI("http://tempuri.org/IMessageService/FileArrived");
			
			// �����ķ���ֵ����
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
		
			// call.setUseSOAPAction(true);
			// //call.setSOAPActionURI("http://intelink.net/GetStrByJobno");
			// ���ø÷���, new Object[] { CustNo, passwd, Jobno}Ϊ�����б�
			String xmlStr = call.invoke(new Object[] { "aaa" }).toString();
			System.out.println(xmlStr);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(�����Թɡ�);
		
		
	}
}
