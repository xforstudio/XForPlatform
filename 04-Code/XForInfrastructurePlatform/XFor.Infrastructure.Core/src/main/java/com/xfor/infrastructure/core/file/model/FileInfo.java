package com.xfor.infrastructure.core.file.model;

import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class FileInfo extends PathUnitInfo {

    public static FileInfo _loadFromFile(File file) {
        FileInfo result = new FileInfo();
        result.setType(PathUnitTypeEnum.FILE);
        result.setName(file.getName());
        result.setFullName(file.getPath());
        return result;
    }

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
