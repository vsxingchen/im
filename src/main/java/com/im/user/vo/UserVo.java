package com.im.user.vo;

import com.im.user.domain.User;

public class UserVo extends User{
	
    private Integer startAge;
    
    private Integer endAge;
    
    /**
     * 身高
     */
    private String startHeight;
    
    private String endHeight;
    /**
     * 体重
     */
    private String startWeight;
    
    private String endWeight;

	public Integer getStartAge() {
		return startAge;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}

	public String getStartHeight() {
		return startHeight;
	}

	public void setStartHeight(String startHeight) {
		this.startHeight = startHeight;
	}

	public String getEndHeight() {
		return endHeight;
	}

	public void setEndHeight(String endHeight) {
		this.endHeight = endHeight;
	}

	public String getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(String startWeight) {
		this.startWeight = startWeight;
	}

	public String getEndWeight() {
		return endWeight;
	}

	public void setEndWeight(String endWeight) {
		this.endWeight = endWeight;
	}
    
    
}
