package com.maxi.waterpurifier.model;

/**
 * Created by bin.shen on 05/01/2017.
 */

public class Device {

    private String _id;

    private String name;

    private int status;

    private int waterQuality;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWaterQuality() {
        return waterQuality;
    }

    public void setWaterQuality(int waterQuality) {
        this.waterQuality = waterQuality;
    }
}
