package com.mervyn.sparrow.system.infrastructure;

import com.mervyn.sparrow.common.enums.SystemEnum;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class EnumConverter {

    @Named("genderMapping")
    public String toGender(Integer gender) {
        return SystemEnum.GENDER.getDesc(gender);
    }

    @Named("statusMapping")
    public String toStatus(String status) {
        return SystemEnum.CommonStatus.getDesc(status);
    }

}
