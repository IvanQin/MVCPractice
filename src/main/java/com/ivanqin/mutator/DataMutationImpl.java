package com.ivanqin.mutator;

import com.ivanqin.model.*;

public class DataMutationImpl implements DataMutation {

  public interface Delegate {
    void commit(DataMutationImpl dataMutation);
  }

  private DataModelImpl mDataModel;
  private DataModelImpl.Builder mDataModelBuilder;
  private Delegate mDelegate;

  public DataMutationImpl(DataModelImpl dataModel, Delegate delegate) {
    mDataModel = dataModel;
    mDelegate = delegate;
  }

  public void save() {
    mDelegate.commit(this);
  }

  public DataModelImpl getResultModel() {
    return mDataModelBuilder.build();
  }

  public DataMutation setMasterTask(MasterTask masterTask) {
    if (mDataModelBuilder == null) {
      mDataModelBuilder = DataModelImpl.buildFrom(mDataModel);
    }
    mDataModelBuilder.setMasterTask(masterTask);
    return this;
  }

  public DataMutation setProject1(Project1 project1) {
    if (mDataModelBuilder == null) {
      mDataModelBuilder = DataModelImpl.buildFrom(mDataModel);
    }
    mDataModelBuilder.setProject1(project1);
    return this;
  }
}
