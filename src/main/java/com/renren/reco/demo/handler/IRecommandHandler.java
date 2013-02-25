package com.renren.reco.demo.handler;

import java.util.List;

import com.renren.reco.demo.bean.RecommandDTO;

public interface IRecommandHandler {
	public List<RecommandDTO> getRecommands(long phoneNumber);
	public boolean isExist(RecommandDTO recommandDTO);
	public void updateRecommand(RecommandDTO recommandDTO);
	public void setRecommand(RecommandDTO recommandDTO);
}
