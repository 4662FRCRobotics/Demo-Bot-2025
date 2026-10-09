// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drive extends SubsystemBase {
  private WPI_TalonSRX m_right;
  private WPI_TalonSRX m_left;
  private WPI_TalonSRX m_right2;
  private WPI_TalonSRX m_left2;
  private DifferentialDrive m_DifferentialDrive;
  
  /** Creates a new Drive. */
  public Drive() {
    m_right = new WPI_TalonSRX(DriveConstants.kRIGHTDRIVETALON);
    m_right.setInverted(DriveConstants.kISINVERTED);
    m_right2 = new WPI_TalonSRX(DriveConstants.kRIGHTDRIVETALONBACK);
    m_right2.setInverted(DriveConstants.kISINVERTED);
    m_left = new WPI_TalonSRX(DriveConstants.kLEFTDRIVETALON);
    m_left.setInverted(!DriveConstants.kISINVERTED);
    m_left2 = new WPI_TalonSRX(DriveConstants.kLEFTDRIVETALONBACK);
    m_left2.setInverted(!DriveConstants.kISINVERTED);
    m_DifferentialDrive = new DifferentialDrive(m_left, m_right);
    m_right2.follow(m_right);
    m_left2.follow(m_left);
  }

  public void arcadeDrive(double velocity, double heading){
    m_DifferentialDrive.arcadeDrive(velocity * DriveConstants.kTHROTTLE, heading * DriveConstants.KTURN_THROTTLE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
