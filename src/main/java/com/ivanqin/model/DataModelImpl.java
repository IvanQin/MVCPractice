package com.ivanqin.model;

public class DataModelImpl implements DataModel {

  private MasterTask mMasterTask;
  private Project1 mProject1;

  private DataModelImpl(Builder builder) {
    mMasterTask = builder.mMasterTask;
    mProject1 = builder.mProject1;
  }

  public static Builder buildFrom(DataModelImpl dataModel) {
    Builder builder = new Builder();
    builder.setMasterTask(dataModel.getMasterTask()).setProject1(dataModel.getProject1());
    return builder;
  }

  public static class Builder {
    private MasterTask mMasterTask;
    private Project1 mProject1;

    public Builder() {}

    public Builder setMasterTask(MasterTask masterTask) {
      mMasterTask = masterTask;
      return this;
    }

    public Builder setProject1(Project1 project1) {
      mProject1 = project1;
      return this;
    }

    public DataModelImpl build() {
      return new DataModelImpl(this);
    }
  }

  public MasterTask getMasterTask() {
    return mMasterTask;
  }

  public Project1 getProject1() {
    return mProject1;
  }
}
