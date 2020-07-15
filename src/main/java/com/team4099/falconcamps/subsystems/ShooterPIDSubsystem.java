package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.annotations.Log;

public class ShooterPIDSubsystem extends PIDSubsystem {
    @Log private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log private final CANEncoder shooterEncoder = shooterLeader.getEncoder();

    public ShooterPIDSubsystem() {
        super(new PIDController(0, 0, 0));
        shooterFollower.follow(shooterLeader);
    }

    @Override
    public void periodic() {}

    @Override
    protected void useOutput(double output, double setpoint) {
       shooterLeader.set(output); 
    }

    @Override
    protected double getMeasurement() {
        
        return shooterEncoder.getVelocity();
    }
}
