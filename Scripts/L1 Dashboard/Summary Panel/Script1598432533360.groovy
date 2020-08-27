import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.ConditionType as ConditionType

CustomKeywords.'custom_keyword.keywords.login'()

WebUI.delay(2)

def slurper = new JsonSlurper()

File jsontxt = new File('/Users/perry.gami/Downloads/summary_panel.json')

def result = slurper.parse(jsontxt)

// For gateway
Gateway_name = result[0].name

Gateway_value = result[0].actual_value

Gateway_totalvalue = result[0].total_value

UI_gateway = WebUI.getText(findTestObject('Summary Panel/Gateways'))

print(UI_gateway)

g = UI_gateway.split(' ')

for (int i = 0; i < g.length; i++) {
    System.out.println(((('g[' + i) + '] = "') + (g[i])) + '"')
}

final_string1 = (g[2]).substring(0, 1)

WebUI.verifyEqual(Gateway_value, g[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(Gateway_totalvalue, final_string1, FailureHandling.CONTINUE_ON_FAILURE)

//for users
User_name = result[1].name

Users_value = result[1].actual_value

Users_totalvalue = result[1].total_value

UI_users = WebUI.getText(findTestObject('Summary Panel/Users'))

print(UI_users)

u = UI_users.split(' ')

for (int i = 0; i < u.length; i++) {
    System.out.println(((('u[' + i) + '] = "') + (u[i])) + '"')
}

final_string1 = (u[2]).substring(0, 1)

WebUI.verifyEqual(Users_value, u[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(Users_totalvalue, final_string1, FailureHandling.CONTINUE_ON_FAILURE)

// for devices
Device_name = result[2].name

Device_value = result[2].actual_value

Device_totalvalue = result[2].total_value

UI_devices = WebUI.getText(findTestObject('Summary Panel/Devices'))

print(UI_devices)

d = UI_devices.split(' ')

for (int i = 0; i < d.length; i++) {
    System.out.println(((('d[' + i) + '] = "') + (d[i])) + '"')
}

final_string3 = (d[2]).substring(0, 1)

WebUI.verifyEqual(Device_value, d[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(Device_totalvalue, final_string3, FailureHandling.CONTINUE_ON_FAILURE)

// for Applications
Application_name = result[3].name

Application_value = result[3].actual_value

Application_totalvalue = result[3].total_value

UI_Applications = WebUI.getText(findTestObject('Summary Panel/Applications'))

print(UI_Applications)

a = UI_Applications.split(' ')

for (int i = 0; i < a.length; i++) {
    System.out.println(((('a[' + i) + '] = "') + (a[i])) + '"')
}

final_string4 = (a[2]).substring(0, 1)

WebUI.verifyEqual(Application_value, a[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(Application_totalvalue, final_string4, FailureHandling.CONTINUE_ON_FAILURE)

// for non-compliance
non_compliance_name = result[4].name

non_compliance_value = result[4].actual_value

non_compliance_totalvalue = result[4].total_value

UI_non_compliance = WebUI.getText(findTestObject('Summary Panel/Non-complaince'))

print(UI_non_compliance)

n = UI_non_compliance.split(' ')

for (int i = 0; i < n.length; i++) {
    System.out.println(((('n[' + i) + '] = "') + (n[i])) + '"')
}

final_string5 = (n[2]).substring(0, 1)

WebUI.verifyEqual(non_compliance_value, n[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(non_compliance_totalvalue, final_string5, FailureHandling.CONTINUE_ON_FAILURE)

// for anomalies
anomalies_name = result[5].name

anomalies_value = result[5].actual_value

anomalies_totalvalue = result[5].total_value

UI_anomalies = WebUI.getText(findTestObject('Summary Panel/Anomalies'))

print(UI_anomalies)

aa = UI_anomalies.split(' ')

for (int i = 0; i < aa.length; i++) {
    System.out.println(((('aa[' + i) + '] = "') + (aa[i])) + '"')
}

final_string6 = (aa[2]).substring(0, 1)

WebUI.verifyEqual(anomalies_value, aa[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(anomalies_totalvalue, final_string5, FailureHandling.CONTINUE_ON_FAILURE)

