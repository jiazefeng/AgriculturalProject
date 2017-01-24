package com.agricultural.domain.breed.dto;

import com.agricultural.page.PageInfoTools;

/**
 * Created by Talent on 2017/1/24.
 */
public class BreedDTO extends PageInfoTools {
    private String breedId;//ID
    private String breedNum;//数量
    private String breedHomeNum;//牛舍号
    private String breedType;//类型

    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    public String getBreedNum() {
        return breedNum;
    }

    public void setBreedNum(String breedNum) {
        this.breedNum = breedNum;
    }

    public String getBreedHomeNum() {
        return breedHomeNum;
    }

    public void setBreedHomeNum(String breedHomeNum) {
        this.breedHomeNum = breedHomeNum;
    }

    public String getBreedType() {
        return breedType;
    }

    public void setBreedType(String breedType) {
        this.breedType = breedType;
    }
}
