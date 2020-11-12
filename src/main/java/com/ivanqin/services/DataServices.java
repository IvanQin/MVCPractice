package com.ivanqin.services;

import com.ivanqin.dataaccessor.DataGetter;
import com.ivanqin.dataaccessor.DataMutatorGetter;
import com.ivanqin.model.DataModel;
import com.ivanqin.mutator.DataMutation;
import com.ivanqin.mutator.DataMutator;
import com.ivanqin.system.DataSystem;

public class DataServices implements DataGetter<DataModel>, DataMutatorGetter<DataMutation> {

  private DataSystem mDataSystem;

  public DataServices(DataSystem dataSystem) {
    mDataSystem = dataSystem;
  }

  public DataSystem getDataSystem() {
    return mDataSystem;
  }

  public DataModel getGlobalData() {
    return mDataSystem.getGlobalData();
  }

  public DataMutator getDataMutator() {
    return mDataSystem.getDataMutator();
  }
}
