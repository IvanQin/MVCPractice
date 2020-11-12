package com.ivanqin.mutator;

import com.ivanqin.model.DataListener;
import com.ivanqin.model.DataModel;
import com.ivanqin.model.DataModelImpl;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class DataMutatorImpl implements DataMutator<DataMutation> {
  private DataModelImpl mDataModelImpl;
  private DataMutationImpl mCurrentMutation;
  private boolean mIsBroadcastInProgress;

  private HashSet<DataListener<DataModel>> mDataListeners =
      new LinkedHashSet<DataListener<DataModel>>();

  private DataMutationImpl.Delegate mCommitDelegate =
      new DataMutationImpl.Delegate() {
        public void commit(DataMutationImpl dataMutation) {
          mIsBroadcastInProgress = true;
          DataMutatorImpl.this.commit(dataMutation);
          mIsBroadcastInProgress = false;
        }
      };

  public DataMutatorImpl(DataModelImpl dataModelImpl) {
    mDataModelImpl = dataModelImpl;
  }

  public DataMutation mutate() {
    if (mIsBroadcastInProgress) {
      throw new IllegalStateException("Mutation is in progress!");
    }
    mCurrentMutation = new DataMutationImpl(mDataModelImpl, mCommitDelegate);
    return mCurrentMutation;
  }

  public DataMutation mutateAllowRecursive() {
    mCurrentMutation = new DataMutationImpl(mDataModelImpl, mCommitDelegate);
    return mCurrentMutation;
  }

  public void addDataListener(DataListener<DataModel> dataListener) {
    mDataListeners.add(dataListener);
  }

  public void removeDataListener(DataListener dataListener) {
    mDataListeners.remove(dataListener);
  }

  public DataModelImpl getDataModel() {
    return mDataModelImpl;
  }

  private void commit(DataMutationImpl dataMutation) {
    clearCurrentMutation();

    DataModel oldModel = getDataModel();

    // the value of the new model must be updated before notifying listeners and after getting old
    // model
    mDataModelImpl = dataMutation.getResultModel();

    for (DataListener<DataModel> dataListener : mDataListeners) {
      dataListener.onDataChanged(oldModel);
    }
  }

  private void clearCurrentMutation() {
    mCurrentMutation = null;
  }
}
