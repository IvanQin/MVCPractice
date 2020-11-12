package com.ivanqin.system;

import com.ivanqin.model.DataModelImpl;
import com.ivanqin.model.MasterTask;
import com.ivanqin.model.Project1;

public class DataModelCreator {

  public DataModelCreator() {}

  public DataModelImpl createInitialDataModel() {
    DataModelImpl.Builder builder = new DataModelImpl.Builder();
    return builder
        .setMasterTask(new MasterTask.Builder().setProgress(0).build())
        .setProject1(
            new Project1.Builder()
                .setDeliverDate("none")
                .setOwner("ivanqin")
                .setWorkLoad(0)
                .build())
        .build();
  }
}
