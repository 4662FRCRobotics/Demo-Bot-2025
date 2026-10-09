// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BlowerConstants;

public class Blower extends SubsystemBase {
  private WPI_TalonSRX m_Blower;
  /** Creates a new Blower. */
  public Blower() {
    m_Blower = new WPI_TalonSRX(BlowerConstants.kBlower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command runBlower() {
    return Commands.run(()-> m_Blower.setVoltage(BlowerConstants.kBlowerVoltage) , this);
  }

  public Command stopBlower() {
    return Commands.run(()-> m_Blower.setVoltage(0) , this);
  }

}
