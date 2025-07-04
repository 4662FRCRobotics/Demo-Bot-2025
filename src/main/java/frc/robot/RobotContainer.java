// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Subsystems.Drive;

public class RobotContainer {
  private final Drive m_Drive = new Drive();
  private final CommandXboxController m_driverController = new CommandXboxController(ControllerConstants.kDRIVECONTROLLERPORT);

  public RobotContainer() {
    m_Drive.setDefaultCommand(
      Commands.run(
        () -> m_Drive.arcadeDrive(m_driverController.getLeftY(), m_driverController.getRightX()),
        m_Drive));
   
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
