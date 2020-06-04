package com.xfor.infrastructure.core.file.model;

import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class DirectoryInfo extends PathUnitInfo {

    public static DirectoryInfo _loadFromFile(File directory) {
        DirectoryInfo result = new DirectoryInfo();
        result.setType(PathUnitTypeEnum.DIRECTORY);
        result.setName(directory.getName());
        result.setFullName(directory.getPath());
        return result;
    }

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
