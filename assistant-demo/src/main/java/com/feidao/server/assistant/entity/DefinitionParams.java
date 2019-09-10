package com.feidao.server.assistant.entity;

import java.util.Arrays;

/**
 * LN
 * 2019/9/10 0010 12:50
 */
public class DefinitionParams {
    private String prefix;
    private String[] params;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "DefinitionParams{" +
                "prefix='" + prefix + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
