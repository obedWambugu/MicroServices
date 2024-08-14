package com.wambuguobed.user_service.VO;

import com.wambuguobed.user_service.entity.DepartmentUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private DepartmentUser departmentUser;
    private Department department;

}
