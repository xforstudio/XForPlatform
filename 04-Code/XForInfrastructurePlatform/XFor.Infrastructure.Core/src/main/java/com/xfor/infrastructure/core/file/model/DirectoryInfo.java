package com.xfor.infrastructure.core.file.model;

import lombok.Data;

import java.util.List;

@Data
public class DirectoryInfo extends PathUnitInfo {

    private List<PathUnitInfo> subUnitInfos;
    private PathUnitInfo supUnitInfo;

    public DirectoryInfo() {
        super();
    }

    @Override
    public List<PathUnitInfo> getSubUnitInfos() {
        return null;
    }

    @Override
    public PathUnitInfo getSupUnitInfo() {
        return null;
    }
}
