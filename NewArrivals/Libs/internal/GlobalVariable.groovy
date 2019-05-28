package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object serverTarget
     
    /**
     * <p></p>
     */
    public static Object orderType
     
    /**
     * <p></p>
     */
    public static Object timeZone
     
    /**
     * <p></p>
     */
    public static Object BOPersonal
     
    /**
     * <p></p>
     */
    public static Object BOAddonPersonal
     
    /**
     * <p></p>
     */
    public static Object BORetail
     
    /**
     * <p></p>
     */
    public static Object BOShow
     
    /**
     * <p></p>
     */
    public static Object BOOnlineoutlet
     
    /**
     * <p></p>
     */
    public static Object BOEmployee
     
    /**
     * <p></p>
     */
    public static Object CCPersonal
     
    /**
     * <p></p>
     */
    public static Object CCRetail
     
    /**
     * <p></p>
     */
    public static Object CCShow
     
    /**
     * <p></p>
     */
    public static Object addOnOrderId
     
    /**
     * <p></p>
     */
    public static Object BOAddonRetail
     
    /**
     * <p></p>
     */
    public static Object BOEblast
     
    /**
     * <p></p>
     */
    public static Object controlParallelism
     
    /**
     * <p></p>
     */
    public static Object parallelTC
     
    /**
     * <p></p>
     */
    public static Object retailOrderID
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            serverTarget = selectedVariables['serverTarget']
            orderType = selectedVariables['orderType']
            timeZone = selectedVariables['timeZone']
            BOPersonal = selectedVariables['BOPersonal']
            BOAddonPersonal = selectedVariables['BOAddonPersonal']
            BORetail = selectedVariables['BORetail']
            BOShow = selectedVariables['BOShow']
            BOOnlineoutlet = selectedVariables['BOOnlineoutlet']
            BOEmployee = selectedVariables['BOEmployee']
            CCPersonal = selectedVariables['CCPersonal']
            CCRetail = selectedVariables['CCRetail']
            CCShow = selectedVariables['CCShow']
            addOnOrderId = selectedVariables['addOnOrderId']
            BOAddonRetail = selectedVariables['BOAddonRetail']
            BOEblast = selectedVariables['BOEblast']
            controlParallelism = selectedVariables['controlParallelism']
            parallelTC = selectedVariables['parallelTC']
            retailOrderID = selectedVariables['retailOrderID']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
