package com.ivanqin.model;

public class Project1 {

  public interface ProvideProject1 {
    Project1 getProject1();
  }

  public interface SetProject1<T> {
    T setProject1(Project1 project1);
  }

  private String deliverDate;
  private String owner;
  private int workLoad;
  private boolean finished;

  private Project1(Builder builder) {
    this.deliverDate = builder.deliverDate;
    this.workLoad = builder.workLoad;
    this.owner = builder.owner;
    this.finished = builder.finished;
  }

  public static Builder buildFrom(Project1 project1) {
    return new Builder()
        .setDeliverDate(project1.deliverDate)
        .setOwner(project1.owner)
        .setWorkLoad(project1.workLoad)
        .setFinished(project1.finished);
  }

  public static class Builder {
    private String deliverDate;
    private int workLoad;
    private String owner;
    private boolean finished;

    public Builder() {}

    public Builder setDeliverDate(String deliverDate) {
      this.deliverDate = deliverDate;
      return this;
    }

    public Builder setWorkLoad(int workLoad) {
      this.workLoad = workLoad;
      return this;
    }

    public Builder setOwner(String owner) {
      this.owner = owner;
      return this;
    }

    public Builder setFinished(boolean finished) {
      this.finished = finished;
      return this;
    }

    public Project1 build() {
      return new Project1(this);
    }
  }

  public String getDeliverDate() {
    return deliverDate;
  }

  public int getWorkLoad() {
    return workLoad;
  }

  public String getOwner() {
    return owner;
  }

  public boolean isFinished() {
    return finished;
  }
}
