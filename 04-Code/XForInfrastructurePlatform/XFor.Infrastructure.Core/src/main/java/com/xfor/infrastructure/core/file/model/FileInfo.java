package com.xfor.infrastructure.core.file.model;

import lombok.Data;

import java.util.List;

@Data
public class FileInfo extends PathUnitInfo {

    public FileInfo() {
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
