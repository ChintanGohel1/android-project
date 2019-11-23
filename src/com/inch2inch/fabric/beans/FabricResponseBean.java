package com.inch2inch.fabric.beans;

import java.util.List;

public class FabricResponseBean {

    private List<FabricBean> fabricBeans;

    public List<FabricBean> getFabricBeans() {
        return fabricBeans;
    }

    public void setFabricBeans(List<FabricBean> fabricBeans) {
        this.fabricBeans = fabricBeans;
    }

    @Override
    public String toString() {
	return "FabricResponseBean [fabricBeans=" + fabricBeans + "]";
    }
    
    
    
}
