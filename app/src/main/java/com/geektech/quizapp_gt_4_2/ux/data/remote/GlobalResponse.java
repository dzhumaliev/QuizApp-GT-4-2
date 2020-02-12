package com.geektech.quizapp_gt_4_2.ux.data.remote;


import com.geektech.quizapp_gt_4_2.model.Global;

import java.util.Map;

public class GlobalResponse {
    private Global overall;
    private Map<Integer, Global> categories;

    public Global getGlobal() {
        return overall;
    }

    public void setGlobal(Global global) {
        this.overall = global;
    }

    public Map<Integer, Global> getGlobalMap() {
        return categories;
    }

    public void setGlobalMap(Map<Integer, Global> globalMap) {
        this.categories = globalMap;
    }
}
