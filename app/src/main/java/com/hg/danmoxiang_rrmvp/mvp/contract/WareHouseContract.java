package com.hg.danmoxiang_rrmvp.mvp.contract;

import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;

import java.util.List;

public interface WareHouseContract extends BaseContract {
   void showMaterielInfo(List<Materiel> materiel);
}
