package custom_keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return
import org.junit.After as After

import com.kms.katalon.core.testobject.ConditionType as ConditionType

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


public class keywords {
	
	
	@Keyword
	def login()
	{
		WebUI.openBrowser('')
		
		WebUI.maximizeWindow()
		
		WebUI.navigateToUrl(GlobalVariable.URL)
		
		WebUI.delay(3)
		
		WebUI.setText(findTestObject('Login objects/username'), GlobalVariable.username)
		
		WebUI.setText(findTestObject('Login objects/password'), GlobalVariable.password)
		
		WebUI.sendKeys(findTestObject('Login objects/singin button'), Keys.chord(Keys.ENTER))
		
		
		
	}
	
	@Keyword 
	
	def JSON_Reading()  {
		//return json result
		
		def slurper = new JsonSlurper()
		
		File jsontxt = new File('/Users/perry.gami/Downloads/config_008.json')
		
		def result = slurper.parse(jsontxt)
		
		return result
	}
	
	@Keyword
	
	def comparing_data() {
		
		try {
			ArrayList<String> UI = new ArrayList<String>()
		
			ArrayList<String> JSON_Name = new ArrayList<String>()
		
			ArrayList<String> JSON_Value = new ArrayList<String>()
		
			for (int i = 0; i < 2; i++) {
				(JSON_Name[i]) = result.buckets[i].name
		
				(JSON_Value[i]) = result.buckets[i].value
		
				//print("name is " + JSON[i]  )
				String css = String css = ('#dashboard-l1-anomalies-chart > div:nth-child(2) > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(1) > g > g:nth-child(1) > g > g:nth-child(1) > g:nth-child(2) > g:nth-child(3) > g > g:nth-child(' + 
        (i + 1)) + ') > g > g > g > g > g > g > g > g > path'
		
				//String css = '#topRiskyUsersChart > div:nth-child(2) > svg > g > g.amcharts-Container > g.amcharts-Sprite-group.amcharts-Container-group.amcharts-Component-group.amcharts-Chart-group.amcharts-SerialChart-group.amcharts-XYChart-group > g > g:nth-child(2) > g > g > g > g:nth-child(1) > g > g:nth-child(1) > g.amcharts-Container > g:nth-child(3) > g > g > g > g.amcharts-Sprite-group.amcharts-Container-group > g > g > g > g:nth-child(' + i + ')'
				myTestOject = new TestObject('customObject')
		
				myTestOject.addProperty('css', ConditionType.EQUALS, css)
		
				System.out.println(css)
		
				WebUI.mouseOver(myTestOject)
		
				try {
					Tooltip = new TestObject('customObject')
		
					Tooltip.addProperty('css', ConditionType.EQUALS, '#dashboard-l1-anomalies-chart > div:nth-child(2) > svg > g > g:nth-child(2) > g:nth-child(2) > g > g:nth-child(6) > g:nth-child(2) > g > g > text > tspan')
		
					(UI[(i + 1)]) = WebUI.getText(Tooltip)
		
					print(UI[(i + 1)])
		
					String[] a = (UI[(i + 1)]).split(':')
		
					System.out.println(a[0])
		
					WebUI.verifyMatch(a[0], JSON_Name[i], false)
		
					System.out.println((a[1]) + (JSON_Value[i]))
		
					WebUI.verifyEqual((a[1]).trim(), JSON_Value[i] //if (JSON_Value[i].compareTo(a[1])){
						) //	print("values are matched")
					//}
					//else {
					//	print("values are not matched")
					//}
					//WebUI.verifyMatch(a[1], JSON_Value[i], false)
				}
				catch (Exception e) {
					e.print('No tooltip found')
				}
			}
		}
		catch (Exception e) {
			e.print('test end')
		}
		
		
	}
}

