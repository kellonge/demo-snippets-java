package com.kellonge.demo.snippets.java.net;

import java.io.Serializable;

public class SocketData implements Serializable {
    private Integer len;
    private byte[]  data;

    public SocketData(byte[] data) {

    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
