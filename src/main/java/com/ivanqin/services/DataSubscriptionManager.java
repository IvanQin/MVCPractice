package com.ivanqin.services;

import com.ivanqin.controllers.Manager1;
import com.ivanqin.controllers.TeamMember1;
import com.ivanqin.controllers.TeamMember2;
import com.ivanqin.model.DataModel;
import com.ivanqin.mutator.DataMutation;
import com.ivanqin.system.DataSystem;

public class DataSubscriptionManager {

  private DataSystem mDataSystem;
  private DataServices mDataServices;

  private Manager1<DataModel, DataMutation, DataServices> mManager1;
  private TeamMember1<DataModel, DataMutation, DataServices> mTeamMember1;
  private TeamMember2<DataModel, DataServices> mTeamMember2;

  public DataSubscriptionManager(DataServices dataServices) {
    mDataServices = dataServices;
    mDataSystem = dataServices.getDataSystem();
    init();
  }

  public Manager1<DataModel, DataMutation, DataServices> getManager1() {
    if (mManager1 == null) {
      mManager1 = new Manager1<DataModel, DataMutation, DataServices>(mDataServices);
    }
    return mManager1;
  }

  public TeamMember1<DataModel, DataMutation, DataServices> getTeamMember1() {
    if (mTeamMember1 == null) {
      mTeamMember1 = new TeamMember1<DataModel, DataMutation, DataServices>(mDataServices);
    }
    return mTeamMember1;
  }

  public TeamMember2<DataModel, DataServices> getTeamMember2() {
    if (mTeamMember2 == null) {
      mTeamMember2 = new TeamMember2<DataModel, DataServices>(mDataServices);
    }
    return mTeamMember2;
  }

  private void init() {
    mDataSystem.addDataListener(getManager1());
    mDataSystem.addDataListener(getTeamMember1());
    mDataSystem.addDataListener(getTeamMember2());
  }
}
