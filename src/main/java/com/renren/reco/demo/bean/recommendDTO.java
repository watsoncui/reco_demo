package com.renren.reco.demo.bean;

public class RecommendDTO {

	private long uploaderPhoneNumber;
	
	private long recommendPhoneNumber;
	
	private long recommendTime;
	
	private long verifyTime;
	
	private int isSuccess;
	
	private double score;
	
	public RecommendDTO () {
		
	}
	public RecommendDTO (Long uploaderPhoneNumber,Long recommendPhoneNumber, Double score) {
		this.uploaderPhoneNumber = uploaderPhoneNumber;
		this.recommendPhoneNumber = recommendPhoneNumber;
		this.score = score;
	}
	
	public long getUploaderPhoneNumber() {
		return uploaderPhoneNumber;
	}

	public void setUploaderPhoneNumber(long uploaderPhoneNumber) {
		this.uploaderPhoneNumber = uploaderPhoneNumber;
	}

	public long getRecommendPhoneNumber() {
		return recommendPhoneNumber;
	}

	public void setRecommendPhoneNumber(long recommendPhoneNumber) {
		this.recommendPhoneNumber = recommendPhoneNumber;
	}

	public long getRecommendTime() {
		return recommendTime;
	}

	public void setRecommendTime(long recommendTime) {
		this.recommendTime = recommendTime;
	}

	public long getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(long verifyTime) {
		this.verifyTime = verifyTime;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public int getIsSuccess() {
		return isSuccess;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
