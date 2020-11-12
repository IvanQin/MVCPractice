package com.ivanqin.controllers;

import com.ivanqin.dataaccessor.DataCanSave;
import com.ivanqin.dataaccessor.DataGetter;
import com.ivanqin.dataaccessor.DataMutatorGetter;
import com.ivanqin.model.DataListener;
import com.ivanqin.model.MasterTask;
import com.ivanqin.model.Project1;
import com.ivanqin.shared.Logger;

public class Manager1<
        Data extends Project1.ProvideProject1 & MasterTask.ProvideMasterTask,
        Mutation extends DataCanSave & MasterTask.SetMasterTask<Mutation>,
        Services extends DataGetter<Data> & DataMutatorGetter<Mutation>>
    implements DataListener<Data> {

  private Services mDataServices;

  private boolean mUseRecursiveMutation;

  public Manager1(Services dataServices) {
    mDataServices = dataServices;
  }

  public void setUseRecursiveMutation(boolean useRecursiveMutation) {
    mUseRecursiveMutation = useRecursiveMutation;
  }

  public void onDataChanged(Data previousData) {
    Data currentData = mDataServices.getGlobalData();
    if (!previousData.getProject1().isFinished() && currentData.getProject1().isFinished()) {
      Logger.getInstance().speak(this.getClass(), "project 1 finished!");
      setMasterTaskProgress(currentData);
    }
    Logger.getInstance()
        .speak(
            this.getClass(),
            "current progress of master task is " + currentData.getMasterTask().getProgress());
  }

  private void setMasterTaskProgress(Data currentData) {
    if (mUseRecursiveMutation) {
      mDataServices
          .getDataMutator()
          .mutateAllowRecursive()
          .setMasterTask(
              MasterTask.buildFrom(mDataServices.getGlobalData().getMasterTask())
                  .setProgress(currentData.getMasterTask().getProgress() + 1)
                  .build())
          .save();
    } else {
      mDataServices
          .getDataMutator()
          .mutate()
          .setMasterTask(
              MasterTask.buildFrom(mDataServices.getGlobalData().getMasterTask())
                  .setProgress(currentData.getMasterTask().getProgress() + 1)
                  .build())
          .save();
    }
  }
}
