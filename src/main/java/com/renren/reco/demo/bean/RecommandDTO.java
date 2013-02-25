package com.renren.reco.demo.bean;

public class RecommandDTO {

	private long uploaderPhoneNumber;
	
	private long recommandPhoneNumber;
	
	private long recommandTime;
	
	private long verifyTime;
	
	private int isSuccess;
	
	private double score;
	
	public RecommandDTO () {
		
	}
	public RecommandDTO (Long uploaderPhoneNumber,Long recommandPhoneNumber, Double score) {
		this.uploaderPhoneNumber = uploaderPhoneNumber;
		this.recommandPhoneNumber = recommandPhoneNumber;
		this.score = score;
	}
	
	public long getUploaderPhoneNumber() {
		return uploaderPhoneNumber;
	}

	public void setUploaderPhoneNumber(long uploaderPhoneNumber) {
		this.uploaderPhoneNumber = uploaderPhoneNumber;
	}

	public long getRecommandPhoneNumber() {
		return recommandPhoneNumber;
	}

	public void setRecommandPhoneNumber(long recommandPhoneNumber) {
		this.recommandPhoneNumber = recommandPhoneNumber;
	}

	public long getRecommandTime() {
		return recommandTime;
	}

	public void setRecommandTime(long recommandTime) {
		this.recommandTime = recommandTime;
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
