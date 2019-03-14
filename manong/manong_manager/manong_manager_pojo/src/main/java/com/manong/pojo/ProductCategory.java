package com.manong.pojo;

public class ProductCategory {
    private Short id;

    private String name;

    private Short soderorder = 999;

    private Byte status = 0;

    private Short parentid = 0;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getSoderorder() {
        return soderorder;
    }

    public void setSoderorder(Short soderorder) {
        this.soderorder = soderorder;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Short getParentid() {
        return parentid;
    }

    public void setParentid(Short parentid) {
        this.parentid = parentid;
    }
}