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
import java.util.Date as Date
import java.util.TimeZone as TimeZone
import java.text.DateFormat as DateFormat
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import groovy.time.TimeCategory as TimeCategory

//CustomKeywords.'custom_keyword.keywords.login'()

//WebUI.delay(2)

//WebUI.getText(findTestObject('Activity/Start time'))

//WebUI.getText(findTestObject('Activity/End time')) // format of the date

String format = 'dd-MMM-yyyy'

long time = '1598457515'

static String convertUnixTimeStampToDateOrTime(long time, String format) {
    Date date = new Date(time * 1000)

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault())

    print(simpleDateFormat.format(date))
	
}

