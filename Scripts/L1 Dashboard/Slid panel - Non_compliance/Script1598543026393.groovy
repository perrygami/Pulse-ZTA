import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.By as By
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

CustomKeywords.'custom_keyword.keywords.login'()

WebUI.click(findTestObject('Summary Panel/Non-complaince'))

WebUI.delay(2)

count = WebUI.getText(findTestObject('count'))

println('Count of Non Compilance = ' + count)

try {
    ArrayList<String> UI = new ArrayList<String>()

    for (int i = 1; i <= count.toInteger(); i++) {
        String poilcyCss = ('#info-panel > div > div:nth-child(2) > div:nth-child(' + i) + ') > div.dashboard-sidepanel__content-panel > div > div:nth-child(1) > div:nth-child(1) > div > div.dashboard-sidepanel__value'

        String deviceTypeCss = ('#info-panel > div > div:nth-child(2) > div:nth-child(' + i) + ') > div.dashboard-sidepanel__content-panel > div > div:nth-child(1) > div:nth-child(2) > div > div.dashboard-sidepanel__value'

        String applicationNameCss = ('#info-panel > div > div:nth-child(2) > div:nth-child(' + i) + ') > div.dashboard-sidepanel__content-panel > div > div:nth-child(2) > div > div > div.dashboard-sidepanel__value'

        String deviceIdCss = ('#info-panel > div > div:nth-child(2) > div:nth-child(' + i) + ') > div.dashboard-sidepanel__content-panel > div > div:nth-child(3) > div > div > div.dashboard-sidepanel__value'

        //String css = '#topRiskyUsersChart > div:nth-child(2) > svg > g > g.amcharts-Container > g.amcharts-Sprite-group.amcharts-Container-group.amcharts-Component-group.amcharts-Chart-group.amcharts-SerialChart-group.amcharts-XYChart-group > g > g:nth-child(2) > g > g > g > g:nth-child(1) > g > g:nth-child(1) > g.amcharts-Container > g:nth-child(3) > g > g > g > g.amcharts-Sprite-group.amcharts-Container-group > g > g > g > g:nth-child(' + i + ')'
        String jsonFile = '/Users/perry.gami/Downloads/slidepanel_noncompliance.json'

        def slurper = new JsonSlurper()

        File jsontxt = new File(System.getProperty('user.dir') + '/JSON/Slidpanel_noncompliance.json')

        def result = slurper.parse(jsontxt)

        ArrayList<String> webAppName = new ArrayList<String>()

        WebapplicationName = new TestObject('customObject')

        WebapplicationName.addProperty('css', ConditionType.EQUALS, applicationNameCss)

        WebapplicationName = WebUI.getText(WebapplicationName)

        (webAppName[i]) = WebapplicationName

        println('App Name from Web : ' + (webAppName[i]))

        ArrayList<String> jsonApplicationName = new ArrayList<String>()

        (jsonApplicationName[i]) = result.info_panel_items[(i - 1)].application_name

        println((('Activity Name from JSON : ' + i) + ' ') + (jsonApplicationName[i]))

        //WebUI.verifyMatch(webAppName[i], jsonApplicationName[i], false)
        if ((webAppName[i]) == (jsonApplicationName[i])) {
            println(((('Application Name from Web is : ' + (webAppName[i])) + ' and Application Name from JSON is : ') + 
                (jsonApplicationName[i])) + ' thus, it is correct')
        } else {
            println(((('Application Name from Web is : ' + (webAppName[i])) + ' and Application Name from JSON is : ') + 
                (jsonApplicationName[i])) + ' thus, it is in-correct')
        }
        
        ArrayList<String> webPolicyName = new ArrayList<String>()

        webPolicy = new TestObject('customObject')

        webPolicy.addProperty('css', ConditionType.EQUALS, poilcyCss)

        webPolicy = WebUI.getText(webPolicy)

        (webPolicyName[i]) = webPolicy

        println('Policy Name from Web : ' + (webPolicyName[i]))

        ArrayList<String> jsonPolicyName = new ArrayList<String>()

        (jsonPolicyName[i]) = result.info_panel_items[(i - 1)].non_compliance_policy_name

        println((('Activity Name from JSON : ' + i) + ' ') + (jsonPolicyName[i]))

        //WebUI.verifyMatch(webAppName[i], jsonApplicationName[i], false)
        if ((webPolicyName[i]) == (jsonPolicyName[i])) {
            println(((('Policy Name from Web is : ' + (webPolicyName[i])) + ' and Policy Name from JSON is : ') + (jsonPolicyName[
                i])) + ' thus, it is correct')
        } else {
            println(((('Policy Name from Web is : ' + (webPolicyName[i])) + ' and Policy Name from JSON is : ') + (jsonPolicyName[
                i])) + ' thus, it is in-correct')
        }
        
        ArrayList<String> webDeviceType = new ArrayList<String>()

        webDeviceTypeObject = new TestObject('customObject')

        webDeviceTypeObject.addProperty('css', ConditionType.EQUALS, deviceTypeCss)

        webDeviceTypeObject = WebUI.getText(webDeviceTypeObject)

        (webDeviceType[i]) = webDeviceTypeObject

        println('Device Type from Web : ' + (webDeviceType[i]))

        ArrayList<String> jsonDeviceType = new ArrayList<String>()

        (jsonDeviceType[i]) = result.info_panel_items[(i - 1)].device_type

        println((('Device Type from JSON : ' + i) + ' ') + (jsonDeviceType[i]))

        //WebUI.verifyMatch(webAppName[i], jsonApplicationName[i], false)
        if ((webDeviceType[i]) == (jsonDeviceType[i])) {
            println(((('Device Type  from Web is : ' + (webDeviceType[i])) + ' and Device Type from JSON is : ') + (jsonDeviceType[
                i])) + ' thus, it is correct')
        } else {
            println(((('Device Type from Web is : ' + (webDeviceType[i])) + ' and Device Type from JSON is : ') + (jsonDeviceType[
                i])) + ' thus, it is in-correct')
        }
        
        ArrayList<String> webDeviceId = new ArrayList<String>()

        webDeviceIdObject = new TestObject('customObject')

        webDeviceIdObject.addProperty('css', ConditionType.EQUALS, deviceIdCss)

        webDeviceIdObject = WebUI.getText(webDeviceIdObject)

        (webDeviceId[i]) = webDeviceIdObject

        println('Device Id from Web : ' + (webDeviceId[i]))

        ArrayList<String> jsonDeviceId = new ArrayList<String>()

        (jsonDeviceId[i]) = result.info_panel_items[(i - 1)].device_id

        println((('Device Id from JSON : ' + i) + ' ') + (jsonDeviceId[i]))

        //WebUI.verifyMatch(webAppName[i], jsonApplicationName[i], false)
        if ((webDeviceId[i]) == (jsonDeviceId[i])) {
            println(((('Device Id from Web is : ' + (webDeviceId[i])) + ' and Device Id from JSON is : ') + (jsonDeviceId[
                i])) + ' thus, it is correct')
        } else {
            println(((('Device Id from Web is : ' + (webDeviceId[i])) + ' and Device Id from JSON is : ') + (jsonDeviceId[
                i])) + ' thus, it is in-correct')
        }
    }
}
catch (Exception e) {
    e.print('test end')

    e.printStackTrace()
} 

