package com.ivanqin.mutator;

import com.ivanqin.dataaccessor.DataCanSave;
import com.ivanqin.model.MasterTask;
import com.ivanqin.model.Project1;

public interface DataMutation
    extends MasterTask.SetMasterTask<DataMutation>,
        Project1.SetProject1<DataMutation>,
        DataCanSave {}
