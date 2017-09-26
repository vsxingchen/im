package com.im.utils;

import java.util.UUID;

public class GenerateUUID {
	//支付
	private static String pay_seq_prefix = "10";
	//转账
	private static String trans_seq_prefix = "2";
	//拉货王平台司机用户
	private static String driver_seq_prefix = "3";
	//拉货王平台货主用户
	private static String company_seq_prefix = "4";
	//拉货王平台订单
	private static String order_seq_prefix = "5";
	//拉货王平台货源单号
	private static String goods_seq_prefix = "6";
	//服务器集群1 用户
	private static int machineIdOneForUser=1;
	//服务器集群2支付通道
	private static int machineIdTwoForPay=2;
	//服务器集群3 订单和货单
	private static int machineIdThreeForOrder=3;
	//服务器集群4 图片编号规则
	private static int machineIdFourForImages=4;
	public static String getUUID() {
		
		return getUUId(machineIdFourForImages);
		}
	//支付编号规则
	public static String getPay(){
		return pay_seq_prefix+getUUId(machineIdTwoForPay);
	}
	//拉货王平台司机用户
	public static String getDriverUser(){
		return driver_seq_prefix+getUUId(machineIdOneForUser);
	}
	//拉货王平台货主用户
	public static String getCompanyUser(){
		return company_seq_prefix+getUUId(machineIdOneForUser);
	}
	//订单编号规则
	public static String getOrderNumber(){
		
		return order_seq_prefix+getUUId(machineIdThreeForOrder);
	}
	//货单编号规则
	public static String getGoodsNumber(){
		int hashCodeV = UUID.randomUUID().toString().hashCode();
	    if(hashCodeV < 0) {//有可能是负数  
	        hashCodeV = - hashCodeV;  
	    }
		return DateUtil.getSeqString()+String.valueOf(hashCodeV);
	}
	//生成规则
	public static String getUUId(int machineId) {
		IdWorker idWorker = new IdWorker(0, 0);
		long id = idWorker.nextId();
	    /*int hashCodeV = UUID.randomUUID().toString().hashCode();
	    if(hashCodeV < 0) {//有可能是负数  
	        hashCodeV = - hashCodeV;  
	    }  */
	    // 0 代表前面补充0       
	    // 15 代表长度为15     
	    // d 代表参数为正数型  
	    return machineId+DateUtil.getSeqString()+String.valueOf(id);//+String.valueOf(hashCodeV); 
	    
	}
	public static void main(String[] args) {
		
		
		for(int i=1;i<=15;i++)
		{
			System.out.println("第"+i+"组");
			System.out.println(getGoodsNumber());
			System.out.println(getGoodsNumber().length());
			System.out.println("------------------");
		}
		
	}
}
