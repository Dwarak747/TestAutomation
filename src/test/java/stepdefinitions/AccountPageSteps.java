package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Pages.AccountsPage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class AccountPageSteps {
	
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) {
		List<Map<String,String>> credList=credTable.asMaps();
		String username=credList.get(0).get("username");
		String password=credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage=loginpage.doLogin(username, password);
		
	    
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		 
		accountsPage.getAccountsPageTitle();
		
	}

	

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String> expAccountsList=sectionsTable.asList();
		System.out.println(expAccountsList);
		
		List<String> actualAccountsList=accountsPage.getAccountSectionList();
		System.out.println(actualAccountsList);
		
		Assert.assertTrue(expAccountsList.containsAll(actualAccountsList)); 
		 
		
		
	    
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer ExpectedSectionCount) {
		 Assert.assertTrue(accountsPage.getAccountSectionCount()==ExpectedSectionCount);
	     
	}


}
