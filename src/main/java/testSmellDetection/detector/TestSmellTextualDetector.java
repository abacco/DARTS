package testSmellDetection.detector;

import com.intellij.openapi.project.Project;
import contextualAnalysis.hashUtilies.ProductionClassesSingleton;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import testSmellDetection.testSmellInfo.eagerTest.MethodWithEagerTest;
import testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import testSmellDetection.testSmellInfo.generalFixture.MethodWithGeneralFixture;
import testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MagicNumberTestInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;
import testSmellDetection.textualRules.EagerTestTextual;
import testSmellDetection.textualRules.GeneralFixtureTextual;
import testSmellDetection.textualRules.LackOfCohesionOfTestSmellTextual;
import testSmellDetection.textualRules.MagicNumberTextual;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class TestSmellTextualDetector implements IDetector{
    private ArrayList<PsiClassBean> classBeans;
    private ArrayList<PsiClassBean> testClasses;
    private ArrayList<PsiClassBean> productionClasses;
    private ProductionClassesSingleton productionClassesSingleton;

    public TestSmellTextualDetector(Project project){
        classBeans = ConverterUtilities.getClassesFromPackages(project);
        testClasses = TestSmellUtilities.getAllTestClasses(classBeans);
        productionClasses = TestSmellUtilities.getAllProductionClasses(classBeans, testClasses);
        productionClassesSingleton = ProductionClassesSingleton.getIstance();
        productionClassesSingleton.setProductionClasses(productionClasses);
    }

    @Override
    public ArrayList<MagicNumberTestInfo> executeDetectionForMagicNumber() {
        ArrayList<MagicNumberTestInfo> classesWithMagicNumber = new ArrayList<>();
        for(PsiClassBean testClass : testClasses){
            ArrayList<MethodWithMagicNumber> methodWithMagicNumbers = MagicNumberTextual.checkMethodsThatCauseMagicNumber(testClass);
            if(methodWithMagicNumbers != null){
                classesWithMagicNumber.add(new MagicNumberTestInfo(testClass, methodWithMagicNumbers));
            }
        }
        return classesWithMagicNumber;
    }

    public ArrayList<GeneralFixtureInfo> executeDetectionForGeneralFixture() {
        ArrayList<GeneralFixtureInfo> classesWithGeneralFixture = new ArrayList<>();
        for(PsiClassBean testClass : testClasses){
            ArrayList<MethodWithGeneralFixture> methodWithGeneralFixtures = GeneralFixtureTextual.checkMethodsThatCauseGeneralFixture(testClass);
            if(methodWithGeneralFixtures != null){
                classesWithGeneralFixture.add(new GeneralFixtureInfo(testClass, methodWithGeneralFixtures));
            }
            /* OLD IMPLEMENTATION */
            /*
            if(GeneralFixtureTextual.isGeneralFixture(testClass)){
                ArrayList<MethodWithGeneralFixture> methodWithGeneralFixtures = GeneralFixtureTextual.checkMethodsThatCauseGeneralFixture(testClass);
                classesWithGeneralFixture.add(new GeneralFixtureInfo(testClass, methodWithGeneralFixtures));
            }
            */
        }
        return classesWithGeneralFixture;
    }


    public ArrayList<EagerTestInfo> executeDetectionForEagerTest() {
        ArrayList<EagerTestInfo> classesWithEagerTest = new ArrayList<>();
        for(PsiClassBean testClass : testClasses){
            if(testClass.getProductionClass() != null) {
                ArrayList<MethodWithEagerTest> methodWithEagerTests = EagerTestTextual.checkMethodsThatCauseEagerTest(testClass, testClass.getProductionClass());
                if (methodWithEagerTests != null) {
                    classesWithEagerTest.add(new EagerTestInfo(testClass, testClass.getProductionClass(), methodWithEagerTests));
                }
            }
        }
        return classesWithEagerTest;
    }


    public ArrayList<LackOfCohesionInfo> executeDetectionForLackOfCohesion() {
        ArrayList<LackOfCohesionInfo> classesWithLackOfCohesion = new ArrayList<>();
        for(PsiClassBean testClass : testClasses){
            if(testClass.getProductionClass() != null) {
                ArrayList<PsiMethodBean> methodsWithLackOfCohesion = LackOfCohesionOfTestSmellTextual.checkMethodsThatCauseLackOfCohesion(testClass);
                if (methodsWithLackOfCohesion != null) {
                    classesWithLackOfCohesion.add(new LackOfCohesionInfo(testClass, testClass.getProductionClass(), methodsWithLackOfCohesion));
                }
            }
        }
        return classesWithLackOfCohesion;
    }


}
