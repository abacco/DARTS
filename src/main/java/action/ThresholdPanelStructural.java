package action;

import com.intellij.openapi.project.Project;
import testSmellDetection.detector.IDetector;
import testSmellDetection.detector.TestSmellStructuralDetector;
import testSmellDetection.testSmellInfo.DuplicateAssert.DuplicateAssertInfo;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.ExceptionHandlingInfo;
import testSmellDetection.testSmellInfo.IgnoredTest.IgnoredTestInfo;
import testSmellDetection.testSmellInfo.conditionalTestLogic.CondTestLogicInfo;
import testSmellDetection.testSmellInfo.constructorInitialization.ConstructorInitializationInfo;
import testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MagicNumberTestInfo;
import windowCommitConstruction.CommitWindowFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ThresholdPanelStructural extends JFrame {

    private JLabel exceptionHandlingThresh = new JLabel("Enter threshold for the Exception Handling smell (0-5): ");
    private JLabel conditionalTestThresh = new JLabel("Enter threshold for Conditional Test Logic smell (0-5): ");
    private JTextField exceptionHandlingValue = new JTextField(20);
    private JTextField conditionalTestValue = new JTextField(20);
    private JButton enterButton = new JButton("Enter");

    // Components for the error popup
    private static JFrame f;
    private static JButton b;
    private static JLabel l;

    private Project p;

    private int valOfExceptionHandling, valOfCondTest;

    public JButton getEnterButton() {
        return enterButton;
    }

    public void setValOfExceptionHandling(int valOfExceptionHandling) {
        this.valOfExceptionHandling = valOfExceptionHandling;
    }

    public void setValOfCondTest(int valOfCondTest) {
        this.valOfCondTest = valOfCondTest;
    }

    public ThresholdPanelStructural(Project p) {
        super("DARTS2.0 - Threshold Panel");

        this.p = p;

        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(exceptionHandlingThresh, constraints);

        constraints.gridx = 1;
        newPanel.add(exceptionHandlingValue, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(conditionalTestThresh, constraints);

        constraints.gridx = 1;
        newPanel.add(conditionalTestValue, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(enterButton, constraints);

        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Threshold Panel"));

        add(newPanel);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void setListener(JButton enterButton){

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // range da 0 a 5
                valOfExceptionHandling = Integer.parseInt(exceptionHandlingValue.getText());
                valOfCondTest = Integer.parseInt(conditionalTestValue.getText());
                
                if ((valOfExceptionHandling < 0 || valOfExceptionHandling > 5) || (valOfCondTest < 0 || valOfCondTest > 5)) {

                    f = new JFrame("Error Popup");
                    l = new JLabel("Value Error - range is from 0 to 5");
                    b = new JButton("Ok");

                    JPanel p = new JPanel();

                    p.add(l);
                    p.add(b);

                    f.add(p);
                    f.setSize(230, 100);
                    f.setVisible(true);

                    b.addActionListener(actionEvent1 -> f.dispose());

                } else {
                    setValOfCondTest(valOfCondTest);
                    setValOfExceptionHandling(valOfExceptionHandling);

                    ThresholdPanelStructural.super.dispose();

                    IDetector detector = new TestSmellStructuralDetector(p);
                    ArrayList<GeneralFixtureInfo> generalFixtureInfos = detector.executeDetectionForGeneralFixture();
                    ArrayList<EagerTestInfo> eagerTestInfos = detector.executeDetectionForEagerTest();
                    ArrayList<LackOfCohesionInfo> lackOfCohesionInfos = detector.executeDetectionForLackOfCohesion();
                    //Magic Number
                    ArrayList<MagicNumberTestInfo> magicNumberTestInfos = detector.executeDetectionForMagicNumber();
                    //Conditional Test Logic
                    ArrayList<CondTestLogicInfo> condTestLogicInfos = detector.executeDetectionForCondTestLogic(valOfCondTest);
                    // ConstructorInitialization
                    ArrayList<ConstructorInitializationInfo> constructorInitializationInfos = detector.executeDetectionForConstructorInitialization();
                    // Exception Handling
                    ArrayList<ExceptionHandlingInfo> exceptionHandlingInfos = detector.executeDetectionForExceptionHandling(valOfExceptionHandling);
                    // Duplicate Assert
                    ArrayList<DuplicateAssertInfo> duplicateAssertInfos= detector.executeDetectionForDuplicateAssertInfo();
                    //Ignored Test
                    ArrayList<IgnoredTestInfo> ignoredTestInfos = detector.executeDetectionForIgnoredTestInfo();

                    if (generalFixtureInfos.isEmpty()
                            && eagerTestInfos.isEmpty()
                            && lackOfCohesionInfos.isEmpty()
                            && magicNumberTestInfos.isEmpty()
                            && condTestLogicInfos.isEmpty()
                            && exceptionHandlingInfos.isEmpty()
                            && constructorInitializationInfos.isEmpty()
                            && duplicateAssertInfos.isEmpty()
                            && ignoredTestInfos.isEmpty()) {
                        System.out.println("\n Non si è trovato alcuno Smell");

                    } else {
                        CommitWindowFactory.createWindow(false, true, p,
                                generalFixtureInfos,
                                eagerTestInfos,
                                lackOfCohesionInfos,
                                magicNumberTestInfos,
                                condTestLogicInfos,
                                constructorInitializationInfos,
                                exceptionHandlingInfos,
                                duplicateAssertInfos,
                                ignoredTestInfos);
                    }
                }
            }
        });
    }
}
