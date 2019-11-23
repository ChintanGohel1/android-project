package com.inch2inch.customer.bean;

import java.util.List;

public class CustomerResponseBean {
	private List<CustomerBean> customerBeans;

	public List<CustomerBean> getCustomerBeans() {
		return customerBeans;
	}

	public void setCustomerBeans(List<CustomerBean> customerBeans) {
		this.customerBeans = customerBeans;
	}

	@Override
	public String toString() {
		return "CustomerResponseBean [customerBeans=" + customerBeans + "]";
	}
	
	

}
