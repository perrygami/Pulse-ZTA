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

Gateway_name = result[0].name

Gateway_value = result[0].actual_value

Gateway_totalvalue = result[0].total_value

UI_gateway = WebUI.getText(findTestObject('Summary Panel/Gateways'))

print(UI_gateway)

inputs = UI_gateway.split(" ");

for (int i=0; i<inputs.length; i++) {

   System.out.println("a[" + i + "] = \"" + inputs[i] + '"');

}

//String[] g = UI_gateway.split(':')
//
//WebUI.verifyEqual(Gateway_name, g[0])
//
//WebUI.verifyEqual(Gateway_value, g[1])
//
//WebUI.verifyEqual(Gateway_totalvalue, g[2])



User_name = result[0].name

Users_value = result[0].actual_value

Users_totalvalue = result[0].total_value

UI_users = WebUI.getText(findTestObject('Summary Panel/Users'))

print(UI_users)

//String[] u = UI_users.split(':')
//
//WebUI.verifyEqual(User_name, u[0])
//
//WebUI.verifyEqual(Users_value, u[1])
//
//WebUI.verifyEqual(Users_totalvalue, u[2])

