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
    public static Object BOAddon
     
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
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            serverTarget = selectedVariables['serverTarget']
            orderType = selectedVariables['orderType']
            timeZone = selectedVariables['timeZone']
            BOPersonal = selectedVariables['BOPersonal']
            BOAddon = selectedVariables['BOAddon']
            BORetail = selectedVariables['BORetail']
            BOShow = selectedVariables['BOShow']
            BOOnlineoutlet = selectedVariables['BOOnlineoutlet']
            BOEmployee = selectedVariables['BOEmployee']
            CCPersonal = selectedVariables['CCPersonal']
            CCRetail = selectedVariables['CCRetail']
            CCShow = selectedVariables['CCShow']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
