package testSmellDetection.detector;

import testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MagicNumberTestInfo;

import java.util.ArrayList;

public interface IDetector {
    ArrayList<GeneralFixtureInfo> executeDetectionForGeneralFixture();

    ArrayList<EagerTestInfo> executeDetectionForEagerTest();

    ArrayList<LackOfCohesionInfo> executeDetectionForLackOfCohesion();

    ArrayList<MagicNumberTestInfo> executeDetectionForMagicNumber();
}
