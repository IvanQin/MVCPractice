package com.ivanqin.controllers;

import com.ivanqin.dataaccessor.DataCanSave;
import com.ivanqin.dataaccessor.DataGetter;
import com.ivanqin.dataaccessor.DataMutatorGetter;
import com.ivanqin.model.DataListener;
import com.ivanqin.model.DataModel;
import com.ivanqin.model.Project1;
import com.ivanqin.shared.Logger;

public class TeamMember1<
        Data extends Project1.ProvideProject1,
        Mutation extends Project1.SetProject1<Mutation> & DataCanSave,
        Services extends DataGetter<Data> & DataMutatorGetter<Mutation>>
    implements DataListener<Data> {

  private Services mDataServices;

  public TeamMember1(Services dataServices) {
    mDataServices = dataServices;
  }

  public void work(DataModel dataModel) {
    modifyWork();
  }

  public void modifyWork() {
    Mutation dataMutation = mDataServices.getDataMutator().mutate();
    Data dataModel = mDataServices.getGlobalData();
    int originalWorkLoad = dataModel.getProject1().getWorkLoad();
    dataMutation
        .setProject1(
            Project1.buildFrom(dataModel.getProject1()).setWorkLoad(originalWorkLoad + 1).build())
        .save();
  }

  public void finishWork() {
    Mutation dataMutation = mDataServices.getDataMutator().mutate();
    dataMutation
        .setProject1(
            Project1.buildFrom(mDataServices.getGlobalData().getProject1())
                .setFinished(true)
                .build())
        .save();
  }

  public void onDataChanged(Data previousData) {
    Logger.getInstance()
        .speak(
            this.getClass(),
            String.format(
                "current work load is %d",
                +mDataServices.getGlobalData().getProject1().getWorkLoad()));
  }
}
