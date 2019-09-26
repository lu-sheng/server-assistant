package com.feidao.server.assistant.entity;

/**
 * LN
 * 2019/9/24 0024 17:45
 */
public class TimeStampEntity {
    private String timestamp;
    private String timestampStr;
    private String timestampFormat;

    public String getTimestampFormat() {
        return timestampFormat;
    }

    public void setTimestampFormat(String timestampFormat) {
        this.timestampFormat = timestampFormat;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestampStr() {
        return timestampStr;
    }

    public void setTimestampStr(String timestampStr) {
        this.timestampStr = timestampStr;
    }

    @Override
    public String toString() {
        return "TimeStampEntity{" +
                "timestamp='" + timestamp + '\'' +
                ", timestampStr='" + timestampStr + '\'' +
                ", timestampFormat='" + timestampFormat + '\'' +
                '}';
    }
}
