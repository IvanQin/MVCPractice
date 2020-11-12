package com.ivanqin.model;

public class MasterTask {

  public interface ProvideMasterTask {
    MasterTask getMasterTask();
  }

  public interface SetMasterTask<T> {
    T setMasterTask(MasterTask masterTask);
  }

  private int progress;

  private MasterTask(Builder builder) {
    this.progress = builder.progress;
  }

  public static Builder buildFrom(MasterTask masterTask) {
    return new Builder().setProgress(masterTask.progress);
  }

  public static class Builder {
    private int progress;

    public Builder() {}

    public Builder setProgress(int progress) {
      this.progress = progress;
      return this;
    }

    public MasterTask build() {
      return new MasterTask(this);
    }
  }

  public int getProgress() {
    return progress;
  }
}
