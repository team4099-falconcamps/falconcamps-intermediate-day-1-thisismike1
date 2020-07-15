package com.team4099.falconcamps;

import com.team4099.falconcamps.commands.shooter.ShootPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShootSparkPIDCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;
import com.team4099.falconcamps.commands.shooter.ShooterSparkPIDIdleCommand;
import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.subsystems.ShooterSparkPID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class RobotContainer implements Loggable{ 
    @Log private final ShooterPIDSubsystem subsystem = new ShooterPIDSubsystem();
     @Log private final ShooterSparkPID shooterSpark = new ShooterSparkPID();
    XboxController driverController = new XboxController(0);
    public RobotContainer() {
        //new Trigger(driverController::getAButton).whenActive(new ShootPIDSubsystemCommand(subsystem));
        //subsystem.setDefaultCommand(new ShooterPIDSubsystemIdleCommand(subsystem));
        new Trigger(driverController::getAButton).whenActive(new ShootSparkPIDCommand(shooterSpark));
        shooterSpark.setDefaultCommand(new ShooterSparkPIDIdleCommand(shooterSpark));
    }
}
