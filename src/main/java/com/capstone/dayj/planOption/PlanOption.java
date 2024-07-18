package com.capstone.dayj.planOption;

import com.capstone.dayj.common.BaseEntity;
import com.capstone.dayj.plan.Plan;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.lang.annotation.RequiredTypes;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true, exclude = {"plan"})
public class PlanOption extends BaseEntity {
    @Id
    private int id;
    private LocalDateTime planStartTime;
    private LocalDateTime planEndTime;
    private LocalDateTime planAlarmTime;
    private LocalDateTime planRepeatStartDate;
    private LocalDateTime planRepeatEndDate;
    private List<DayOfWeek> planDaysOfWeek;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private Plan plan;
    
    public void update(LocalDateTime planStartTime, LocalDateTime planEndTime, LocalDateTime planAlarmTime, LocalDateTime planRepeatStartDate, LocalDateTime planRepeatEndDate, List<DayOfWeek> planDaysOfWeek) {
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.planAlarmTime = planAlarmTime;
        this.planRepeatStartDate = planRepeatStartDate;
        this.planRepeatEndDate = planRepeatEndDate;
        this.planDaysOfWeek = planDaysOfWeek;
    }
    
    @Builder
    public PlanOption(int id, LocalDateTime planStartTime, LocalDateTime planEndTime, LocalDateTime planAlarmTime, LocalDateTime planRepeatStartDate, LocalDateTime planRepeatEndDate, List<DayOfWeek> planDaysOfWeek, Plan plan) {
        this.id = id;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.planAlarmTime = planAlarmTime;
        this.planRepeatStartDate = planRepeatStartDate;
        this.planRepeatEndDate = planRepeatEndDate;
        this.planDaysOfWeek = planDaysOfWeek;
        this.plan = plan;
    }
}
