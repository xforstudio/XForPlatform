package com.xfor.infrastructure.core.file.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 路径单位信息
 */
@Data
public abstract class PathUnitInfo {

    private String sid;
    private String owner;
    private String name;
    private String fullName;
    private Date createTime;
    private Date modifyTime;
    private int type;

    public abstract List<PathUnitInfo> getSubUnitInfos();

    public abstract PathUnitInfo getSupUnitInfo();
}
