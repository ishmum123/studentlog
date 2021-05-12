package com.ideal.studentlog.helpers.mappers;

import com.ideal.studentlog.database.models.LeaveApplication;
import com.ideal.studentlog.helpers.dtos.LeaveApplicationCreateDTO;
import com.ideal.studentlog.helpers.dtos.LeaveApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LeaveApplicationMapper {
    LeaveApplicationMapper INSTANCE = Mappers.getMapper(LeaveApplicationMapper.class);


    @Mapping(target = "decisionById", source = "decisionBy.id")
    @Mapping(target = "studentId", source = "student.id")
    LeaveApplicationDTO leaveApplicationToLeaveApplicationDto(LeaveApplication leaveApplication);
    void leaveApplicationDtoToLeaveApplication(LeaveApplicationDTO dto, @MappingTarget LeaveApplication leaveApplication);
    void leaveApplicationCreateDtoToLeaveApplication(LeaveApplicationCreateDTO dto, @MappingTarget LeaveApplication leaveApplication);
}
