package com.example.drivercab.AboutPageModel;

import android.util.SparseArray;

public class About {
    private String id;
    private String PageName;
    private String type;
    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
