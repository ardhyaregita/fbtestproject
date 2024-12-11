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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.facebook.com/login')

WebUI.waitForPageLoad(3)

WebUI.verifyElementText(findTestObject('Page_Log in to Facebook/div_Log in to Facebook'), 'Log in to Facebook')

WebUI.verifyElementVisible(findTestObject('Page_Facebook  log in or sign up/input_Facebook helps you connect and share with the people in your life_email'))

WebUI.verifyElementVisible(findTestObject('Page_Facebook  log in or sign up/input_Facebook helps you connect and share with the people in your life_pass'))

WebUI.click(findTestObject('Page_Facebook  log in or sign up/button_Log in'))

//Validasi error message ketika user tidak input email dan password

WebUI.verifyTextPresent('The email address or mobile number you entered isn\'t connected to an account. Find your account and log in.', 
    false)

//Validasi error message ketika user input email tidak terdaftar

WebUI.setText(findTestObject('Page_Facebook  log in or sign up/input_Facebook helps you connect and share with the people in your life_email'), 
    'mawarmelati@dahlia.com')

WebUI.setText(findTestObject('Page_Facebook  log in or sign up/input_Facebook helps you connect and share with the people in your life_pass'), 
    'fbmawar2024@')

WebUI.click(findTestObject('Page_Facebook  log in or sign up/button_Log in'))

WebUI.verifyTextPresent('The email address you entered isn\'t connected to an account. Find your account and log in.',
	false)



WebUI.waitForPageLoad(5)

WebUI.closeBrowser()

