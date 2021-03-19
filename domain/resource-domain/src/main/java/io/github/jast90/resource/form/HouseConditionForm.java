package io.github.jast90.resource.form;

import io.github.jast90.resource.entity.House;

import java.util.List;

/**
 * Created by jast90 on 2021/3/17
 */
public class HouseConditionForm extends House {
    private List<Long> houseIds;

    public List<Long> getHouseIds() {
        return houseIds;
    }

    public void setHouseIds(List<Long> houseIds) {
        this.houseIds = houseIds;
    }
}
