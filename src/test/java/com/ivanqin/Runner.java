package com.ivanqin;

import com.ivanqin.model.DataModelImpl;
import com.ivanqin.mutator.DataMutatorImpl;
import com.ivanqin.services.DataServices;
import com.ivanqin.services.DataSubscriptionManager;
import com.ivanqin.system.DataModelCreator;
import com.ivanqin.system.DataSystem;
import org.junit.Before;
import org.junit.Test;

public class Runner {
  DataSubscriptionManager mSubscriptionManager;

  @Before
  public void setup() {
    DataModelCreator dataModelCreator = new DataModelCreator();
    DataModelImpl dataModel = dataModelCreator.createInitialDataModel();
    DataMutatorImpl dataMutator = new DataMutatorImpl(dataModel);
    DataSystem dataSystem = new DataSystem(dataMutator);
    DataServices dataServices = new DataServices(dataSystem);
    mSubscriptionManager = new DataSubscriptionManager(dataServices);
  }

  @Test
  public void normalBroadcast() {
    mSubscriptionManager.getTeamMember1().modifyWork();
  }

  @Test(expected = IllegalStateException.class)
  public void recursiveBroadcast_throwException() {
    mSubscriptionManager.getTeamMember1().finishWork();
  }

  @Test
  public void safeRecursiveBroadcast() {
    mSubscriptionManager.getManager1().setUseRecursiveMutation(true);
    mSubscriptionManager.getTeamMember1().finishWork();
  }
}
