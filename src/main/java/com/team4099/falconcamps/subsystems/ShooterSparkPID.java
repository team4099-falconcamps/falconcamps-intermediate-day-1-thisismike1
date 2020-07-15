package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class ShooterSparkPID extends SubsystemBase implements Loggable {
    @Log private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    @Log private final CANPIDController pidController = shooterFollower.getPIDController();
    @Log private double targetVelocity = 0.0; 
    public ShooterSparkPID() {
        shooterFollower.follow(shooterLeader, true);
        pidController.setP(1.7/300);
        pidController.setI(0.0);
        pidController.setD(5.5*14000);
    }
    public void setTargetVelocity(double Velocity){
        targetVelocity = Velocity;
    }
    @Override
    public void periodic() {
        pidController.setReference(targetVelocity, ControlType.kVelocity);
    }
}
